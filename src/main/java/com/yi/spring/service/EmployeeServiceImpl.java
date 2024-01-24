package com.yi.spring.service;

import com.yi.spring.mappers.EmployeeMapper;
import com.yi.spring.vo.EmployeeVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Component
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{


    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeVO> listEmployees() throws Exception {
        List<EmployeeVO> employeeList = employeeMapper.listEmployees();

        return employeeList;

    }

    @Override
    public void empAdd(EmployeeVO vo) throws Exception {
        System.out.println("등록 데이터 전송 -> " + vo);
        employeeMapper.empAdd(vo);
    }

    @Override
    public void empUpd(EmployeeVO vo) throws Exception{
        System.out.println("수정 데이터 전송 ->" + vo);
        employeeMapper.empUpd(vo);
    }

    @Override
    public void empDel(EmployeeVO vo) throws Exception{
        System.out.println("삭제 데이터 전송 ->" + vo);
        employeeMapper.empDel(vo);
    }


}
