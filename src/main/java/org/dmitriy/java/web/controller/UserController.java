package org.dmitriy.java.web.controller;

import org.dmitriy.java.web.model.User;
import org.dmitriy.java.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/user")
@SessionAttributes("current")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "show", method = RequestMethod.GET)
    public String user(
            UsernamePasswordAuthenticationToken currentUser,
            @RequestParam(value = "id", required = true, defaultValue = "1") Integer id,
            Model model) {
        User u = userService.find(id);
        model.addAttribute("user", u);
        model.addAttribute("current", (User) currentUser.getPrincipal());
        return "user";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap model) {
        return "login";
    }
}
