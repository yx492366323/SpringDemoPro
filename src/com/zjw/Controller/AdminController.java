package com.zjw.Controller;

import com.zjw.Domain.User;
import com.zjw.Domain.Video;
import com.zjw.Service.UserService;
import com.zjw.Service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/Admin")
public class AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private VideoService videoService;

    //视图
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView Index(Authentication authentication) throws Exception {
        System.out.println("Request: GET:/Admin/");
        ModelAndView mav = new ModelAndView("admin.jsp");
        mav.addObject("username", authentication.getName());
        return mav;
    }
    @RequestMapping(value = "/upload",method = RequestMethod.GET)
    public ModelAndView Upload() throws Exception {
        System.out.println("Request: GET:/Admin/upload");
        ModelAndView mav = new ModelAndView("upload.jsp");
        return mav;
    }
    @RequestMapping(value = "/userinfo",method = RequestMethod.GET)
    public ModelAndView Userinfo() throws Exception {
        System.out.println("Request: GET:/Admin/userinfo");
        ModelAndView mav = new ModelAndView("userinfo.jsp");
        return mav;
    }
    @RequestMapping(value = "/videoinfo",method = RequestMethod.GET)
    public ModelAndView Videoinfo() throws Exception {
        System.out.println("Request: GET:/Admin/videoinfo");
        ModelAndView mav = new ModelAndView("videoinfo.jsp");
        return mav;
    }

    //用户操作
    @ResponseBody
    @RequestMapping(value = "/finduser",method = RequestMethod.GET)
    public List<User> Finduser(@RequestParam(value = "Field", required = false) String Field, @RequestParam(value = "Value", required = false) String Value) throws Exception {
        System.out.println("Request: GET:/Admin/finduser");
        return userService.fineUsersByField(Field, Value);
    }
    @ResponseBody
    @RequestMapping(value = "/moduser",method = RequestMethod.POST)
    public String Moduser(@RequestParam(value = "Field") String Field, @RequestParam(value = "Value") String Value, @RequestParam(value = "Id") Integer Id) throws Exception {
        System.out.println("Request: GET:/Admin/moduser");
        String tmp = "修改失败";
        if(userService.modUser(Field, Value, Id))
            tmp = "修改成功";
        return tmp;
    }
    @ResponseBody
    @RequestMapping(value = "/deluser",method = RequestMethod.POST)
    public String Deluser(@RequestParam(value = "Id") Integer Id) throws Exception {
        System.out.println("Request: GET:/Admin/deluser");
        String tmp = "删除失败";
        if(userService.delUserById(Id))
            tmp = "删除成功";
        return tmp;
    }

    //视频操作
    @ResponseBody
    @RequestMapping(value = "/findvideo",method = RequestMethod.GET)
    public List<Video> Findvideo(@RequestParam(value = "Field", required = false) String Field, @RequestParam(value = "Value", required = false) String Value) throws Exception {
        System.out.println("Request: GET:/Admin/findvideo");
        List<Video> videos = videoService.fineVideosByField(Field,Value);
        return videoService.fineVideosByField(Field,Value);
    }
    @ResponseBody
    @RequestMapping(value = "/modvideo",method = RequestMethod.POST)
    public String Modvideo(@RequestParam(value = "Field") String Field, @RequestParam(value = "Value") String Value, @RequestParam(value = "Id") Integer Id) throws Exception {
        System.out.println("Request: GET:/Admin/modvideo");
        String tmp = "修改失败";
        if(videoService.modVideo(Field, Value, Id))
            tmp = "修改成功";
        return tmp;
    }
    @ResponseBody
    @RequestMapping(value = "/delvideo",method = RequestMethod.POST)
    public String Delvideo(@RequestParam(value = "Id") Integer Id) throws Exception {
        System.out.println("Request: GET:/Admin/delvideo");
        String tmp = "删除失败";
        if(videoService.delVideoById(Id))
            tmp = "删除成功";
        return tmp;
    }
}
