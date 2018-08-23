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
        member.setId("java1");
        member.setPw("java1");
        member.setName("임꺾정");
        member.setGender("m".charAt(0));
        member.setEmail("java@java.com");
        member.setMobile("010-1234-5678");
        member.setPhone("032-123-2222");
        member.setZip("10055");
        member.setBirthday(Date.valueOf("1999-01-01"));
        member.setJoindate("2018-08-20 17:02:00");
        
        MemberVO member1 = new MemberVO("java1",
				"java",
				"임꺽정",
				'm',
				"java@java.com",
				"010-1234-5678",
				"02-123-2222",
				"22222",
				"서울시 구로구 대치동",
			    Date.valueOf("2011-08-11"),
				"2012-02-10 18:00:00");
        dao.updateMember(member1);
       
    } //
 
}