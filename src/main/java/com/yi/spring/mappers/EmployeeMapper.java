package com.yi.spring.mappers;

import com.yi.spring.vo.EmployeeVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {

    List<EmployeeVO> listEmployees();

    public void empAdd(@Param("vo") EmployeeVO vo);

    public void empUpd(@Param("vo") EmployeeVO vo);

    public void empDel(@Param("vo") EmployeeVO vo);
}
