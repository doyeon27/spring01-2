package com.yi.spring.controller;

import com.yi.spring.mappers.EmployeeMapper;
import com.yi.spring.service.EmployeeService;
import com.yi.spring.vo.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller // 스프링이 해당 클래스를 컨트롤러로 인식하게 하는 어노테이션
@ComponentScan // 클래스 패스 에서 @Controller 어노테이션이 붙은 클래스를 찾아 빈으로 등록하게 하는 어노테이션
@RequestMapping("/emp/*") // 클래스 레벨에서의 URL 매핑. 이 클래스의 모든 메소드는 /emp/로 시작하는 URL 에 매핑됨
public class EmpController {

    @Autowired // 의존성 주입을 위한 어노테이션으로 EmployeeService 을 주입 받음
    EmployeeService employeeService;

    @Autowired // 의존성 주입을 위한 어노테이션으로 EmployeeMapper 을 주입 받음
    EmployeeMapper employeeMapper;

    private static final String namespace = "mappers.EmployeeMapper.";


    @GetMapping("/emplist")
    public String empList(EmployeeVO vo, Model model) throws Exception{

        List<EmployeeVO> employeeList = employeeService.listEmployees(); //
//        System.out.println(employeeList);
//        for (int i = 0; i < employeeList.size(); i++){
//            System.out.println(employeeList.get(i).getDept());
//        }
        model.addAttribute("list", employeeList);

        return "/emp/emp_list";
    }

    @GetMapping("/empAdd")
    public String empAddForm(EmployeeVO vo, Model model) throws Exception{

        return "emp/emp_listForm";
    }

    @PostMapping("/empAdd")
    public String empAdd(EmployeeVO vo, Model model) throws Exception{
        System.out.println("111->" + vo.getEmpCode());
        System.out.println(vo.getEmpName());
        System.out.println(vo.getEmpPwd());
        employeeService.empAdd(vo);

        return "redirect:/emp/emplist";
//        return "/emp/emp_list";
    }


    @PostMapping("/emp/empUpd")
    public String empUpd(@RequestParam("empCode") String empCode,
                         @RequestParam("empName") String empName,
                         @RequestParam("empTitle") String empTitle,
                         @RequestParam("empAuth") String empAuth,
                         @RequestParam("empSalary") int empSalary,
                         @RequestParam("empTel") String empTel,
                         @RequestParam("empId") String empId,
                         @RequestParam("empPwd") String empPwd,
                         @RequestParam("deptNo") String deptNo,
                         Model model) throws Exception{

        System.out.println("emp 수정 테스트");
        EmployeeVO vo = new EmployeeVO();

        vo.setEmpCode(empCode);
        vo.setEmpName(empName);
        vo.setEmpTitle(empTitle);
        vo.setEmpAuth(empAuth);
        vo.setEmpSalary(empSalary);
        vo.setEmpTel(empTel);
        vo.setEmpId(empId);
        vo.setEmpPwd(empPwd);
        vo.setDeptNo(deptNo);

        employeeService.empUpd(vo);

        return "redirect:/emp/emplist";
    }

    @PostMapping("/emp/empDel")
    public String empDel(@RequestParam("empName") String empName, Model model) throws Exception{
        System.out.println("삭제??");
        EmployeeVO vo = new EmployeeVO();

        vo.setEmpName(empName);

        employeeService.empDel(vo);

        return "redirect:/emp/emplist";
    }








//// 이건 다른 방법인듯?
//    @GetMapping("/emplist")
//    public String empList2(EmployeeVO vo, Model model) throws Exception{
//
//        List<EmployeeVO> employeeList = employeeMapper.listEmployees();
////        System.out.println(employeeList);
//
//
//        return "/emp/emp_list";
//    }


}
