package com.aic.web;

import com.aic.pojo.*;
import com.aic.service.CartItemService;
import com.aic.service.ItemService;
import com.aic.service.OrderService;
import com.aic.service.UserService;
import com.aic.service.impl.CartItemServiceImpl;
import com.aic.service.impl.ItemServiceImpl;
import com.aic.service.impl.OrderServiceImpl;
import com.aic.service.impl.UserServiceImpl;
import com.aic.utils.WebUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 处理登录请求
 */
public class UserServlet extends BaseServlet {

    UserService userService = new UserServiceImpl();
    ItemService itemService = new ItemServiceImpl();

    CartItemService cartItemService = new CartItemServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    /**
     * 处理登录
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = userService.login(new User(null, username, password, null));
        //没有在数据库中找到匹配账号
        if(user == null){
            if(!username.equals("")) req.setAttribute("msg","用户或密码错误！");
            else req.setAttribute("msg" , "请输入账号和密码！");
            req.setAttribute("username",username);
            req.getRequestDispatcher("/pages/login.jsp").forward(req,resp);
        }else{
            // 登录成功
            // 保存登录信息
            req.getSession().setAttribute("user",user);
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }
    }

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("user");
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String repassword = req.getParameter("repassword");
        String flag;
        if(userService.existsUsername(username)){ // 账号已存在
            flag = "0";
        }
        else if("".equals(username) || "".equals(password) || !password.equals(repassword)) {// 输入为空
            flag = "1";
        }
        else{
            flag = "2";
            String email = req.getParameter("email");
            userService.registerUser(new User(null,username,password,email));
        }
        req.getSession().setAttribute("flag",flag);
        req.getRequestDispatcher("/pages/regist.jsp").forward(req,resp);
    }

    /***
     * 用户发布商品
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //判断上传的数据是否为多段（是否需要解析）
        if(ServletFileUpload.isMultipartContent(req)){
            //创建 FileItemFactory 工厂实现类
            FileItemFactory fileitemFactory = new DiskFileItemFactory();
            //创建用于解析上传数据的 ServletFileUpload 类
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileitemFactory);
            Item item = new Item();
            User user = (User) req.getSession().getAttribute("user");
            item.setSellerId(user.getId());
            //解析上传的数据,得到每一个表单项 FileItem
            try {
                List<FileItem> list = servletFileUpload.parseRequest(req);
                //遍历每一个表单项
                for(FileItem fileItem : list){
                    //普通表单
                    if(fileItem.isFormField()){
                        Field field = Item.class.getDeclaredField(fileItem.getFieldName());
                        String value = fileItem.getString("UTF-8");
                        field.setAccessible(true);
                        if(fileItem.getFieldName().equals("price")) field.set(item, new BigDecimal(value));
                        else field.set(item , value);
                    }else{
                        if(fileItem.getName().equals("")) break;
                        //上传文件的表单
                        fileItem.write(new File("/usr/local/tomcat/webapps/jiajia/static/img/" + fileItem.getName()));
                        item.setImgPath("http://121.40.162.98/jiajia/static/img/" + fileItem.getName());
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            if(item.getImgPath() == null){
                Item item1 = (Item) req.getSession().getAttribute("item");
                item.setImgPath(item1.getImgPath());
            }
            itemService.addItem(item);
            showUserItem(req,resp);
        }
    }

    protected void showAllItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Item> itemList = itemService.showAllItem();
        req.getSession().setAttribute("itemList",itemList);
        req.getRequestDispatcher("pages/allItem.jsp").forward(req,resp);
    }

    protected void showUserItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if(user == null) req.getRequestDispatcher("/pages/login.jsp").forward(req,resp); // 用户未登录
        List<Item> itemList = itemService.showUserItem(user.getId());
        req.getSession().setAttribute("itemList",itemList);
        resp.sendRedirect("http://121.40.162.98/jiajia/pages/user/itemManagement.jsp");
    }

    protected void findItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer itemId = Integer.valueOf(req.getParameter("itemId"));
        Item item = itemService.findItem(itemId);
        req.getSession().setAttribute("item",item);
        resp.sendRedirect("http://121.40.162.98/jiajia/pages/user/itemEdit.jsp");
    }

    protected void showDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer itemId = WebUtils.parseInt(req.getParameter("itemId"),0);
        Item item =  itemService.findItem(itemId);
        User seller = userService.findUserById(item.getSellerId());
        HttpSession session = req.getSession();
        itemService.addViews(itemId);
        session.setAttribute("item",item);
        session.setAttribute("seller",seller);
        req.getRequestDispatcher("pages/itemDetail.jsp").forward(req,resp);
    }

    protected void removeItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String itemId = req.getParameter("itemId");
        itemService.removeItem(WebUtils.parseInt(itemId,0));
        showUserItem(req,resp);
    }

    protected void modifyItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String itemId = req.getParameter("itemId");
        itemService.removeItem(Integer.parseInt(itemId));
        addItem(req,resp);
    }

    protected void recommend(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Item> itemList = itemService.recommend();
        req.getSession().setAttribute("itemList",itemList);
        req.getRequestDispatcher("pages/index.jsp").forward(req,resp);
    }

    protected void addItemToCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        String itemId = req.getParameter("itemId");
        User user = (User) req.getSession().getAttribute("user");
        if(user == null) req.getRequestDispatcher("/pages/login.jsp").forward(req,resp); // 用户未登录
        cartItemService.addCartItem(new CartItem(null, user.getId(), Integer.valueOf(itemId)));
        resp.sendRedirect("http://121.40.162.98/jiajia/pages/itemDetail.jsp");
    }

    protected void removeItemFromCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String itemId = req.getParameter("itemId");
        cartItemService.removeCartItem(Integer.valueOf(itemId));
        showUserCartItem(req, resp);
    }

    protected void showUserCartItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if(user == null) req.getRequestDispatcher("/pages/login.jsp").forward(req,resp); // 用户未登录
        List<CartItemDetail> cartItems = cartItemService.showUserCartItems(user.getId());
        req.getSession().setAttribute("cartItems",cartItems);
        req.getRequestDispatcher("pages/user/shoppingCart.jsp").forward(req,resp);
    }

    protected void purchaseItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if(user == null) req.getRequestDispatcher("/pages/login.jsp").forward(req,resp); // 用户未登录
        String itemId = req.getParameter("itemId");
        Item item = itemService.findItem(Integer.valueOf(itemId));
        item.setStatus(1);
        itemService.modifyItem(Integer.valueOf(itemId),item);
        String c = req.getParameter("cartItemId");
        orderService.addOrder(new Order(null, user.getId(), item.getSellerId(),new Date(),item.getId()));
        if(c != null){ // 请求来自购物车，需删除其对应的购物车项
            cartItemService.removeCartItem(Integer.valueOf(c));
        }
        resp.sendRedirect("http://121.40.162.98/jiajia/pages/user/userOrder.jsp");
    }

    protected void showUserOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if(user == null) req.getRequestDispatcher("/pages/login.jsp").forward(req,resp); // 用户未登录
        List<OrderItem> orderList = orderService.queryUserOrder(user.getId());
        req.getSession().setAttribute("orderList" , orderList);
        req.getRequestDispatcher("pages/user/userOrder.jsp").forward(req,resp);
    }

    protected void removeOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String orderId = req.getParameter("orderId");
        orderService.removeOrder(Integer.valueOf(orderId));
        showUserOrder(req, resp);
    }
}
