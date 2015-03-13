import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by qiuhuadong2014 on 2015/3/2.
 */
public class DBUtil implements Serializable{
    private String url;
    private String user;
    private String pwd;
    private String driver;

    public void setDriver(String driver) {
        try {
            Class.forName(driver);
            this.driver = driver;
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Connection getConnection()throws SQLException{
        Connection conn= DriverManager.getConnection(url,user,pwd);
        return conn;
    }

    public String getDriver() {
        return driver;
    }

    public String getPwd() {
        return pwd;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }
}
