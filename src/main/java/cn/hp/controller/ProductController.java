package cn.hp.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import cn.hp.domain.Product;
import cn.hp.domain.PageBean;
import cn.hp.service.ProductService;
import cn.hp.utils.DateToStringUtils;

/**
 * @Description(产品管理controller)
 * @Author 358143424@qq.com
 * @Date 2019年8月16日
 */
@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
//	//分页查询
//	@RequestMapping("/findAll1")
//	public String findAll1(@RequestParam(defaultValue="1")int currentPage,@RequestParam(defaultValue="5")int pageSize,Model model) {
//		//调用业务层处理数据
//		pageBean pageBean=productService.findByPage(currentPage,pageSize);
//		
//		System.out.println(pageBean);
//		
//		model.addAttribute("pageBean",pageBean );
//		return "product-list";
//		
//	}
	//分页查询
	@RequestMapping("/findAll")
	public String findAll(@RequestParam(defaultValue="1")int currentPage,@RequestParam(defaultValue="3")int pageSize,Model model) {
	System.out.println(currentPage+"--------"+pageSize);
		//调用业务层处理数据
		PageInfo<Product> pageinfo = productService.findAllProduct(currentPage, pageSize);
		model.addAttribute("pageinfo",pageinfo);
		return "product-list";
		
	}
	//普通全查
	@RequestMapping("/findAll1")
	public String findAll(Model model ) {
		
		List<Product> list = productService.findAll();
		model.addAttribute("list", list);
		return "product-list";
		
	}
	@RequestMapping("/save")
	private String save(Product product) {
		//我们从页面提交过来的数据是String类型，但实体类中的数据是Date类型
		productService.save(product);
		return "redirect:findAll";
		
	}
	@RequestMapping("/findById")
	public String findById(int id,Model model) {
		Product product=productService.findById(id);
		//把日期格式转换为String
		Date date = product.getDepartureTime();
		String str = DateToStringUtils.DateToString(date);
		product.setDepartureTimeStr(str);
		
		model.addAttribute("product", product);
		return "forward:/pages/product-update.jsp";
		
	}
	@RequestMapping("/update")
	public String update(Product product) {
		productService.update(product);
		return "redirect:findAll";
		
	}
	@RequestMapping("/delOne")
	public String delOne(int id) {
		productService.delOne(id);
		return "redirect:findAll";
		
	}
	@RequestMapping("/delMany")
	public String delMany(int[] ids) {
		productService.delMany(ids);
		return "redirect:findAll";
		
	}

}
