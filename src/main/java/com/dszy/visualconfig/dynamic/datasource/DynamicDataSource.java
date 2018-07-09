package com.dszy.visualconfig.dynamic.datasource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DynamicDataSource extends DriverManagerDataSource {

    private static Logger log = LogManager.getLogger(DynamicDataSource.class);

    @Override
    public Connection getConnection(){
        String url = DBIdentifier.getUrl();
        DataSource dds = DDSHolder.instance().getDDS(url);
        if (dds == null) {
            dds = new DriverManagerDataSource(url);
            DDSHolder.instance().addDDS(url, dds);
        }
        try {
            return dds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
