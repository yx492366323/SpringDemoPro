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

    //��ͼ
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

    //�û�����
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
        String tmp = "�޸�ʧ��";
        if(userService.modUser(Field, Value, Id))
            tmp = "�޸ĳɹ�";
        return tmp;
    }
    @ResponseBody
    @RequestMapping(value = "/deluser",method = RequestMethod.POST)
    public String Deluser(@RequestParam(value = "Id") Integer Id) throws Exception {
        System.out.println("Request: GET:/Admin/deluser");
        String tmp = "ɾ��ʧ��";
        if(userService.delUserById(Id))
            tmp = "ɾ���ɹ�";
        return tmp;
    }

    //��Ƶ����
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
        String tmp = "�޸�ʧ��";
        if(videoService.modVideo(Field, Value, Id))
            tmp = "�޸ĳɹ�";
        return tmp;
    }
    @ResponseBody
    @RequestMapping(value = "/delvideo",method = RequestMethod.POST)
    public String Delvideo(@RequestParam(value = "Id") Integer Id) throws Exception {
        System.out.println("Request: GET:/Admin/delvideo");
        String tmp = "ɾ��ʧ��";
        if(videoService.delVideoById(Id))
            tmp = "ɾ���ɹ�";
        return tmp;
    }
}
