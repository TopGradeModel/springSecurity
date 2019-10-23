package cn.hp.dao;

import cn.hp.domain.SysLog;

public interface LogMapper {
	//添加日志信息
	void saveLog(SysLog log);

}
