package h2tk.ecom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class test {
    @GetMapping("/")
    public String Index(){
        return "content_page/index";
    }

    @GetMapping("/1")
    public String Index1(){
        return "layout/_adminLayout";
    }

    @GetMapping("/admin")
    public String Category(){
        return "content_page/ManageCategory";
    }

    @GetMapping("/adminManageProduct")
    public String product(){
        return "content_page/ManageProduct";
    }

    @GetMapping("/adminManageUser")
    public String User(){
        return "content_page/ManageUser";
    }
}
