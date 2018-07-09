package com.dszy.visualconfig.dynamic.datasource;

public class DBIdentifier {
    
    private static ThreadLocal<String> urls = new ThreadLocal<String>();
    public static String getUrl() {
        return urls.get();
    }
    public static void setUrl(String url) {
        urls.set(url);
    }
}
