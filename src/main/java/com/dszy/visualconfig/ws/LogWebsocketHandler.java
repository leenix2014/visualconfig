package com.dszy.visualconfig.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@ServerEndpoint(value = "/tail/{parentDir}/{gameDir}/{logFile}", configurator = EndpointConfigurator.class)
public class LogWebsocketHandler {

    private static Logger logger = LoggerFactory.getLogger(LogWebsocketHandler.class);

    private Process process;
    private InputStream inputStream;

    @Autowired
    private Environment env;

    /**
     * 新的WebSocket请求开启
     */
    @OnOpen
    public void onOpen(Session session) {
        Map<String, List<String>> reqMap = session.getRequestParameterMap();
        List<String> list = reqMap.get("line");
        String showLine = "";
        if(list != null && !list.isEmpty()){
            showLine = list.get(0);
        }

        List<String> gatewayList = reqMap.get("gateway");
        boolean gateway = false;
        if(gatewayList != null && !gatewayList.isEmpty()){
            gateway = "true".equals(gatewayList.get(0));
        }

        Map<String, String> path = session.getPathParameters();
        String parentDir = path.get("parentDir");
        String gameDir = path.get("gameDir");
        String logFile = path.get("logFile");
        String wholePath = getLogDir(parentDir, gameDir, gateway) + File.separator + logFile;

        try {
            // 执行tail -f命令
            process = Runtime.getRuntime().exec("tail -"+showLine+"f " + wholePath);
            inputStream = process.getInputStream();

            // 一定要启动新的线程，防止InputStream阻塞处理WebSocket的线程
            TailLogThread thread = new TailLogThread(inputStream, session);
            thread.start();
        } catch (IOException e) {
            logger.error("Websocket open error!", e);
            e.printStackTrace();
        }
    }

    private String getLogDir(String parentDir, String gameDir, boolean gateway){
        String rootPath = env.getProperty("dszy.rootPath");
        String configDir = "";
        if(gateway){
            configDir = env.getProperty("dszy.gatewayServerDir");
        } else {
            configDir = env.getProperty("dszy.gameServerDir");
        }
        String logDir = env.getProperty("dszy.logDir");
        return rootPath + File.separator + parentDir + File.separator + gameDir + File.separator + configDir + File.separator + logDir;
    }

    /**
     * WebSocket请求关闭
     */
    @OnClose
    public void onClose() {
        try {
            if(inputStream != null)
                inputStream.close();
        } catch (Exception e) {
            logger.error("Websocket close error!", e);
        }
        if(process != null)
            process.destroy();
    }

    @OnError
    public void onError(Throwable thr) {
        logger.error("Websocket onError:", thr);
    }
}