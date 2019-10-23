package cn.hp.service;

import java.util.List;

import cn.hp.domain.Order;

/**
 * @Description(订单管理)
 * @Author 358143424@qq.com
 * @Date 2019年8月16日
 */
public interface OrderService {
	// 查询所有订单
	public List<Order> findAll();
	//添加订单

	public void save(Order order);
	//删除订单

	public void delete(int id);
	//根据id查询一条数据
	public Order findById(int id);
	//修改数据
	public void update(Order order);
	
	

}
