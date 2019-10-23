package cn.hp.dao;

import java.util.List;
import java.util.Map;

import javax.management.relation.Role;

import cn.hp.domain.SysRole;
import cn.hp.domain.SysUser;

/**
 * @Description(用户管理)
 * @Author 358143424@qq.com
 * @Date 2019年8月16日
 */
public interface SysUserMapper {
	//查询用户
	public SysUser findSysUserByUsername(String username);
	//全查用户
	public List<SysUser> findUser();
	//验证用户名是否存
	public SysUser isUnique(String username);
	//添加用户
	public void addUser(SysUser user);
	//查询用户
	public SysUser detailUser(Integer id);
	//查询角色表
	public List<SysRole> findRolAndPermission(Integer id);
	//查询用户已经拥有的角色信息)
	public List<SysRole> findUserRole(Integer userId);
	//删除旧的角色关系
	public void deleteRole(Integer userId);
	//维护新的关系
	public void insertUserRole(Map<String, Integer> map);
	//动态获取数据库的角色
	public List<SysRole> queryUserRole(String username);
}
