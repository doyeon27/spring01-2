package com.yi.spring.service;

import com.yi.spring.vo.MemberVO;

import java.util.List;

public interface MemberService {

    // 사용자 목록을 볼거니까(인원이 여러명 이니까) 배열로
    public List<MemberVO> listMembers() throws Exception;

    public void userAdd(MemberVO vo) throws Exception;
    public void userDel(MemberVO vo) throws Exception;
    public void userUpd(MemberVO vo) throws Exception;


}
