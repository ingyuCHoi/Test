package com.bucheon_it.member.test;

import java.sql.Date;

import com.bucheon_it.member.dao.MemberDAO;
import com.bucheon_it.member.dao.MemberDAOImpl;
import com.bucheon_it.member.vo.MemberVO;

/**
 * 회원정보 갱신(Update Row) 단위 테스트(Unit Test)
 *
 * @author javateam
 *
 */
public class UpdateTest {
 
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
 
        // 1. DAO 객체 생성
        MemberDAO dao = MemberDAOImpl.getInstance();
        MemberVO member = new MemberVO();
        member.setId("oraclejava");
        member.setPw("java");
        member.setName("최인규");
        member.setGender("남".charAt(0));
        member.setEmail("rmeoaka1@naver.com");
        member.setMobile("010-1234-5678");
        member.setPhone("02-2222-2222");
        member.setZip("05000");
        member.setBirthday(Date.valueOf("1999-01-01"));
        member.setJoindate(Date.valueOf("2018-08-22"));
       
        dao.updateMember(member);
       
    } //
 
}