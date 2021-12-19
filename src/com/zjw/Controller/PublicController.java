package com.zjw.Controller;

import com.zjw.Domain.Video;
import com.zjw.Service.VideoService;
import it.sauronsoftware.jave.EncoderException;
import org.apache.commons.io.FileUtils;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.tomcat.util.http.fileupload.FileUploadException;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import it.sauronsoftware.jave.Encoder;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/Public")
public class PublicController {

    @Autowired
    private VideoService videoService;

    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String Upload(@RequestParam("file") MultipartFile file,@RequestParam(name="type",required = false) String type) throws EncoderException {
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
        Video video = new Video();
        video.setName(file.getOriginalFilename());
        video.setFilename(thefilename);
        Encoder encoder = new Encoder();
        it.sauronsoftware.jave.MultimediaInfo m = encoder.getInfo(uploadFile);
        long ls = m.getDuration();
        String time = ls/3600000+":"+ls/60000+":"+ls/1000;
        video.setTime(Time.valueOf(time));
        video.setPath(recFilePath);
        video.setUsername(UserName);
        Timestamp nowtime = new Timestamp(System.currentTimeMillis());
        video.setUploadtime(nowtime);
        String tmp = "{\"code\": -1,\"msg\": \"上传失败，请检查名称是否与已存在名称重复!\"}";
        if(videoService.insVideo(video))
            tmp = "{\"code\": 0,\"msg\": \"上传成功!\"}";;
        return tmp;
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public class ResourceNotFoundException extends RuntimeException {
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ResponseEntity<byte[]> Download(@RequestParam("name") String name,HttpServletResponse response) throws IOException {
        System.out.println("Request: POST:/Public/download");
        Video video = videoService.selectFileByname(name);
        if (video == null){
            throw new ResourceNotFoundException();
        }
        File file = new File(video.getPath()+video.getFilename());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", name);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }

}
