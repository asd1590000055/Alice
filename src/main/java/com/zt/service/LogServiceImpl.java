package com.zt.service;

import com.zt.dao.LogDao;
import com.zt.entity.LogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LogServiceImpl implements LogService {

    @Autowired
    LogDao logDao;

    //每次开启事务
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void addLog(LogEntity log) {
        logDao.addLog(log);
    }
}
