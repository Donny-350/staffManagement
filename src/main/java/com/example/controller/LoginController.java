package com.example.controller;

import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session, Model model) {
        User user = userService.selectPasswordByName(username, password);
        if (user != null){
            session.setAttribute("username", user.getUserName());
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg", "用户名或者密码错误");
            return "index";
        }
    }

    @GetMapping("/user/loginOut")
    public String loginOut(HttpSession session){
        session.invalidate();
        return "redirect:/index.html";
    }
}
