package com.ruin.renting.utils;

import com.ruin.renting.config.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author ruin
 * @date 2019/12/18-21:01
 */
@Component
public class AvatarUtil extends FileUtil{
    public String saveNewsImage(MultipartFile img, String username){
        String imgName=username+".jpg";

        String path= Data.path+"avatar\\";
        File file=new File(path);
        String  pathFile = path + File.separator + imgName;
        File newFile=new File(pathFile);

        saveFile(file,img,newFile);
        return imgName;
    }
}
