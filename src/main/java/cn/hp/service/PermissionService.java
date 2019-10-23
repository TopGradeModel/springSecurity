package cn.hp.service;

import java.util.List;

import cn.hp.domain.Permission;

/**
 * @Description(权限管理)
 * @Author 358143424@qq.com
 * @Date 2019年8月16日
 */
public interface PermissionService {
	//查询权限列表
	public List<Permission> findPermission();
	//单查父权限
	public List<Permission> oneQuery();
	//保存用户权限
	public void savePs(Permission ps);
}
