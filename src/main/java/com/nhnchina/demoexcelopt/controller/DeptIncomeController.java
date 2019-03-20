package com.nhnchina.demoexcelopt.controller;

import com.nhnchina.demoexcelopt.Service.impl.DeptIncomeService;
import com.nhnchina.demoexcelopt.model.DeptIncomeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/deptIncome")
public class DeptIncomeController {
    @Autowired
    private DeptIncomeService deptIncomeService;
    @ResponseBody
    @GetMapping("/get/{key}")
    public Object getDeptIncomeList(@PathVariable("key") String key){

         return deptIncomeService.selectDeptIncomeList(key);
    }

}
