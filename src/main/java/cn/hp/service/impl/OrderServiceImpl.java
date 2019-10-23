package cn.hp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.hp.dao.OrderDao;
import cn.hp.domain.Order;
import cn.hp.service.OrderService;
/**
 * @Description(订单管理)
 * @Author 358143424@qq.com
 * @Date 2019年8月16日
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;

	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return orderDao.findAll();
	}

	@Override
	public void save(Order order) {
		// TODO Auto-generated method stub
		orderDao.save(order);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		orderDao.delete(id);
	}

	@Override
	public Order findById(int id) {
		// TODO Auto-generated method stub
		return orderDao.findById(id);
	}

	@Override
	public void update(Order order) {
		// TODO Auto-generated method stub
		orderDao.update(order);
	}

	
	

	

}
