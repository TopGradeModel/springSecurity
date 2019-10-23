package cn.hp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.hp.dao.PermissionMapper;
import cn.hp.domain.Permission;
import cn.hp.service.PermissionService;
/**
 * @Description(权限管理)
 * @Author 358143424@qq.com
 * @Date 2019年8月16日
 */
@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {
	@Autowired
	private PermissionMapper permissionMapper;
	//全场权限列表
	@Override
	public List<Permission> findPermission() {
		return permissionMapper.findPermission();
	}
	//单查父权限
	public List<Permission> oneQuery() {
		return permissionMapper.oneQuery();
	}
	//保存用户权限
	public void savePs(Permission ps) {
		permissionMapper.savePs(ps);		
	}

}
