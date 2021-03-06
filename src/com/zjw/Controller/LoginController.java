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

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/Login")
public class LoginController {

    private boolean BoolMsg;

    public boolean isBoolMsg(){
        return BoolMsg;
    }

    public void setBoolMsg(boolean boolMsg) {
        BoolMsg = boolMsg;
    }

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView Login() throws Exception {
        System.out.println("Request: GET:/Login/login");
        ModelAndView mav = new ModelAndView("login.jsp");
        return mav;
    }
    @RequestMapping(value = "/loginerror",method = RequestMethod.GET)
    public ModelAndView Loginerror() throws Exception {
        System.out.println("Request: GET:/Login/login");
        ModelAndView mav = new ModelAndView("login.jsp");
        mav.addObject("error", "Please input right username and password!");
        return mav;
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public ModelAndView Register(){
        System.out.println("Request: GET:/Login/register");
        ModelAndView mav = new ModelAndView("register.jsp");
        return mav;
    }

    @RequestMapping(value = "/changePassword",method = RequestMethod.GET)
    public ModelAndView ChangePassword(){
        System.out.println("Request: GET:/Login/changePassword");
        ModelAndView mav = new ModelAndView("changePassword.jsp");
        return mav;
    }

    @RequestMapping(value = "/agreement",method = RequestMethod.GET)
    public ModelAndView Agreement(){
        System.out.println("Request: GET:/Login/agreement");
        ModelAndView mav = new ModelAndView("agreement.jsp");
        mav.addObject("message", "This is a agreement! You must agree it before use this website!");
        return mav;
    }

    @ResponseBody
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@RequestParam Map Requestbody, HttpServletResponse response) {
        System.out.println("Request: POST:/Login/register");
        System.out.println(Requestbody);
        User user = new User();
        try {
            user = userService.toUser(Requestbody);
        } catch (Exception e) {
            String tmp = e +"";
            return tmp;
        }
        try {
            userService.insUser(user);
        } catch (Exception e) {
            String tmp = "<h1>????????????????????????????????????????????????????????????????????????????????????</h1>\n" + e ;
            return tmp;
        }
        try {
            response.sendRedirect("login.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("???????????????");
        return "???????????????";
    }

    @ResponseBody
    @RequestMapping(path = "/isUserExist", method = RequestMethod.GET)
    public String isuserexist(String UserName) {
        System.out.println("Request: /Login/isUserExist");
        System.out.println(UserName);
        return userService.isUserExist(UserName)?"true":"";
    }

    @ResponseBody
    @RequestMapping(path = "/getQuestion", method = RequestMethod.GET)
    public String getquestion(String UserName) {
        System.out.println("Request: GET:/Login/getQuestion");
        System.out.println(UserName);
        return userService.getQuestion(UserName);
    }

    @ResponseBody
    @RequestMapping(path = "/verifyAnswer", method = RequestMethod.GET)
    public String verifyanswer(String UserName, String SecurityAnswer) {
        System.out.println("Request: GET:/Login/verifyAnswer");
        System.out.println(UserName);
        System.out.println(SecurityAnswer);
        return userService.verifyAnswer(UserName,SecurityAnswer)?"true":"";
    }

    @ResponseBody
    @RequestMapping(path = "/changePassword", method = RequestMethod.POST)
    public String changepassword(String UserName, String Password , String SecurityAnswer) {
        System.out.println("Request: POST:/Login/changePassword");
        System.out.println(UserName);
        System.out.println(Password);
        System.out.println(SecurityAnswer);
        return userService.changePassword(UserName,Password,SecurityAnswer)?"true":"";
    }
}
