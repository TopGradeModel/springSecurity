package cn.hp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.hp.dao.RoleMapper;
import cn.hp.domain.SysRole;
import cn.hp.service.RoleService;

/**
 * @Description(角色管理)
 * @Author 358143424@qq.com
 * @Date 2019年8月16日
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleMapper roleMapper;
	//全查角色表
	public List<SysRole> findRole() {
		return roleMapper.findRole();
	}
	//添加角色
	public void saveRole(SysRole role) {
		roleMapper.saveRole(role);
	}
	//查询用户拥有的权限
	public List<SysRole> findRolePermission(Integer roleId) {
		return roleMapper.findRolePermission(roleId);
	}
	//添加角色权限
	public void addRolePermission(Integer roleId, Integer[] ids) {
		//删除旧的关系
		roleMapper.deleteRolePermission(roleId);
		//维护新的角色权限
		for (Integer permissionId : ids) {
			Map<String, Integer> map=new HashMap<String, Integer>();
			map.put("roleId", roleId);
			map.put("permissionId", permissionId);
			roleMapper.insertRolePermission(map);
		}
	}

}
