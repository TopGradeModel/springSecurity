package cn.hp.service;

import cn.hp.domain.SysLog;

public interface LogService {
	//添加日志信息
	void saveLog(SysLog log);

}
