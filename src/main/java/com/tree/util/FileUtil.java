package com.tree.util;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author jikai
 */
public class FileUtil {

    public static String fileToString(String filePath){
        String str = "";
        File file = new File(filePath);
        FileInputStream in;
        try {
            in = new FileInputStream(file);
            int size = in.available();
            byte[] buffer = new byte[size];
            int result = in.read(buffer);
            if(result!=-1)in.close();
            str = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static void stringToFile(String text,String path){
        File file = new File(path);
        boolean res = true;
        try {
            if (!file.exists()) {
                res = file.createNewFile();
            }
            if (res){
                FileWriter fw = new FileWriter(file);
                fw.write(text);
                fw.flush();
                fw.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
