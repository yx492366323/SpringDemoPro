package com.zjw.Controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.apache.tomcat.util.http.fileupload.FileUploadException;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
@Controller
@RequestMapping("/Public")
public class PublicController {

    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String Upload(@RequestParam("file") MultipartFile file){
        String UserName = SecurityContextHolder.getContext().getAuthentication().getName();
        String RemoteAddress = ((WebAuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails()).getRemoteAddress();
        String thefilename = UserName+"_"+RemoteAddress+"_"+System.currentTimeMillis()+"_"+file.getOriginalFilename();
        System.out.println("Request: POST:/Public/upload");
        String recFilePath="F:/WebFile/file/";
        File uploadFile = new File(recFilePath+thefilename);
        if(file.getSize()>(300*1024*1000)){
            return "�벻Ҫ�ϴ�������ļ���>300M����";
        }
        try {
            file.transferTo(uploadFile);
            System.out.println(uploadFile);
        } catch (FileUploadException e){
            return "�벻Ҫ�ϴ�������ļ���>500M����\n"+e;
        } catch (IOException e) {
            return "�������쳣������ϵ����Ա��\n"+e;
        }
        int page = 0;
        return "�ϴ��ɹ������Ʋ���������ҳ�油����޸������Ϣ.";
    }

}
