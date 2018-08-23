/**
 * 
 */
package com.bucheon_it.member.test;

import com.bucheon_it.member.dao.MemberDAO;
import com.bucheon_it.member.dao.MemberDAOImpl;

/**
* 개별 회원 정보 유무 점검(Check) 단위 테스트(Unit Test)
* @author 
*
*/
public class isMemberTest {

   /**
    * @param args
    * @throws Exception
    */
   public static void main(String[] args) throws Exception {

       MemberDAO dao = MemberDAOImpl.getInstance();
       System.out.println(dao.isMember("java1", "java1") == true ?
                           "회원입니다" : "회원이 아닙니다");
   } //

}
