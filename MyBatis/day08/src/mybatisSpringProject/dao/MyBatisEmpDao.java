package mybatisSpringProject.dao;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;

import mybatisSpringProject.entity.Emp;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("empDao")
public class MyBatisEmpDao implements EmpDao {

	//��MyBatis �ṩ��ִ��Sql����ģ����
	//ִ����Mapper�ж����SQL���
	//������Spring XML �ļ�������sqlSessionTemplate Bean
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	//sqlSessionTemplate ���� SqlSession 
	public Integer add(Emp emp) {
		sqlSessionTemplate.insert("addEmp", emp);
		return emp.getEmpno();
	}
	public Emp add(String ename, Integer mgr, Date hiredate, Double sal,
			Double comm, Integer deptno) {
		Emp emp = new Emp(
				ename, mgr, hiredate, sal, comm, deptno);
		sqlSessionTemplate.insert("addEmp", emp);
		return emp;
	}

	public Emp delete(Integer empno) {
		Emp emp = sqlSessionTemplate
			.selectOne("findEmpByName", empno);
		if(emp==null)
			return null;
		sqlSessionTemplate.delete("deleteEmp",emp);
		return emp;
	}

	public void delete(Emp emp) {
		sqlSessionTemplate.delete("deleteEmp", emp);
		
	}

	public List<Emp> findAll() {
		return sqlSessionTemplate
			.selectList("findAllEmp");
	}

	public Emp findById(Integer empno) {
		return sqlSessionTemplate.selectOne(
				"findByEmpId", empno);
	}

	public void update(Emp emp) {
		sqlSessionTemplate.update("updateEmp", emp);
	}
}
