package org.sshTP2.pojo;

public class Hw {
	private String hname;
	private Integer hid;
	
	
	public String getHname() {
		return hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
	}



	public Integer getHid() {
		return hid;
	}



	public void setHid(Integer hid) {
		this.hid = hid;
	}



	@Override
	public String toString() {
		return "Hw [hname=" + hname + ", hid=" + hid + "]";
	}
	

}
