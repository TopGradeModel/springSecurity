package cn.hp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.hp.dao.LogMapper;
import cn.hp.domain.SysLog;
import cn.hp.service.LogService;
@Service
@Transactional
public class LogServiceImpl implements LogService {
	@Autowired
	private LogMapper logMapper;
	//添加日志信息
	public void saveLog(SysLog log) {
		logMapper.saveLog(log);
	}

}
