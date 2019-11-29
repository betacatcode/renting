package com.ruin.renting.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author ruin
 * @date 2019/11/29-12:23
 */
public class FileUtil {
    public boolean deleteFile(String pathname){
        boolean result = false;
        File file = new File(pathname);
        if (file.exists()) {
            file.delete();
            result = true;
            System.out.println(pathname+"文件已经被成功删除");
        }
        return result;
    }
    public void saveFile(File dir, MultipartFile baseFile,File saveFile){
        if(!dir.exists())
            dir.mkdirs();
        else {
            try {
                if(baseFile.getSize()!=0)
                    baseFile.transferTo(saveFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
