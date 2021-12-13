package com.zjw.Controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public String Upload(@RequestParam("file") MultipartFile file,@RequestParam(name="type",required = false) String type){
        String UserName = SecurityContextHolder.getContext().getAuthentication().getName();
        String Roles = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        String recFilePath="F:/WebFile/file/Upload/";
        if(Roles.indexOf("ADMIN")!=-1){
            recFilePath="F:/WebFile/file/Upload/"+type+"/";
        }
        String RemoteAddress = ((WebAuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails()).getRemoteAddress();
        String thefilename = UserName+"_"+RemoteAddress+"_"+System.currentTimeMillis()+"_"+file.getOriginalFilename();
        System.out.println("Request: POST:/Public/upload");
        File uploadFile = new File(recFilePath+thefilename);
        if(file.getSize()>(300*1024*1000)){
            return "{\"code\": -1,\"msg\": \"请不要上传过大的文件（>300M）！\"}";
        }
        try {
            file.transferTo(uploadFile);
            System.out.println(uploadFile);
        } catch (FileUploadException e){
            return "{\"code\": -1,\"msg\": \"请不要上传过大的文件（>500M）！\"}"+e;
        } catch (IOException e) {
            return "{\"code\": -1,\"msg\": \"服务器异常，请联系管理员！\"}"+e;
        }
        int page = 0;
        return "{\"code\": 0,\"msg\": \"上传成功!\"}";
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ResponseEntity<byte[]> Download(@RequestParam("filename") String filename) throws IOException {
//        String dfileName = new String(fileName.getBytes("gb2312"), "iso8859-1");
        File file = new File("F:/WebFile/file/Upload/Video/admin_127.0.0.1_1639423102142_share_52a7d6cd042b663861ace4abc9378ab3.mp4");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "1.mp4");
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }

}
