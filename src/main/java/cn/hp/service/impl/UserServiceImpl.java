package cn.hp.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cn.hp.dao.SysUserMapper;
import cn.hp.domain.SysRole;
import cn.hp.domain.SysUser;
import cn.hp.service.UserService;
/**
 * @Description(用户管理)
 * @Author 358143424@qq.com
 * @Date 2019年8月15日
 */
@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private SysUserMapper userMapper;
	@Autowired
	private PasswordEncoder passwordEncoder;
	/**
	 * @Description(验证登陆)
	 * @param:@param username 表单用户名
	 * @param:@return
	 * @param:@throws UsernameNotFoundException
	 * @Date 2019年8月15日
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//根据用户名获取用户(SysUser)对象
		SysUser sysUser = userMapper.findSysUserByUsername(username);
			/*//创建角色集合对象
			Collection<GrantedAuthority> authorities=new ArrayList<>();
			//创建角色对象  p1:角色
			GrantedAuthority grantedAuthority=new SimpleGrantedAuthority("ROLE_USER");
			authorities.add(grantedAuthority);*/
			//动态获取数据库的角色
			List<SysRole> queryRole=userMapper.queryUserRole(username);
			Collection<GrantedAuthority> authorities=new ArrayList<>();
			if(queryRole!=null) {
				for (SysRole sysRole : queryRole) {
					GrantedAuthority grantedAuthority=new SimpleGrantedAuthority("ROLE_"+sysRole.getRoleName());
					authorities.add(grantedAuthority);
				}
			}
			//p1:用户名   p2:密码  p3:角色列表对象
			UserDetails userDetails=new User(sysUser.getUsername(),sysUser.getPassword(), authorities);
			return userDetails;
	}
	/**
	 * 查询所有用户信息
	 */
	public List<SysUser> findUser(){
		List<SysUser> findUser = userMapper.findUser();
		return findUser;
	}
	/**
	 * @Description(验证用户名是否存在)
	 * @param:@param username	添加时的用户名
	 * @param:@return
	 * @Date 2019年8月15日
	 */
	@Override
	public boolean isUnique(String username) {
		 SysUser unique = userMapper.isUnique(username);
		if(unique!=null) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * @Description(添加用户)
	 * @param:@param user	页面用户信息
	 * @Date 2019年8月16日
	 */
	@Override
	public void addUser(SysUser user) {
		String encode = passwordEncoder.encode(user.getPassword());
		user.setPassword(encode);
		userMapper.addUser(user);
	}
	//查询用户
	public SysUser detailUser(Integer id) {
		return userMapper.detailUser(id);
	}
	//查询角色表
	public List<SysRole> findRolAndPermission(Integer id) {
		return userMapper.findRolAndPermission(id);
	}
	/**
	 * @Description(查询用户已经拥有的角色信息)
	 * @param:@param userId		用户id
	 * @param:@return	拥有的角色信息
	 * @Date 2019年8月19日
	 */
	@Override
	public List<SysRole> findUserRole(Integer userId) {
		return userMapper.findUserRole(userId);
	}
	/**
	 * @Description()
	 * @param:@param userId 用户id
	 * @param:@param ids 角色id
	 * @Date 2019年8月20日
	 */
	@Override
	public void addRoleToUser(Integer userId, Integer[] ids) {
		//删除旧的角色信息，
		userMapper.deleteRole(userId);
		//维护新的角色关系
		if(ids!=null) {
			for (Integer roleId : ids) {
				Map<String, Integer> map=new HashMap<String, Integer>();
				map.put("userId", userId);
				map.put("roleId", roleId);
				userMapper.insertUserRole(map);
			}
		}
		
	}
}
