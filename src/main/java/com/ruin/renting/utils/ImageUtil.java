package com.ruin.renting.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author ruin
 * @date 2019/11/28-17:05
 */

@Component
public class ImageUtil extends FileUtil{
    public String saveImage(MultipartFile img, String houseName,int num){
        String[]imgNames=img.getOriginalFilename().split("\\.");
        String imgName=houseName+"_"+num+".jpg";

        String path="D:\\house\\img\\";
        File file=new File(path);
        String  pathFile = path + File.separator + imgName.toLowerCase();
        File newFile=new File(pathFile);

        saveFile(file,img,newFile);
        return imgName;
    }

}
