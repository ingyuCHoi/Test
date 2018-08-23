/**
 * 
 */
package com.bucheon_it.member.test;

import com.bucheon_it.member.dao.MemberDAO;
import com.bucheon_it.member.dao.MemberDAOImpl;
import com.bucheon_it.member.vo.MemberVO;

/**
 * @author a
 *
 */
public class AllMembersArrayTest {

	 
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
 
        MemberDAO dao = MemberDAOImpl.getInstance();
        MemberVO[] members = dao.getAllMembersArray();
        System.out.println("행의 갯수 : "+dao.getRowCount());
        for (MemberVO m : members)
            System.out.println(m);

  
           
           
    } //
 
} 