package com.ruin.renting.utils;

import com.ruin.renting.config.Data;
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
    public String saveHouseImage(MultipartFile img, String houseName,int num){
        String imgName=houseName+"_"+num+".jpg";

        String path= Data.path+"img\\";
        File file=new File(path);
        String  pathFile = path + File.separator + imgName.toLowerCase();
        File newFile=new File(pathFile);

        saveFile(file,img,newFile);
        return imgName;
    }

    public String saveNewsImage(MultipartFile img,Integer id){
        String imgName="news_"+id+".jpg";

        String path=Data.path+"img\\";
        File file=new File(path);
        String  pathFile = path + File.separator + imgName.toLowerCase();
        File newFile=new File(pathFile);

        saveFile(file,img,newFile);
        return imgName;
    }

}
