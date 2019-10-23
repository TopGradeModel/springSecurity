package cn.hp.dao;

import java.util.List;
import java.util.Map;

import cn.hp.domain.SysRole;

/**
 * @Description(角色管理)
 * @Author 358143424@qq.com
 * @Date 2019年8月16日
 */
public interface RoleMapper {
	//全查角色表
	public List<SysRole> findRole();
	//添加角色
	public void saveRole(SysRole role);
	//查询用户拥有的权限
	public List<SysRole> findRolePermission(Integer roleId);
	//删除旧的关系
	public void deleteRolePermission(Integer roleId);
	//维护新的角色权限
	public void insertRolePermission(Map<String, Integer> map);
}
