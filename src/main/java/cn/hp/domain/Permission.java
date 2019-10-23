package cn.hp.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description(权限管理)
 * @Author 358143424@qq.com
 * @Date 2019年8月16日
 */
public class Permission {
	private int id ;// 主键
	private String permissionName;//权限名
	private String url;//资源路径
	private int pid;//父权限
	//和角色表多对多的关系
	private List<SysRole> roles=new ArrayList<SysRole>();
	public List<SysRole> getRoles() {
		return roles;
	}
	public void setRoles(List<SysRole> roles) {
		this.roles = roles;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPermissionName() {
		return permissionName;
	}
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
}
