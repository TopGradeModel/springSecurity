package cn.hp.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.hp.domain.Product;
import cn.hp.domain.PageBean;

/**
 * @Description(产品管理)
 * @Author 358143424@qq.com
 * @Date 2019年8月16日
 */
public interface ProductService {
	// 查询所有
	public List<Product> findAll();
	//添加数据
	public void save(Product product);
	//根据id查询一条数据
	public Product findById(int id);
	//修改数据
	public void update(Product product);
	//删除一条数据
	public void delOne(int id);
	//删除多条数据
	public void delMany(int[] ids);
	//分页查询
	public PageBean findByPage(int currentPage, int pageSize);
	//分页查询2
	public PageInfo<Product> findAllProduct(int currentPage, int pageSize);
	

}
