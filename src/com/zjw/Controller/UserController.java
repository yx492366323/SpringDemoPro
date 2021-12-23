package com.zjw.Controller;

import com.zjw.Domain.User_Video;
import com.zjw.Domain.Video;
import com.zjw.Service.UserService;
import com.zjw.Service.User_VideoService;
import com.zjw.Service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.util.List;

@Controller
@RequestMapping("/User")
public class UserController {

    @Autowired
    private User_VideoService user_videoService;
    @Autowired
    private VideoService videoService;
    @Autowired
    private UserService userService;

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
    @RequestMapping(value = "/study",method = RequestMethod.GET)
    public ModelAndView Study(){
        System.out.println("Request: GET:/User/study");
        ModelAndView mav = new ModelAndView("study.jsp");
        return mav;
    }
    @RequestMapping(value = "/changePassword",method = RequestMethod.GET)
    public ModelAndView ChangePassword(){
        System.out.println("Request: GET:/User/changePassword");
        ModelAndView mav = new ModelAndView("changePassword.jsp");
        return mav;
    }

    @ResponseBody
    @RequestMapping(value = "/findvideo",method = RequestMethod.GET)
    public List<Video> Findvideo(Authentication authentication, @RequestParam(value = "State") Boolean State) throws Exception {
        System.out.println("Request: GET:/User/findvideo");
        List<Video> videos = videoService.findByUsername(authentication.getName(),State);
        return videos;
    }
    @ResponseBody
    @RequestMapping(value = "/okvideo",method = RequestMethod.POST)
    public Boolean Okvideo(Authentication authentication, @RequestParam(value = "Name") String Name) throws Exception {
        System.out.println("Request: GET:/User/okvideo");
        User_Video userVideo = new User_Video();
        userVideo.setVideoname(Name);
        userVideo.setUsername(authentication.getName());
        Timestamp nowtime = new Timestamp(System.currentTimeMillis());
        userVideo.setTime(nowtime);
        Boolean tmp = false;
        List<User_Video> videos = user_videoService.findByUsername(authentication.getName());
        for(User_Video video:videos)
            if(video.getVideoname().equals(Name))
                return tmp;
        if(user_videoService.insUserVideo(userVideo))
            tmp = true;
        return tmp;
    }

    @ResponseBody
    @RequestMapping(path = "/changePassword", method = RequestMethod.POST)
    public String changepassword(Authentication authentication,String Password) {
        System.out.println("Request: POST:/User/changePassword");
        String username = authentication.getName();
        System.out.println(Password);
        return userService.changePassword(username,Password,userService.selectUserByInfo(username).getSecurityanswer())?"<h1>修改成功</h1>":"<h1>修改失败</h1>";
    }

}
