package cn.hp.dao;

import java.util.List;
import java.util.Map;

import cn.hp.domain.Product;

/**
 * @Description(订单管理)
 * @Author 358143424@qq.com
 * @Date 2019年8月16日
 */
public interface ProductDao {
	// 查询所有
	public List<Product> findAll();
	//添加数据
	public void save(Product product);
	//根据id查询数据
	public Product findById(int id);
	//修改数据
	public void update(Product product);
	//删除一条数据
	public void delOne(int id);
	//查询总条数
	public Long findTotalCount();
	//查询每页显示的数据
	public List<Product> findByPage(Map map);
	
	

}
