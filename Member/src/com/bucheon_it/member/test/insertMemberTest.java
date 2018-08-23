/**
 * 
 */
package com.bucheon_it.member.test;

import java.sql.Date;
import com.bucheon_it.member.dao.MemberDAO;
import com.bucheon_it.member.dao.MemberDAOImpl;
import com.bucheon_it.member.vo.MemberVO;

/**
 * @author a
 *
 */
public class insertMemberTest {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
	    MemberDAO dao = MemberDAOImpl.getInstance();

        MemberVO member1 = new MemberVO("java6",
        								"ja",
        								"감투",
        								'm',
        								"java@java.com",
        								"010-1234-5678",
        								"02-123-2222",
        								"66666",
        								"서울시 구로구 서초동",
        							    Date.valueOf("2013-08-12"),
        								"2015-03-11 15:00:00");
        dao.insertMember(member1);
		}
	}

