package com.zjw.Controller;

import com.zjw.Service.User_VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/User")
public class UserController {

    @Autowired
    private User_VideoService user_videoService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView Index(Authentication authentication) throws Exception {
        System.out.println("Request: GET:/User/");
        ModelAndView mav = new ModelAndView("user.jsp");
        mav.addObject("username", authentication.getName());
        String Roles = String.valueOf(authentication.getAuthorities());
        if(Roles.indexOf("ADMIN")!=-1){
            mav.addObject("AdminLogin", "<dd><a href=\"../Admin/\">To Admin</a></dd>");
        }
        mav.addObject("count1",user_videoService.count1(authentication.getName()));
        return mav;
    }
}
