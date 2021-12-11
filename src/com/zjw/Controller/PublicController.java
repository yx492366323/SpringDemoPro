package com.zjw.Controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
@Controller
@RequestMapping("/Public")
public class PublicController {

    @ResponseBody
    @RequestMapping(path = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam("file") MultipartFile file){
        String UserName = SecurityContextHolder.getContext().getAuthentication().getName();
        String RemoteAddress = ((WebAuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails()).getRemoteAddress();
        String filename = UserName+"_"+RemoteAddress+"_"+System.currentTimeMillis()+"_"+file.getOriginalFilename();
        System.out.println("Request: GET:/Public/upload");
        String recFilePath="F:/WebFile/file/";
        File uploadFile = new File(recFilePath+filename);
        if(file.getSize()>(300*1024*1000)){
            return "请不要上传过大的文件（>300M）！";
        }
//        try {
//            file.transferTo(uploadFile);
//            System.out.println(uploadFile);
//        } catch (FileUploadException e){
//            return "请不要上传过大的文件（>500M）！\n"+e;
//        } catch (IOException e) {
//            return "服务器异常，请联系管理员！\n"+e;
//        }
        int page = 0;
        return "上传成功，请移步订单中心页面补充或修改相关信息.";
    }

}
