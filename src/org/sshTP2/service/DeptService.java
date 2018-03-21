package org.sshTP2.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sshTP2.dao.DeptDao;
import org.sshTP2.pojo.Dept;

@Service
@Transactional
public class DeptService {
	
	@Resource
	private DeptDao dd;
	
	
	/**
	 * 查詢所有部門
	 * @return
	 */
	public List<Dept> findAll() {
		List<Dept> dl = dd.findAll();
		return dl;
	}

}
