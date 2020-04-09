package mainDirectory.controller;

import mainDirectory.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes(names={"user", "item"})
public class TestController {

    @ModelAttribute("user")
    public User getUser(){
        User user = new User();
        user.setName("Petya");
        return user;
    }

    @GetMapping("/test")
    public String test(@ModelAttribute("user") User user, HttpServletResponse response){
        user.setName("Petrunya");
        Cookie cookie = new Cookie("foo", "Yermeyev");
        cookie.setMaxAge(3600);
        response.addCookie(cookie);
        return "test";
    }
}
