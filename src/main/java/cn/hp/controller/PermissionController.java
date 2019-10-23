package cn.hp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hp.domain.Permission;
import cn.hp.service.PermissionService;

/**
 * @Description(权限管理)
 * @Author 358143424@qq.com
 * @Date 2019年8月16日
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {
	@Autowired
	private PermissionService permissionService;
	//查询所有权限信息
	@RequestMapping("/findPerimission")
	public String findPerimission(Model model) {
		List<Permission> findPermission = permissionService.findPermission();
		model.addAttribute("findPermission", findPermission);
		return "forward:/pages/permission-list.jsp";
	}
	//单查父权限
	@RequestMapping("/oneQuery")
	public String oneQuery(Model model) {
		List<Permission> oneQueryPs = permissionService.oneQuery();
		model.addAttribute("oneQueryPs", oneQueryPs);
		return "forward:/pages/permission-add.jsp";
	}
	//保存用户权限
	@RequestMapping("/savePs")
	public String savePs(Permission ps) {
		permissionService.savePs(ps);
		return "redirect:findPerimission";
	}
}
