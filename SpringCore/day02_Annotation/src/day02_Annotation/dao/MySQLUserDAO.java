package day02_Annotation.dao;

import day02_Annotation.entity.User;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by qiuhuadong2014 on 2015/3/3.
 */
public class MySQLUserDAO implements UserDAO,Serializable {

    private JdbcDataSource jdbcDataSource;

    public void setJdbcDataSource(JdbcDataSource jdbcDataSource) {
        this.jdbcDataSource = jdbcDataSource;
    }

    @Override
    public User findByName(String name) {
        String sql="select id, name, pwd, phone from tb0303 where name=?";
        Connection conn=null;
        User user=null;
        try {
            conn=jdbcDataSource.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,name);
            ResultSet rs=ps.executeQuery();
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
        return user;
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
