package com.nhnchina.demoexcelopt.Service.impl;

import com.nhnchina.demoexcelopt.Service.MyBookService;
import com.nhnchina.demoexcelopt.dao.MybookDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service(value = "myBookService")
public class MyBookServiceImpl implements MyBookService {

    @Resource
    private MybookDao mybookDao;

    @Override
    public List getMybookList() {
        return mybookDao.getMybookList();
    }
}
