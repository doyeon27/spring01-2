package com.yi.spring.service;

//import com.yi.spring.dao.MemberDAO;

import com.yi.spring.mappers.MemberMapper;
import com.yi.spring.vo.MemberVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Component
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;
//    @Autowired
//    private SqlSession sqlsession;
    private static final String namespace = "mappers.MemberMapper.";

    @Override
    public List<MemberVO> listMembers() {
        List<MemberVO> membersList = null;
//        membersList = sqlsession.selectList(namespace + "listMembers");
        membersList = memberMapper.listMembers();
        return membersList;
    }

    @Override
    public void userAdd(MemberVO vo) throws Exception {
        System.out.println("service->" + vo);
//        sqlsession.insert(namespace + "userAdd", vo);
        memberMapper.userAdd(vo);
    }

    @Override
    public void userDel(MemberVO vo) throws Exception {
        System.out.println("service->" + vo);
//        sqlsession.delete(namespace + "userDel", vo);
        memberMapper.userDel(vo);
    }

    @Override
    public void userUpd(MemberVO vo) throws Exception {
        System.out.println("service->" + vo);
//        sqlsession.update(namespace + "userUpd", vo);
        memberMapper.userUpd(vo);
    }

}
