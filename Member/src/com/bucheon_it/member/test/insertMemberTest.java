/**
 * 
 */
package com.bucheon_it.member.test;

import java.util.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;

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
	    String str =
		            new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
		                .format(new Date(System.currentTimeMillis()));
		Date date = null;
        
        try {
        	date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(str);
        	} catch (ParseException e) {
            e.printStackTrace();
        }

	    MemberDAO dao = MemberDAOImpl.getInstance();

     /*   MemberVO member1 = new MemberVO("java3",
        								"java",
        								"사나이",
        								'f',
        								"java@java.com",
        								"010-1234-5678",
        								"02-123-2222",
        								"22222",
        								"서울시 구로구 대치동",
        							    java.sql.Date.valueOf("2011-08-11"),
        								(java.sql.Date(date)));
*/
		}
	}

