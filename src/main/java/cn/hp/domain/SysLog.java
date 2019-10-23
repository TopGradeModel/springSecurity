package cn.hp.domain;

import java.util.Date;

/**
 * @Description(日志实体类)
 * @Author 358143424@qq.com
 * @Date 2019年8月21日
 */
public class SysLog {
	private int id;//主键
	private Date visitTime;//访问时间
	private String username;//访问用户名
	private String ip;//访问的ip地址
	private String method;//访问的权限定名
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getVisitTime() {
		return visitTime;
	}
	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
}
