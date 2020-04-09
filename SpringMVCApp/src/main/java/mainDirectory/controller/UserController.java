package mainDirectory.controller;

import mainDirectory.entity.User;
import mainDirectory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String getIndexPage(){
        return "index";
    }

    @GetMapping("/hello")
    public String getTemplate(){
        return "hello";
    }

    @GetMapping("/users")
    public String getUsers(Model model){
        model.addAttribute("users", userService.findAll());
        return "userList";
    }

    @GetMapping(path = "/user", params={"id"})
    public String getUserById(@RequestParam(value="id") int id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "userInfo";
    }

    @GetMapping("/test2")
    public ModelAndView test(@SessionAttribute("user") User user, @CookieValue(value = "foo") String param){
        ModelAndView mv = new ModelAndView("test2");
        mv.addObject("myCookie", param);
        mv.addObject("user", user);
        return mv;
    }

    @GetMapping("/create_user")
    public String createUser(){
        return "createUser";
    }

    @PostMapping(path = "/create", params={"name", "email", "age"})
    public String addUser(@RequestParam("name") String name, @RequestParam("email") String email,
                          @RequestParam("age") String age){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setAge(Integer.parseInt(age));
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping(path="/edit_user", params={"id"})
    public String editUser(@RequestParam("id") String id, Model model){
        User user = userService.getUserById(Integer.parseInt(id));
        model.addAttribute("user", user);
        return "edit_user";
    }

    @PostMapping(path="/update", params = {"name", "email", "age", "id"})
    public String updateUser(@RequestParam("name") String name, @RequestParam("email") String email,
                             @RequestParam("age") String age, @RequestParam("id") String id){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setAge(Integer.parseInt(age));
        user.setId((Integer.parseInt(id)));
        userService.update(user);
        return "redirect:/users";
    }

    @GetMapping(path="/delete", params="id")
    public String deleteUser(@RequestParam("id") String id){
        userService.delete(Integer.parseInt(id));
        return "redirect:/users";
    }
}
