package org.sshTP2.pojo;

public class Ed {
	private String ename;
	private String dname;
	private Integer id;
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Ed(String ename, String dname) {
		super();
		this.ename = ename;
		this.dname = dname;
	}
	public Ed() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Ed [ename=" + ename + ", dname=" + dname + "]";
	}
	
	

}
