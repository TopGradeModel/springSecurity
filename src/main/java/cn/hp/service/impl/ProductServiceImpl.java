package cn.hp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.hp.dao.ProductDao;
import cn.hp.domain.Product;
import cn.hp.domain.PageBean;
import cn.hp.service.ProductService;
/**
 * @Description(产品管理)
 * @Author 358143424@qq.com
 * @Date 2019年8月16日
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productDao.findAll();
	}

	@Override
	public void save(Product product) {
		productDao.save(product);
		
	}

	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub
		return productDao.findById(id);
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		productDao.update(product);
	}

	@Override
	public void delOne(int id) {
		// TODO Auto-generated method stub
		productDao.delOne(id);
	}

	@Override
	public void delMany(int[] ids) {
		// 判断ids是否为null
		if(ids!=null) {
			//遍历单个id,进行删除操作
			for (int id : ids) {
				productDao.delOne(id);
			}
		}
		
	}

	@Override
	public PageBean findByPage(int currentPage, int pageSize) {
		PageBean pageBean=new PageBean();
		//封装数据
		pageBean.setCurrentPage(currentPage);
		System.out.println(currentPage);
		pageBean.setPageSize(pageSize);
		System.out.println(pageSize);
		//总条数
		Long totalCount=productDao.findTotalCount();
		pageBean.setTotalCount(totalCount);
		System.out.println(totalCount);
		//总页数
		pageBean.setTotalPage((int)Math.ceil(totalCount*1.0/pageSize));
		//每页显示的数据
		int startIndex=(currentPage-1)*pageSize;
		
		Map map=new HashMap<String,Object>();
		map.put("startIndex", startIndex);
		map.put("pageSize", pageSize);
 		List<Product> listProduct=productDao.findByPage(map);
 		System.out.println(listProduct);
 		pageBean.setList(listProduct);
		return pageBean;
	}

	//分页查询查询所有信息
	public PageInfo<Product> findAllProduct(int currentPage, int pageSize) {
		//插入从什么地方查，查多少
		PageHelper.startPage(currentPage, pageSize);
		//查询所有数据
		List<Product> list = productDao.findAll();
		PageInfo<Product> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	

}
