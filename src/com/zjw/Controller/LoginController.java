package com.zjw.Controller;

import com.zjw.Domain.User;
import com.zjw.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/Login")
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView Login() throws Exception {
        System.out.println("Request: GET:/Login/login");
        ModelAndView mav = new ModelAndView("login.jsp");
        return mav;
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public ModelAndView Register(){
        System.out.println("Request: GET:/Login/register");
        ModelAndView mav = new ModelAndView("login.jsp");
        return mav;
    }

    @ResponseBody
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String RegisterUser(@RequestParam Map Requestbody, HttpServletResponse response) {
        System.out.println("Request: POST:/Login/register");
        System.out.println(Requestbody);
        User user = new User();
        try {
            user = userService.toUser(Requestbody);
        } catch (Exception e) {
            String tmp = e +"";
            return tmp;
        }

        if(!userService.insUser(user)){
            System.out.println("ע��ʧ��");
            return "ע��ʧ��";
        }
        try {
            response.sendRedirect("/login.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("ע��ɹ�");
        return "ע��ɹ�";
    }
}
