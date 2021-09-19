package com.tree.main;

import com.tree.util.Calculate;
import com.tree.util.FileUtil;

/**
 * @author jikai
 */
public class Main {
    public static void main(String[] args) {
        String source = FileUtil.fileToString(args[0]);
        String fake = FileUtil.fileToString(args[1]);
        String target = args[2];
        double result = Calculate.caculate(source,fake);
        String res = String.format("%.2f",result);
        FileUtil.stringToFile(res,target);
    }
}
