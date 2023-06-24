package h2tk.ecom.controller;

import h2tk.ecom.model.Cart;
import h2tk.ecom.model.Users;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class router {
    @GetMapping("/")
    public String Index(){
        return "content_page/index";
    }

    @GetMapping("/admin")
    public String Category(HttpSession session){
        Users users = (Users) session.getAttribute("user");
        if(users != null){
            if(users.getRole().getId() == 2){
                return "content_page/ManageCategory";
            }
        }
        return "content_page/login_signup";
    }

    @GetMapping("/adminManageProduct")
    public String product(HttpSession session){
        Users users = (Users) session.getAttribute("user");
        if(users != null){
            if(users.getRole().getId() == 2){
                return "content_page/ManageProduct";
            }
        }
        return "content_page/login_signup";
    }

    @GetMapping("/adminManageUser")
    public String User(HttpSession session){
        Users users = (Users) session.getAttribute("user");
        if(users != null){
            if(users.getRole().getId() == 2){
                return "content_page/ManageUser";
            }
        }
        return "content_page/login_signup";
    }

    @GetMapping("/login")
    public String UserLogin(){
        return "content_page/login_signup";
    }

    @GetMapping("/showCart")
    public String cart(){
        return "content_page/showCart";
    }
}
