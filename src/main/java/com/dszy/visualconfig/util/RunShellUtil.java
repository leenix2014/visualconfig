package com.dszy.visualconfig.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.SequenceInputStream;
import java.util.Date;
import java.util.StringTokenizer;

public class RunShellUtil {

    private static Logger log = LoggerFactory.getLogger(RunShellUtil.class);

    //Windows: "cmd /c echo hello > test.txt "
    //Linux: "sh -c \"echo hello > test.txt\""
    public static String runScript(String cmd, String dir){
        return runScript(cmd, null, new File(dir));
    }

    public static String runScript(String cmd){
        return runScript(cmd, null, null);
    }

    public static String runScript(String command, String[] envp, File dir) {
        if (command.length() == 0) {
            throw new IllegalArgumentException("Empty command");
        }
        StringTokenizer st = new StringTokenizer(command);
        String[] cmdarray = new String[st.countTokens()];
        for (int i = 0; st.hasMoreTokens(); i++) {
            cmdarray[i] = st.nextToken();
        }
        return runScript(cmdarray, envp, dir);
    }

    public static String runScript(String... cmdarray){
        return runScript(cmdarray, null, null);
    }

    public static String runScript(String[] cmdarray, String[] envp, File dir) {
        String command = String.join(" ", cmdarray);
        Date start = new Date();
        if(!command.contains("status")) {//查询状态频率太高，不记录日志
            log.info("running cmd({}) in directory({}) with environment({}).", command, dir == null ? "" : dir.getAbsolutePath(), envp == null ? "" : envp);
        }

        StringBuffer buf = new StringBuffer();
        String rt = "-1";
        try {
            Process process = Runtime.getRuntime().exec(cmdarray, envp, dir);
            process.waitFor();
            SequenceInputStream sis = new SequenceInputStream (process.getInputStream (), process.getErrorStream ());
            InputStreamReader ir = new InputStreamReader(sis);
            LineNumberReader input = new LineNumberReader(ir);
            String ln = "";
            while ((ln = input.readLine()) != null) {
                buf.append(ln + "\n");
            }
            rt = buf.toString();
            input.close();
            ir.close();
        } catch (Exception e) {
            rt = e.toString();
        }
        Date end = new Date();
        if(!command.contains("status")) {//查询状态频率太高，不记录日志
            log.info("cmd({}) finished with result({}) in {} milliseconds", command, rt, end.getTime() - start.getTime());
        }
        return rt;
    }

    public static void main(String args[]) {
        System.out.println(runScript("cmd /c test.bat", null, new File("E:\\\\")));
        System.out.println(runScript("cmd /c echo \"hello\" > test.txt ", null, new File("E:\\\\")));
    }
}
