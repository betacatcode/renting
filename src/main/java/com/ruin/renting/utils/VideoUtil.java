package com.ruin.renting.utils;

import com.ruin.renting.config.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author ruin
 * @date 2019/11/29-12:22
 */
@Component
public class VideoUtil extends FileUtil{
    public String saveVideo(MultipartFile video, String houseName){
        String[]videoNames=video.getOriginalFilename().split("\\.");
        String videoName=houseName+"."+videoNames[1];

        String path= Data.path+"video\\";
        File file=new File(path);
        String  pathFile = path + File.separator + videoName.toLowerCase();
        File newFile=new File(pathFile);

        saveFile(file,video,newFile);
        return videoName;
    }

}
