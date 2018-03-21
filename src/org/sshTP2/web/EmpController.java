package org.sshTP2.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.sshTP2.pojo.Dept;
import org.sshTP2.pojo.Emp;
import org.sshTP2.service.DeptService;
import org.sshTP2.service.EmpService;

/**
 * @author emp������
 *
 */
@Controller
public class EmpController {
	
	@Resource
	private EmpService es;	
	
	@Resource
	private DeptService ds;	

	/**
	 * ��ѯ����
	 * @param model
	 * @param emp
	 * @return
	 */
	@RequestMapping("/list")
	public String fn1(ModelMap model,Emp emp) {
		String sql = "select * from emp where 1=1";
		//���ղ��Ų�ѯԱ��
		if (emp != null && emp.getDept() != null && emp.getDept().getDid() !=null) {
			sql += " and did = " + emp.getDept().getDid();
		}
		//��������ģ����ѯ
		if (emp != null && emp.getEname() != null &&emp.getEname().equals("")) {
			sql += " and ename like '%" + emp.getEname() + "%'";
		}
		//����
		sql += " order by eid asc";
		List<Emp> el = es.findAll(sql);
		List<Dept> dl = ds.findAll();
		//����ѯ���������ݷŵ�ģ�����Ա���jsp��ȡ��ģ���е�����
		model.put("el", el);
		model.put("dl", dl);
		//ҳ���ѯ���ݻ���
		model.put("empBack", emp);
		return "list";
	}
	
	/**
	 * ���Ա��
	 * @param model
	 * @param emp
	 * @return
	 */
	@RequestMapping("/addEmp")
	public String fn2(ModelMap model,Emp emp) {
		es.addEmp(emp);
		return "redirect:list";
	}
	
	/**
	 * �޸�
	 * @param emp
	 * @return
	 */
	@RequestMapping("/upEmp")
	public String fn3(ModelMap model,Emp emp){
		emp = es.findEmpByid(emp);
		List<Dept> dl = ds.findAll();
		model.put("emp", emp);
		model.put("dl", dl);
		return "up";
	}
	
	
	
	
}
