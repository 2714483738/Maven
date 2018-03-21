package org.sshTP2.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.sshTP2.pojo.Emp;

@Repository
public class EmpDao { 
	
	@Resource
	private SessionFactory sf;
	
	/**
	 * 查詢所有
	 * @param sql
	 * @return
	 */
	public List<Emp> findAll(String sql) {
		Session session = sf.openSession();
		SQLQuery query = session.createSQLQuery(sql).addEntity(Emp.class);
		List<Emp> el = query.list();
		return el;
	}
	
	/**
	 * 添加員工
	 * @param emp
	 */
	public void addEmp(Emp emp) {
		//Session session = sf.openSession();
		//System.out.println("UP EMP:"+emp);
		//Transaction tx = session.beginTransaction();
		Session session = sf.getCurrentSession();
		System.out.println("UP EMP:"+emp);
		session.saveOrUpdate(emp);
		//tx.commit();
	}

	/**
	 * 查询指定emp
	 * @param emp
	 * @return
	 */
	public Emp findEmpByEid(Emp emp) {
		Session session = sf.openSession();
		emp = session.get(Emp.class, emp.getEid());
		return emp;
	}

}
