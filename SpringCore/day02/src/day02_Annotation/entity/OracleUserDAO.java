package day02_Annotation.entity;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by qiuhuadong2014 on 2015/3/3.
 */
public class OracleUserDAO implements UserDAO,Serializable {

    private JdbcDataSource jdbcDataSource;

    public void setJdbcDataSource(JdbcDataSource jdbcDataSource) {
        this.jdbcDataSource = jdbcDataSource;
    }

    @Override
    public User findByName(String name) {
        String sql="select id, name, pwd, phone from t_user where name=?";
        Connection conn=null;
        try {
            conn=jdbcDataSource.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,name);
            ResultSet rs=ps.executeQuery();
            User user=null;
            while(rs.next()){
                user=new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPwd(rs.getString("pwd"));
                user.setPhone(rs.getString("phone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            jdbcDataSource.close(conn);
        }
        return null;
    }

    @Override
    public User add(String name, String pwd, String phone) {
        return null;
    }

    @Override
    public Integer add(User user) {
        return null;
    }

    @Override
    public User remove(Integer id) {
        return null;
    }

    @Override
    public Void update(User user) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
