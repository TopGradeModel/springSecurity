package cn.hp.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description(角色管理实体)
 * @Author 358143424@qq.com
 * @Date 2019年8月16日
 */
public class SysRole {
	private int id ;//主键
	private String roleName;//角色名称
	private String roleDesc;//角色描述
	
	//和用户表多对多的关系
	private List<SysUser> sysUsers=new ArrayList<>();
	//和权限表多对多的关系
	private List<Permission> permissions=new ArrayList<>();
	public List<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	public List<SysUser> getSysUsers() {
		return sysUsers;
	}
	public void setSysUsers(List<SysUser> sysUsers) {
		this.sysUsers = sysUsers;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	@Override
	public String toString() {
		return "SysRole [id=" + id + ", roleName=" + roleName + ", roleDesc=" + roleDesc + ", sysUsers=" + sysUsers
				+ ", permissions=" + permissions + "]";
	}
	
}
