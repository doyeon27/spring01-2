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

        // list 라고 이름을 줘서 이거를 통해 데이터를 꺼낼수 있음
        // model 은 뷰로 데이터를 전달하는 용도로 사용되는 객체
        model.addAttribute("list", employeeList);
        System.out.println(employeeList);

        return "/emp/emp_list";
    }

    @GetMapping("/empAdd")
    public String empAddForm(EmployeeVO vo, Model model) throws Exception{


        return "emp/emp_listForm";
    }

    @PostMapping("/empAdd")
    public String empAdd(EmployeeVO vo, Model model) throws Exception{
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
        EmployeeVO vo = new EmployeeVO();

        vo.setEmpName(empName);

        employeeService.empDel(vo);

        return "redirect:/emp/emplist";
    }

//    EmployeeVO vo = new EmployeeVO();:
//    EmployeeVO 클래스의 객체를 생성합니다.
//    이 객체는 EmployeeVO 클래스의 인스턴스로, 직원 정보를 담기 위한 용도로 사용됩니다.
//    Java에서 객체는 클래스의 인스턴스이며,
//    객체를 생성하는 것은 해당 클래스의 인스턴스를 메모리에 할당하고, 그 객체를 조작할 수 있도록 하는 것입니다.
//            vo.setEmpName(empName);:
//
//    vo 객체의 setEmpName 메소드를 호출하여 해당 객체의 상태(멤버 변수)를 변경합니다.
//    setEmpName 메소드는 주로 직원의 이름을 설정하는 메소드로, 이를 통해 vo 객체에 직원의 이름 정보를 설정합니다.
//            employeeService.empDel(vo);:
//
//    employeeService 객체의 empDel 메소드를 호출합니다. 이때, vo 객체가 전달됩니다.
//    이 메소드는 주로 vo 객체에 담긴 정보를 기반으로 직원을 삭제하는 서비스를 수행합니다.
//    OOP의 다형성을 활용하여 메소드에게 EmployeeVO 객체를 전달하면,
//    해당 객체가 어떤 클래스의 인스턴스인지에 따라 적절한 동작을 수행하게 됩니다.








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
