package cn.hp.controller;

import java.util.List;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.hp.domain.SysRole;
import cn.hp.domain.SysUser;
import cn.hp.service.RoleService;
import cn.hp.service.UserService;

/**
 * @Description(用户管理controller)
 * @Author 358143424@qq.com
 * @Date 2019年8月16日
 */
@Controller
@RequestMapping("/user")
@Secured({"ROLE_admin"})
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/findUser")
	public String findUser(Model model) {
		List<SysUser> findUser = userService.findUser();
		model.addAttribute("findUser",findUser);
		return "forward:/pages/user-list.jsp";
	}
	/**
	 * @Description(添加验证用户名是否存在)
	 * @param:@param username	用户名
	 * @param:@return
	 * @Date 2019年8月15日
	 */
	@RequestMapping("/isUnique")
	@ResponseBody
	public String isUnique(String username) {
		boolean flag=userService.isUnique(username);
		return String.valueOf(flag);
	}
	/**
	 * @Description(添加用户)
	 * @param:@param username	用户名
	 * @param:@return
	 * @Date 2019年8月15日
	 */
	@RequestMapping("/addUser")
	public String addUser(SysUser user) {
		userService.addUser(user);
		return "forward:findUser";
	}
	/**
	 * @Description(查看用户详情)
	 * @param:@param user
	 * @param:@return
	 * @Date 2019年8月16日
	 */
	@RequestMapping("/detailUser")
	public String detailUser(Integer id,Model model) {
		//查询用户
		SysUser sysUser=userService.detailUser(id);
		//查询角色表
		List<SysRole> findRole=userService.findRolAndPermission(id);
		model.addAttribute("sysUser", sysUser);
		model.addAttribute("findRole", findRole);
		return "forward:/pages/user-show.jsp";
	}
	/**
	 * @Description(回显用户角色)
	 * @param:@return 添加角色jsp界面
	 * @Date 2019年8月19日
	 */
	@RequestMapping("/roleView")
	public String roleView(Integer userId,Model model) {
		System.out.println(userId);
		//全查角色
		List<SysRole> roleList = roleService.findRole();
		//查询用户已经拥有的角色
		List<SysRole> urList=userService.findUserRole(userId);
		StringBuffer str=new StringBuffer();
		for (SysRole sysRole : urList) {
			str.append(",");
			str.append(sysRole.getId());
			str.append(",");
		}
		model.addAttribute("roleList", roleList);
		model.addAttribute("str", str);
		model.addAttribute("userId", userId);
		return "forward:/pages/user-role-add.jsp";
	}
	/**
	 * @Description(添加用户角色)
	 * @param:@param userId 用户id
	 * @param:@param ids	角色id
	 * @param:@return
	 * @Date 2019年8月20日
	 */
	@RequestMapping("/addRoleToUser")
	public String addRoleToUser(Integer userId,Integer[] ids) {
		userService.addRoleToUser(userId,ids);
		return "forward:findUser";
	}
}
