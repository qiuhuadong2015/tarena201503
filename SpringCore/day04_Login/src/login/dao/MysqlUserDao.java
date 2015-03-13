package login.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Repository;

import com.tarena.entity.User;
 
/** �־ò� ע��  */
@Repository //ָ���ض���Bean ID 
public class MysqlUserDao implements UserDao, Serializable{
	
	private JdbcDataSource dataSource;
	
	public MysqlUserDao() {
	}

	@Inject 
	public void setDataSource(
			@Named("jdbcDataSource")JdbcDataSource dataSource) {
		this.dataSource = dataSource;
	}
	public JdbcDataSource getDataSource() {
		return dataSource;
	}
	
	/** ����Ψһ�û�����ѯϵͳ�û�, ���û���ҵ��û���Ϣ����null */
	public User findByName(String name) {
		System.out.println("����JDBC��������User��Ϣ");
		String sql = "select id, name, pwd, phone  from USERS where name=?";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			User user=null;
			while(rs.next()){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPwd(rs.getString("pwd"));
				user.setPhone(rs.getString("phone"));
			}
			rs.close();
			ps.close();
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			dataSource.close(conn);
		}
	}
}
