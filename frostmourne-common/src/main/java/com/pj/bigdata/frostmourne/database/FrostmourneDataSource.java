package com.pj.bigdata.frostmourne.database;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.pj.bigdata.frostmourne.utils.Props;
import org.apache.log4j.Logger;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by pingjie on 15-11-19.
 */
public class FrostmourneDataSource {
    private static final Logger logger = Logger.getLogger(FrostmourneDataSource.class);

    private static final String PROP_PATH = "/home/pingjie/wordspace/frostmourne/frostmourne-common/src/main/resource/c3p0.properties";
    private static final String USER = "user";
    private static final String PASSWORD = "password";
    private static final String DRIVER = "driverClass";
    private static final String JDBCURL = "jdbcUrl";
    private static final String MINPOOLSIZE = "minPoolSize";
    private static final int DEFALUT_MINPOOLSIZE = 10;
    private static final String MAXPOOLSIZE = "maxPoolSize";
    private static final int DEFALUT_MAXPOOLSIZE = 100;
    private static final String INITPOOLSIZE = "initialPoolSize";
    private static final int DEFALUT_INITPOOLSIZE = 10;
    private static final String MAXIDELTIME = "maxIdleTime";
    private static final int DEFALUIT_MAXIDELTIME = 600;
    private static final String ACQUIREINCREMENT = "acquireIncrement";
    private static final int DEFALUT_ACQUIREINCREMENT = 5;


    private static FrostmourneDataSource frostmourneDataSource;
    private ComboPooledDataSource dataSource;

    static {
        frostmourneDataSource = new FrostmourneDataSource();
    }

    private FrostmourneDataSource() {
        logger.info("FrostmourneDataSource object create start.....");
        Props props = new Props(PROP_PATH);

        String user = props.getString(USER);
        String password = props.getString(PASSWORD);
        String driver = props.getString(DRIVER);
        String jdbcurl = props.getString(JDBCURL);
        int minPoolSize = props.getInt(MINPOOLSIZE, DEFALUT_MINPOOLSIZE);
        int maxpoolSize = props.getInt(MAXPOOLSIZE, DEFALUT_MAXPOOLSIZE);
        int initPoolSize = props.getInt(INITPOOLSIZE, DEFALUT_INITPOOLSIZE);
        int maxideltime = props.getInt(MAXIDELTIME, DEFALUIT_MAXIDELTIME);
        int acquirincrement = props.getInt(ACQUIREINCREMENT, DEFALUT_ACQUIREINCREMENT);

        dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass(driver);
            dataSource.setJdbcUrl(jdbcurl);
            dataSource.setUser(user);
            dataSource.setPassword(password);
            dataSource.setMinPoolSize(minPoolSize);
            dataSource.setMaxPoolSize(maxpoolSize);
            dataSource.setInitialPoolSize(initPoolSize);
            dataSource.setMaxIdleTime(maxideltime);
            dataSource.setAcquireIncrement(acquirincrement);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
            logger.error("FrostmourneDataSource object create failed",e);
        }
        logger.info("FrostmourneDataSource object create success.....");
    }

    public final static FrostmourneDataSource getInstance(){
        return frostmourneDataSource;
    }

    public synchronized final Connection getconnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            logger.error("无法从数据源获取连接",e);
            throw new RuntimeException("无法从数据源获取连接", e);
        }
    }
}
