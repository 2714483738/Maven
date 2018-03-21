package org.sshTP2.pojo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="husband")
public class Husband {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="hid")
	private Integer hid;
	@Column(name="hname")
	private String hname;
	@Column(name="sex")
	private String sex;
	
	@ManyToMany
	private Set<Wife> ws;

	public Husband() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Husband(Integer hid, String hname, String sex, Set<Wife> ws) {
		super();
		this.hname = hname;
	}

	public Integer getHid() {
		return hid;
	}

	public void setHid(Integer hid) {
		this.hid = hid;
	}

	public String getHname() {
		return hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Set<Wife> getWs() {
		return ws;
	}

	public void setWs(Set<Wife> ws) {
		this.ws = ws;
	}

	@Override
	public String toString() {
		return "Husband [hid=" + hid + ", hname=" + hname + ", sex=" + sex + ", ws=" + ws + "]";
	}
	
	
	

}
