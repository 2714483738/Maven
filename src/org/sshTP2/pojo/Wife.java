package org.sshTP2.pojo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity //实体就是和数据库中的表对应或者是产生了映射关系
@Table
public class Wife {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer wid;
	private String wname;
	private String sex;
	@ManyToMany(mappedBy="ws")
	private Set<Husband> hs;
	public Integer getWid() {
		return wid;
	}
	public void setWid(Integer wid) {
		this.wid = wid;
	}
	public String getWname() {
		return wname;
	}
	public void setWname(String wname) {
		this.wname = wname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Set<Husband> getHs() {
		return hs;
	}
	public void setHs(Set<Husband> hs) {
		this.hs = hs;
	}
	@Override
	public String toString() {
		return "Wife [wid=" + wid + ", wname=" + wname + ", sex=" + sex + "]";
	}
	
	
}
