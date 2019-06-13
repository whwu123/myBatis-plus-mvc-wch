package com.baomidou.springmvc.controller;


import com.baomidou.springmvc.model.system.SysFile;
import com.baomidou.springmvc.service.system.SysFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;

@Controller
@RequestMapping("/sysfile")
public class FileController extends BaseController {

    @Autowired
    private SysFileService fileService;

    String savePath = "/resources/uploadFile/";

    @RequestMapping("/add")
    @ResponseBody
    public Map addFile(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest req){

        String path = req.getContextPath();
        String realPath=req.getServletContext().getRealPath(savePath);
        System.out.println(realPath);
        long  startTime=System.currentTimeMillis();
        String fileName = file.getOriginalFilename();
        String fileFormat = fileName.substring(fileName.lastIndexOf(".")+1);
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        String saveName = uuid+"."+fileFormat;
        File newFile=new File(realPath+"/"+saveName);
        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        try{
            file.transferTo(newFile);
        }catch (Exception e){
            e.printStackTrace();
        }
        long  endTime=System.currentTimeMillis();
       // System.out.println("方法的运行时间："+String.valueOf(endTime-startTime)+"ms");
       // System.out.println(path+savePath+saveName);
        Map<String, Object> map = new HashMap<>();
        map.put("path", path+savePath+saveName);
        map.put("fileid", uuid);
        SysFile sysFile = new SysFile();
        sysFile.setId(uuid);
        sysFile.setFileCreatedate(new Date());
        sysFile.setFileName(fileName);
        sysFile.setFilePath(path+savePath+saveName);
        sysFile.setFileSize(file.getSize());
        sysFile.setFileStatus(1);
        sysFile.setFileType("1");
        sysFile.setFileFormat(fileFormat);
        fileService.save(sysFile);
        return map;
    }

    @RequestMapping("/deleteImg")
    @ResponseBody
    public Object DelFiles(HttpServletRequest request,String fileId){
        if(fileId!=null){
            SysFile sysFile = fileService.getById(fileId);
            String realPath=request.getServletContext().getRealPath(savePath);
            String fileName = sysFile.getFilePath().substring(sysFile.getFilePath().lastIndexOf("/"));
            File file = new File(realPath+fileName);
            if(file.exists()){
                file.delete();
                fileService.removeById(fileId);
            }
        }
        return  renderSuccess("删除成功");
    }
}

