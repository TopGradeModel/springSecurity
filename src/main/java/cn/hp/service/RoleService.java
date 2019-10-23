package cn.hp.service;

import java.util.List;

import cn.hp.domain.SysRole;

/**
 * @Description(角色管理)
 * @Author 358143424@qq.com
 * @Date 2019年8月16日
 */
public interface RoleService {
	//全查角色表
	public List<SysRole> findRole();
	//添加角色
	public void saveRole(SysRole role);
	//查询角色拥有的权限
	public List<SysRole> findRolePermission(Integer roleId);
	//添加角色权限
	public void addRolePermission(Integer roleId, Integer[] ids);
}
