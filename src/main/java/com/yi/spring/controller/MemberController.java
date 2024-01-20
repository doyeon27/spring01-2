package com.yi.spring.controller;

import com.yi.spring.service.MemberService;
import com.yi.spring.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Member;
import java.util.List;

@Controller
@ComponentScan
@RequestMapping("/member/*")
public class MemberController {

    @Autowired
    private MemberService memberService;
    private static final String namespace = "mappers.MemberMapper.";

    @GetMapping("/userAdd")
    public String userAddForm(MemberVO vo, Model model) throws Exception {

        return "member/listForm";
    }

    @PostMapping("/userAdd")
    public String userAdd(MemberVO vo, Model model) throws Exception {

        System.out.println("111->" + vo.getUserId());
        System.out.println(vo.getUserName());
        System.out.println(vo.getUserPassword());
        memberService.userAdd(vo);

        return "redirect:/member/userList";
    }

    // 목록보기
    @GetMapping("/userList")
    public String userList(MemberVO vo, Model model) throws Exception {

        List<MemberVO> list = memberService.listMembers(); // MemberServiceImpl 에 있는 listMembers 사용

        System.out.println(list);

        model.addAttribute("list", list);

        return "member/list";
    }

    @PostMapping("/member/userDel")
    public String userDel(@RequestParam("userNo") int userNo, Model model) throws Exception {

//        List<MemberVO> list = memberService.listMembers(); // MemberServiceImpl 에 있는 listMembers 사용
//
//        System.out.println(list);

        System.out.println("hihihih");
//        model.addAttribute("list", list);
        MemberVO vo = new MemberVO();

        vo.setUserNo(userNo);

        memberService.userDel(vo);

        return "redirect:/member/userList";
    }

    @PostMapping("/member/userUpd")
    public String userUpd(@RequestParam("userNo") int userNo,@RequestParam("userName") String userName, @RequestParam("userId") String userId,
                          @RequestParam("userPassword") String userPassword, Model model) throws Exception {

        System.out.println("수정테스트");
        MemberVO vo = new MemberVO();

        vo.setUserNo(userNo);
        vo.setUserId(userId);
        vo.setUserName(userName);
        vo.setUserPassword(userPassword);

        memberService.userUpd(vo);

        return "redirect:/member/userList";
    }

}
