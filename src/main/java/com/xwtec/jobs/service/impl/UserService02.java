package com.xwtec.jobs.service.impl.business;

import com.xwtec.jobs.mapper.ds02.DS02UserMapper;
import com.xwtec.jobs.service.IUserService;
import org.core.datasource.boot.config.annotate.TargetDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserService02 implements IUserService {

    @Autowired
    DS02UserMapper ds02UserMapper;

    @TargetDataSource("uospTWP")
    @Override
    public List<Map> queryAll() {
        return ds02UserMapper.queryAll();
    }
}
