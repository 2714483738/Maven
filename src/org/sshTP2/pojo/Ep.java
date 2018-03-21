package org.sshTP2.pojo;

public class Ep {
	private String dname;
	private Long countEmp;
	
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public Long getCountEmp() {
		return countEmp;
	}
	public void setCountEmp(Long countEmp) {
		this.countEmp = countEmp;
	}
	@Override
	public String toString() {
		return "Ep [dname=" + dname + ", countEmp=" + countEmp + "]";
	}
	
	

}
