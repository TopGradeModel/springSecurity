package cn.hp.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description(用户管理实体)
 * @Author 358143424@qq.com
 * @Date 2019年8月16日
 */
public class SysUser {
	private Integer id;
	private String username;
	private String password;
	private String email;
	private String phoneNum;
	private Integer status;
	//角色表多对多关系
	private List<SysRole> roles=new ArrayList<SysRole>();
	public List<SysRole> getRoles() {
		return roles;
	}
	public void setRoles(List<SysRole> roles) {
		this.roles = roles;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "SysUser [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", phoneNum=" + phoneNum + ", status=" + status + "]";
	}
	
}
