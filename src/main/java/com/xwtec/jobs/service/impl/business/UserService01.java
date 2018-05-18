package com.xwtec.jobs.service.impl.business;

import com.xwtec.jobs.mapper.ds01.UserMapper;
import com.xwtec.jobs.service.IUserService;
import lombok.extern.slf4j.Slf4j;
//import org.core.datasource.boot.config.annotate.TargetDataSource;
import org.core.datasource.boot.config.annotate.TargetDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
@Transactional
public class UserService01 implements IUserService {

    @Autowired
    UserMapper userMapper;

    @TargetDataSource("uosp40100")
    @Override
    public List<Map> queryAll() {
        return userMapper.queryAll();
    }
}
