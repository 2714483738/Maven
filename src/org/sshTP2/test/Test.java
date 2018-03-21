package org.sshTP2.test;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.sshTP2.pojo.Ed;
import org.sshTP2.pojo.Emp;
import org.sshTP2.pojo.Ep;
import org.sshTP2.pojo.Hw;

import com.sun.javafx.geom.Edge;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:org/sshTP2/cnf/app-core.xml")
public class Test {
	
	@Resource
	private SessionFactory sf;
	
	@org.junit.Test
	@Transactional
	public void fn() {
		Session session = sf.openSession();
		String hql = "from Husband";
		Query query = session.createQuery(hql);
		List hl = query.list();
		System.out.println(hl);
	}
	
	/**
	 * 传值
	 */
	@org.junit.Test
	@Transactional
	public void fn1() {
		Session session = sf.openSession();
		String hql = "from Husband where hname=:name";
		Query query = session.createQuery(hql);
		query.setString("name", "h1");
		List hl = query.list();
		System.out.println(hl);
	}
	
	
	@org.junit.Test
	@Transactional
	public void fn2() {
		Session session = sf.openSession();
		String hql = "from Husband";
		Query query = session.createQuery(hql);
		//从第几行开始
		query.setFirstResult(0);
		//查询几行
		query.setMaxResults(1);
		List hl = query.list();
		System.out.println(hl);
	}
	
	@org.junit.Test
	@Transactional
	public void fn5() {
		Session session = sf.openSession();
		String hql = "select new Emp(eid,ename) from Emp";
		Query query = session.createQuery(hql);
		List<Emp> el = query.list();
		for (Emp emp : el) {
			System.out.println(emp);
		}
	}
	
	@org.junit.Test
	@Transactional
	public void fn6() {
		Session session = sf.openSession();
		String hql = "select new Map(ename,dept.dname) from Emp";
		Query query = session.createQuery(hql);
		List<Map<String, String>> el = query.list();
		for (Map<String, String> map : el) {
			System.out.println(map);
		}
		
	}
	
	@org.junit.Test
	@Transactional
	public void fn7() {
		Session session = sf.openSession();
		String hql = "select new List(ename,dept.dname) from Emp";
		Query query = session.createQuery(hql);
		List<List> el = query.list();
		for (List list : el) {
			System.out.println(list);
		}
	}
	
	@org.junit.Test
	@Transactional
	public void fn8() {
		Session session = sf.openSession();
		String hql = "select ename as ename,dept.dname as dname from Emp";
		Query query = session.createQuery(hql);
		query.setResultTransformer(Transformers.aliasToBean(Ed.class));
		List el = query.list();
		System.out.println(el);
	}
	
	@org.junit.Test
	@Transactional
	public void fn3() {
		Session session = sf.openSession();
		// 查询指定妻子id下的丈夫
		String hql = "select hs from Wife where wid=1";
		Query query = session.createQuery(hql);
		List hl = query.list();
		System.out.println(hl);
		
	}
	
	@org.junit.Test
	@Transactional
	public void fn4() {
		Session session = sf.openSession();
		// 查询指定部门id下的员工
		String hql = "select new List(dept.dname,count(eid)) from Emp group by dept.did having count(eid)>1)";
		Query query = session.createQuery(hql);
		List hl = query.list();
		System.out.println(hl);
	}
	
	@org.junit.Test
	@Transactional
	public void fn16() {
		Session session = sf.openSession();
		// 查询指定部门id下的员工
		String hql = "from Husband h inner join fetch h.ws w where w.wid=1";
		Query query = session.createQuery(hql);
		List hl = query.list();
		System.out.println(hl);
		
	}
	
	@org.junit.Test
	@Transactional
	public void fn10() {
		Session session = sf.openSession();
		// 查询指定部门id下的员工
		String hql = "from Emp e where e.dept.did in(select did from Dept where did=1)";
		Query query = session.createQuery(hql);
		List hl = query.list();
		System.out.println(hl);
	}
	
	@org.junit.Test
	@Transactional
	public void fn11() {
		Session session = sf.openSession();
		//查询指定部门id下的员工
		String hql = "from Emp e where e.dept.did in(select did from Dept where did=2)";
		Query query = session.createQuery(hql);
		List hl = query.list();
		System.out.println(hl);
	}
	
	/**
	 * 原生sql查询指定的列封装到自定义对象
	 */
	@org.junit.Test
	@Transactional
	public void fn17() {
		Session session = sf.openSession();
		//查询指定部门id下的员工
		String sql = "select ename,dname from emp e,dept d where e.did=d.did";
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		sqlQuery.setResultTransformer(Transformers.aliasToBean(Ed.class));
		List el = sqlQuery.list();
		System.out.println(el);
	}
	
	/**
	 *  原生sql查询指定的列封装到实体
	 */
	@org.junit.Test
	@Transactional
	public void fn20() {
		Session session = sf.openSession();
		//查询指定部门id下的员工
		String sql = "select ename,eid from emp";
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		List<Object[]> el = sqlQuery.list();
		for (Object[] objects : el) {
			System.out.println(objects[0]+":"+objects[1]);
		}
	}
	
	@org.junit.Test
	@Transactional
	public void fn18() {
		Session session = sf.openSession();
		//查询指定妻子id和丈夫name下的丈夫
		String hql = "from Husband h inner join fetch h.ws w where w.wid=1 and h.hname='赵六'";
		Query query = session.createQuery(hql);
		List<Ed> hl = query.list();
		System.out.println(hl);
	}
	
	/**
	 * 查询指定几列
	 */
	@org.junit.Test
	@Transactional
	public void fn19() {
		Session session = sf.openSession();
		//查询指定妻子id和丈夫name下的丈夫
		String sql = "select hname as hname,hid as hid from Husband";
		Query query = session.createQuery(sql);
		//封装查询结果到自定义对象
		query.setResultTransformer(Transformers.aliasToBean(Hw.class));
		List<Ed> hl = query.list();
		System.out.println(hl);
		
	}
	
	/**
	 * 查询指定几列
	 */
	@org.junit.Test
	@Transactional
	public void fn22() {
		Session session = sf.openSession();
		String sql = "select d.dname as dname,count(e.eid) as countEmp from Emp e inner join e.dept d group by d.did having count(e.eid)>0 ";
		Query query = session.createQuery(sql);
		//封装查询结果到自定义对象
		query.setResultTransformer(Transformers.aliasToBean(Ep.class));
		List hl = query.list();
		System.out.println(hl);
	}
	
	/**
	 * 查询指定几列
	 */
	@org.junit.Test
	@Transactional
	public void fn23() {
		Session session = sf.openSession();
		String sql = "select * from emp where did=1";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Emp.class);
		List hl = query.list();
		System.out.println(hl);
		
	}
	
}
