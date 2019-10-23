package cn.hp.log;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.userdetails.User;

import cn.hp.domain.SysLog;
import cn.hp.service.LogService;

/**
 * @Description(日志类)
 * @Author 358143424@qq.com
 * @Date 2019年8月21日
 */

public class LogController {
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private LogService logService;
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("111");
		//创建日志对象
		SysLog log=new SysLog();
		//将日志对象封装
		//访问时间
		log.setVisitTime(new Date());
		//访问的用户名
		HttpSession session = request.getSession();
		//从安全框架中获得上下文信息
		SecurityContext securityContext = (SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
		//获得认证信息
		Authentication authentication = securityContext.getAuthentication();
		//获得用户对象
		User user = (User) authentication.getPrincipal();
		//获得用户名
		String username = user.getUsername();
		log.setUsername(username);
		//访问的ip地址
		String ip = request.getRemoteAddr();
		log.setIp(ip);
		//访问的权限定名
		Object target = joinPoint.getTarget();
		String className = target.getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		log.setMethod(className+"."+methodName);
		logService.saveLog(log);
		//环绕通知
		Object proceed = joinPoint.proceed();
		return proceed;
	}
}
