/**
 *
 */
package com.bucheon_it.member.test;
 
import com.bucheon_it.member.dao.MemberDAO;
import com.bucheon_it.member.dao.MemberDAOImpl;
import com.bucheon_it.member.vo.MemberVO;
 
/**
 * 개별 회원 정보 획득
 * @author javateam
 *
 */
public class GetMembersTest {
 
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
 
        MemberDAO dao = MemberDAOImpl.getInstance();
        MemberVO member = dao.getMember("java1");
        // System.out.println(member.toString());
        System.out.println(member);
    } //
}