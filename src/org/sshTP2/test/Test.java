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
	 * ��ֵ
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
		//�ӵڼ��п�ʼ
		query.setFirstResult(0);
		//��ѯ����
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
		// ��ѯָ������id�µ��ɷ�
		String hql = "select hs from Wife where wid=1";
		Query query = session.createQuery(hql);
		List hl = query.list();
		System.out.println(hl);
		
	}
	
	@org.junit.Test
	@Transactional
	public void fn4() {
		Session session = sf.openSession();
		// ��ѯָ������id�µ�Ա��
		String hql = "select new List(dept.dname,count(eid)) from Emp group by dept.did having count(eid)>1)";
		Query query = session.createQuery(hql);
		List hl = query.list();
		System.out.println(hl);
	}
	
	@org.junit.Test
	@Transactional
	public void fn16() {
		Session session = sf.openSession();
		// ��ѯָ������id�µ�Ա��
		String hql = "from Husband h inner join fetch h.ws w where w.wid=1";
		Query query = session.createQuery(hql);
		List hl = query.list();
		System.out.println(hl);
		
	}
	
	@org.junit.Test
	@Transactional
	public void fn10() {
		Session session = sf.openSession();
		// ��ѯָ������id�µ�Ա��
		String hql = "from Emp e where e.dept.did in(select did from Dept where did=1)";
		Query query = session.createQuery(hql);
		List hl = query.list();
		System.out.println(hl);
	}
	
	@org.junit.Test
	@Transactional
	public void fn11() {
		Session session = sf.openSession();
		//��ѯָ������id�µ�Ա��
		String hql = "from Emp e where e.dept.did in(select did from Dept where did=2)";
		Query query = session.createQuery(hql);
		List hl = query.list();
		System.out.println(hl);
	}
	
	/**
	 * ԭ��sql��ѯָ�����з�װ���Զ������
	 */
	@org.junit.Test
	@Transactional
	public void fn17() {
		Session session = sf.openSession();
		//��ѯָ������id�µ�Ա��
		String sql = "select ename,dname from emp e,dept d where e.did=d.did";
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		sqlQuery.setResultTransformer(Transformers.aliasToBean(Ed.class));
		List el = sqlQuery.list();
		System.out.println(el);
	}
	
	/**
	 *  ԭ��sql��ѯָ�����з�װ��ʵ��
	 */
	@org.junit.Test
	@Transactional
	public void fn20() {
		Session session = sf.openSession();
		//��ѯָ������id�µ�Ա��
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
		//��ѯָ������id���ɷ�name�µ��ɷ�
		String hql = "from Husband h inner join fetch h.ws w where w.wid=1 and h.hname='����'";
		Query query = session.createQuery(hql);
		List<Ed> hl = query.list();
		System.out.println(hl);
	}
	
	/**
	 * ��ѯָ������
	 */
	@org.junit.Test
	@Transactional
	public void fn19() {
		Session session = sf.openSession();
		//��ѯָ������id���ɷ�name�µ��ɷ�
		String sql = "select hname as hname,hid as hid from Husband";
		Query query = session.createQuery(sql);
		//��װ��ѯ������Զ������
		query.setResultTransformer(Transformers.aliasToBean(Hw.class));
		List<Ed> hl = query.list();
		System.out.println(hl);
		
	}
	
	/**
	 * ��ѯָ������
	 */
	@org.junit.Test
	@Transactional
	public void fn22() {
		Session session = sf.openSession();
		String sql = "select d.dname as dname,count(e.eid) as countEmp from Emp e inner join e.dept d group by d.did having count(e.eid)>0 ";
		Query query = session.createQuery(sql);
		//��װ��ѯ������Զ������
		query.setResultTransformer(Transformers.aliasToBean(Ep.class));
		List hl = query.list();
		System.out.println(hl);
	}
	
	/**
	 * ��ѯָ������
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
