package com.yi.spring.service;

import com.yi.spring.vo.EmployeeVO;

import java.util.List;


public interface EmployeeService {
    List<EmployeeVO> listEmployees() throws Exception;

    public void empAdd(EmployeeVO vo) throws Exception;

    public void empUpd(EmployeeVO vo) throws Exception;

    public void empDel(EmployeeVO vo) throws Exception;

}
