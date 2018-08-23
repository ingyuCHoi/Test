/**
 * 
 */
package com.bucheon_it.member.test;

import com.bucheon_it.member.dao.MemberDAO;
import com.bucheon_it.member.dao.MemberDAOImpl;

/**
 * @author a
 *
 */
public class deleteMemberTest {

	/**
	 * @param args
	 *
	 */
	public static void main(String[] args) throws Exception {
		MemberDAO dao = MemberDAOImpl.getInstance();
		dao.deleteMember("java");

	}

}
