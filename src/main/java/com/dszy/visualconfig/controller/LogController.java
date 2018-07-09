package com.dszy.visualconfig.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class LogController {

    private static Logger log = LoggerFactory.getLogger(LogController.class);


    @Autowired
    private Environment env;

    @GetMapping("/tail/{parentDir}/{gameDir}/{logFile}")
    public String gameConfig(@PathVariable String parentDir, @PathVariable String gameDir, @PathVariable String logFile, Model model, String line, String gateway){
        String path = "ws://120.78.199.18:" + env.getProperty("local.server.port") + "/tail/";
        //String path = "ws://127.0.0.1:" + env.getProperty("local.server.port") + "/tail/";
        path = path + parentDir + "/" + gameDir + "/" + logFile;
        model.addAttribute("wsPath", path);
        model.addAttribute("line", line==null?"":line);
        model.addAttribute("gateway", gateway==null?"":gateway);
        return "log";
    }
}
