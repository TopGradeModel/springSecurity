package cn.hp.domain;

import java.util.Date;

/**
 * @Description(订单管理实体类)
 * @Author 358143424@qq.com
 * @Date 2019年8月16日
 */
public class Order {
	private int id;
	private String orderNum;
	private Date orderTime;
	private String orderTimeStr;
	private int peopleCount;
    private String orderDesc;
    private int payType;
    private int orderStatus;
    //一个订单对应一个产品
    private Product product;
    
	public String getOrderTimeStr() {
		return orderTimeStr;
	}
	public void setOrderTimeStr(String orderTimeStr) {
		this.orderTimeStr = orderTimeStr;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public int getPeopleCount() {
		return peopleCount;
	}
	public void setPeopleCount(int peopleCount) {
		this.peopleCount = peopleCount;
	}
	public String getOrderDesc() {
		return orderDesc;
	}
	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}
	public int getPayType() {
		return payType;
	}
	public void setPayType(int payType) {
		this.payType = payType;
	}
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderNum=" + orderNum + ", orderTime=" + orderTime + ", peopleCount="
				+ peopleCount + ", orderDesc=" + orderDesc + ", payType=" + payType + ", orderStatus=" + orderStatus
				+ ", product=" + product + "]";
	}
    
}
