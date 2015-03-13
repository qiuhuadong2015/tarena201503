package day02_Annotation.entity;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by qiuhuadong2014 on 2015/3/3.
 */
public class JdbcDataSource implements Serializable {
    private String Driver;

    public String getDriver() {
        return Driver;
    }

    public void setDriver(String driver) {
        try {
            Class.forName(driver);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        Driver = driver;
    }
    private String url;
    private String user;
    private String pwd;

    public void setUser(String user) {
        this.user = user;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUser() {
        return user;
    }

    public String getUrl() {
        return url;
    }

    public String getPwd() {
        return pwd;
    }

    public Connection getConnection() throws SQLException{
        Connection conn=DriverManager.getConnection(url,user,pwd);
        return conn;
    }

    public void close(Connection conn){
        try {
            if(conn!=null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
