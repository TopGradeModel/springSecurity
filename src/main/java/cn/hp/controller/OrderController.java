package cn.hp.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hp.domain.Order;
import cn.hp.domain.Product;
import cn.hp.service.OrderService;
import cn.hp.service.ProductService;
import cn.hp.utils.DateToStringUtils;

/**
 * @Description(订单管理controller)
 * @Author 358143424@qq.com
 * @Date 2019年8月16日
 */
@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private ProductService productService;
	@RequestMapping("/findAll")
	public String findAll(Model model){
		List<Order> list = orderService.findAll();
		model.addAttribute("list", list);
		return "forward:/pages/order-list.jsp";
		
	}
	//查询所有产品信息，进行回显
	@RequestMapping("/addToView")
	public String addToView(Model model) {
		List<Product> list = productService.findAll();
		model.addAttribute("list", list);
		return "forward:/pages/order-add.jsp";
		
	}
	//添加数据
	@RequestMapping("/save")
	public String save(Order order) {
		orderService.save(order);
		return "redirect:findAll";
		
	}
	//删除数据
	@RequestMapping("/delOne")
	public String delOne(int id) {
		orderService.delete(id);
		
		return "redirect:findAll";
		
	}
	@RequestMapping("/findById")
	public String findById(int id,Model model) {
		Order order=orderService.findById(id);
		System.out.println(order);
		//把Date类型转换为String类型
		Date date = order.getOrderTime();
		String str = DateToStringUtils.DateToString(date);
		order.setOrderTimeStr(str);
		
		System.out.println(order);
		model.addAttribute("order", order);
		
		return "forward:/pages/order-update.jsp";
		
	}
	@RequestMapping("/update")
	public String update(Order order) {
		orderService.update(order);
		return "redirect:findAll";
		
	}
	

}
