package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired

    @RequestMapping("/index")
    public String index(){
        return "helloJenkins!";
    }
    @RequestMapping("/login")
    public String loging(User user){
        User user1 = userService.loging(user);
        if(user1==null){
            return "loging fail";
        }
        return "redirect:listUser";
    }
    @RequestMapping("/listUser")
    public String getAll(Model model){
        List<User> users = userService.selectList();
        model.addAttribute("users",users);
        return "listuser";
    }
    //添加
    @RequestMapping("/addUser")
    public String listuser(User user) throws Exception {
        userService.save(user);
        return "redirect:listUser";
    }
    //删除
    @RequestMapping("/deleteUser")
    public String deleteUser(User user) throws Exception {
        userService.delete(user.getId());
        return "redirect:listUser";
    }
    //查找(用于修改)
    @RequestMapping("/findUser")
    public String findUser(int id, Model model) throws Exception {
        User user= userService.getById(id);
        System.out.println("哈哈哈哈哈");
        model.addAttribute("user", user);
        return "edituser";
    }
    //修改
    @RequestMapping("/updateUser")
    public String updateUser(User user) throws Exception {
        userService.update(user);
        return "redirect:listUser";
    }

}
