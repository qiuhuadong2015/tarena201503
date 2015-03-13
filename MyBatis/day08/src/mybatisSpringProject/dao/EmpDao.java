package mybatisSpringProject.dao;

import mybatisSpringProject.entity.Emp;

import java.sql.Date;
import java.util.List;

public interface EmpDao {
	Integer add(Emp emp);
	Emp add(String ename, Integer mgr,
			Date hiredate, Double sal, Double comm,
			Integer deptno);
	//remove
	Emp delete(Integer empno);
	void delete(Emp emp);
	void update(Emp emp);
	Emp findById(Integer empno);
	List<Emp> findAll();
}




