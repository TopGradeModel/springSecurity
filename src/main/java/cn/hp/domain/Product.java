package cn.hp.domain;

import java.util.Date;

/**
 * @Description(订单管理实体类)
 * @Author 358143424@qq.com
 * @Date 2019年8月16日
 */
public class Product {
	private int id;
	private String productNum;
	private String productName;
	private String cityName;
	private Date departureTime;
	private String departureTimeStr;
	private Float productPrice;
	private String productDesc;
	private int productStatus;
	
	public String getDepartureTimeStr() {
		return departureTimeStr;
	}
	public void setDepartureTimeStr(String departureTimeStr) {
		this.departureTimeStr = departureTimeStr;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductNum() {
		return productNum;
	}
	public void setProductNum(String productNum) {
		this.productNum = productNum;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Date getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}
	public Float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Float productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public int getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(int productStatus) {
		this.productStatus = productStatus;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", productNum=" + productNum + ", productName=" + productName + ", cityName="
				+ cityName + ", departureTime=" + departureTime + ", productPrice=" + productPrice + ", productDesc="
				+ productDesc + ", productStatus=" + productStatus + "]";
	}
	

}
