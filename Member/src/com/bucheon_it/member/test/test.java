/**
 * 
 */
package com.bucheon_it.member.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bucheon_it.member.dao.MemberDAO;
import com.bucheon_it.member.dao.MemberDAOImpl;
import com.bucheon_it.member.vo.MemberVO;

/**
 * @author a
 *
 */
public class test {

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
		  
		  List<MemberVO> members = new ArrayList<MemberVO>();
		  String sql = "SELECT * FROM member1_tbl";
		  StringBuffer sb = new StringBuffer(sql);

		  members = dao.getAllMembers(sb);
		  for (MemberVO member : members) 
			    System.out.println("아이디  : "
			    		   +member.getId() + " " 
			    				  +"비밀번호 : "
			               +member.getPw()+ " " 
			            		  +"이름 : "
			               + member.getName()+ " " 
			            		  +"성별 : "
			               + member.getGender()+ " " 
			            		   +"메일주소 : "
		                   + member.getEmail()+ " " 
		                		   +"연락처(휴대폰) : "
		                   + member.getMobile()+ " "
		                		   +"연락처2 : "
		                   + member.getPhone()+ " "
		                		   +"도로명 우편번호 : "
		                   + member.getZip()+ " " 
		                		   +"도로명 주소 : "
		                   + member.getAddress()+ " " 
		                		   +"생년 월일 :  : "
		                   + member.getBirthday()+ " " 
		                		   +"가입일 : "
		                   + member.getJoindate()+ " " 
			               + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date));
			 } // main
			}

