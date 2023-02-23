package com.itwen.contoller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.UUID;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/11/1 14:34
 * 文件描述：
 * ResponseEntity可以作为控制方法的返回值，表示响应到浏览器的完整响应报文
 * 文件上传的要求
 * 1.表单的请求方式必须是post
 * 2.表单的 enctype="multipart/form-data"
 */
@Controller
public class FileUpAndDownController {
    @RequestMapping("/test/down")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取服务器中文件的真实路径
        String realPath = servletContext.getRealPath("img");
        realPath = realPath+ File.separator+"1.jpg";
        System.out.println(realPath);
        //创建输入流
        InputStream is = new FileInputStream(realPath);
        //创建字节数组
        // is.available()获取输入流所对应的字节数
        byte[] bytes = new byte[is.available()];
        //将流读到字节数组中
        is.read(bytes);
        //创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        //设置要下载方式以及下载文件的名字
        headers.add("Content-Disposition", "attachment;filename=1.jpg");
        //设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);
        //关闭输入流
        is.close();
        return responseEntity;
    }

    @RequestMapping("test/up")
    public String testUp(HttpSession session, MultipartFile photo) throws IOException {
        // 获取上传文件的文件名
        String originalFilename = photo.getOriginalFilename();
        // 获取上传文件的后缀名
        String hzName = originalFilename.substring(originalFilename.lastIndexOf("."));
        // 获取uuid
        String uuid = UUID.randomUUID().toString();
        originalFilename = uuid+hzName;
        // 获取servletContext对象
        ServletContext servletContext = session.getServletContext();
        // 获取当前工程下photo的真实路径
        String photoPath = servletContext.getRealPath("photo");
        // 创建photoPath所对应的File对象
        File file = new File(photoPath);
        // 判断file所对应的目录是否存在
        // 如果不存在，创建出来
        if(!file.exists()){
            file.mkdir();
        }
        String finalPath = photoPath+File.separator+originalFilename;
        // 上传文件
        photo.transferTo(new File(finalPath));
        return "success";
    }
}
