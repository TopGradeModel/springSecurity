package cn.hp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hp.domain.Permission;
import cn.hp.domain.SysRole;
import cn.hp.service.PermissionService;
import cn.hp.service.RoleService;

/**
 * @Description(角色管理)
 * @Author 358143424@qq.com
 * @Date 2019年8月20日
 */
@Controller
@RequestMapping("/role")
public class RoleController {
	//角色service
	@Autowired
	private RoleService roleService;
	//权限service
	@Autowired
	private PermissionService permissionService;
	/**
	 * @Description(查询全部角色)
	 * @param:@param model	存值
	 * @param:@return
	 * @Date 2019年8月20日
	 */
	@RequestMapping("/findRole")
	public String findRole(Model model) {
		List<SysRole> findRole = roleService.findRole();
		model.addAttribute("findRole",findRole);
		return "forward:/pages/role-list.jsp";
	}
	/**
	 * @Description(添加角色)
	 * @param:@param role 角色实体
	 * @param:@return
	 * @Date 2019年8月20日
	 */
	@RequestMapping("/saveRole")
	public String saveRole(SysRole role) {
		roleService.saveRole(role);
		return "redirect:findRole";
	}
	/**
	 * @Description()
	 * @param:@param roleId 角色ID
	 * @param:@param model
	 * @param:@return	
	 * @Date 2019年8月20日
	 */
	@RequestMapping("permissionView")
	public String permissionView(Integer roleId,Model model) {
		//查询全部权限
		List<Permission> findPermission = permissionService.findPermission();
		//查询角色拥有的权限
		List<SysRole> findRole=roleService.findRolePermission(roleId);
		//创建字符缓冲区
		StringBuffer str=new StringBuffer();
		for (SysRole sysRole : findRole) {
			str.append(",");
			str.append(sysRole.getId());
			str.append(",");
		}
		model.addAttribute("findPermission", findPermission);
		model.addAttribute("str", str);
		model.addAttribute("roleId", roleId);
		return "forward:/pages/role-permission-add.jsp";
	}
	/**
	 * @Description(添加角色权限)
	 * @param:@param roleId
	 * @param:@param ids
	 * @param:@return
	 * @Date 2019年8月20日
	 */
	@RequestMapping("/addRolePermission")
	public String addRolePermission(Integer roleId,Integer[] ids) {
		roleService.addRolePermission(roleId,ids);
		return "redirect:findRole";
	}

}
