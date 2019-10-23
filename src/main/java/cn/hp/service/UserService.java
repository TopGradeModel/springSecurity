package cn.hp.service;

import java.util.List;

import javax.management.relation.Role;

import org.springframework.security.core.userdetails.UserDetailsService;

import cn.hp.domain.SysRole;
import cn.hp.domain.SysUser;


/**
 * @Description(用户管理)
 * @Author 358143424@qq.com
 * @Date 2019年8月15日
 */
public interface UserService extends UserDetailsService{
	//查询所有用户
	public List<SysUser> findUser();
	//验证添加用户名是否存在
	public boolean isUnique(String username);
	//添加用户
	public void addUser(SysUser user);
	//查询用户
	public SysUser detailUser(Integer id);
	//查询角色表
	public List<SysRole> findRolAndPermission(Integer id);
	//查询用户已经拥有的角色信息
	public List<SysRole> findUserRole(Integer userId);
	//添加用户角色
	public void addRoleToUser(Integer userId, Integer[] ids);
}
