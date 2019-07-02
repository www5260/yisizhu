package com.buba.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.buba.dao.LogDao;
import com.buba.entity.Log;
import com.buba.service.LogService;

@Service("logService")
public class LogServiceImpl implements LogService {
	@Resource
	private LogDao logDao;

	@Override
	public void savLog(Log log) {
		logDao.addLog(log);
	}

}
