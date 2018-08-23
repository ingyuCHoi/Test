/**
 * 
 */
package com.bucheon_it.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bucheon_it.member.util.DbUtil;
import com.bucheon_it.member.util.ExceptionMetadata;
import com.bucheon_it.member.vo.MemberVO;

/**
 * @author a
 *
 */
public final class MemberDAOImpl implements MemberDAO {
	
	private static MemberDAOImpl instance = null;
	   
    private MemberDAOImpl() {}
   
    public static final MemberDAOImpl getInstance() {
       
        if (instance == null) {
            instance = new MemberDAOImpl();
        }
       
        return instance;
    } 
	/* (non-Javadoc)
	 * @see com.bucheon_it.member.dao.MemberDAO#insertMember(com.bucheon_it.member.vo.MemberVO)
	 */
	@Override
	public void insertMember(MemberVO member) throws Exception {
		 Connection con = DbUtil.connect();
	        PreparedStatement pstmt = null;

	        String sql = "INSERT INTO member1_tbl VALUES "
	                   + "(?,?,?,?,?,?,?,?,?,?,?)";
	       
	        try {
	                // 4. SQL 구문 처리/예외처리(try ~ catch)
	                pstmt = con.prepareStatement(sql);
	               
	                // 5. SQL 구문 인자 처리(대입)
	                pstmt.setString(1, member.getId());
	                pstmt.setString(2, member.getPw());
	                pstmt.setString(3, member.getName());
	                pstmt.setString(4, member.getGender()+"");
	                pstmt.setString(5, member.getEmail());
	                pstmt.setString(6, member.getMobile());
	                pstmt.setString(7, member.getPhone());
	                pstmt.setString(8, member.getZip());
	                pstmt.setString(9, member.getAddress());
	                pstmt.setDate(10, member.getBirthday());
	                pstmt.setString(11, member.getJoindate());
	                // 6. SQL 구문 실행/메시징
	                if (pstmt.executeUpdate() == 1) {
	                    System.out.println("회원 정보 저장에 성공하였습니다.");
	                } else {
	                    System.out.println("회원 정보 저장에 실패하였습니다.");
	                }
	               
	        } catch (SQLException e) {
	            System.out.println("MemberDAOImpl insertMember SE :");
	            e.printStackTrace();
	        } catch (Exception e) {
	            System.out.println("MemberDAOImpl insertMember E :");
	            e.printStackTrace();
	        } finally {
	            // 7. DB 연결 해제(자원 반납)
	            DbUtil.close(con, pstmt, null);
	        } // try
	       
	    } //
	/* (non-Javadoc)
	 * @see com.bucheon_it.member.dao.MemberDAO#updateMember(com.bucheon_it.member.vo.MemberVO)
	 */
	@Override
	public void updateMember(MemberVO member) throws Exception {
		 Connection con = DbUtil.connect();
	       
	        // 2. SQL 처리 객체
	        PreparedStatement pstmt = null;
	       
	        // 3. SQL 구문
	        String sql = "UPDATE member1_tbl SET "
	                   + " password = ?,"
	                   + " name = ?,"
	                   + " gender = ?,"
	                   + " email = ?,"
	                   + " mobile = ?,"
	                   + " phone = ?,"
	                   + " zip = ?,"
	                   + " address = ?,"
	                   + " birthday = ?,"
	                   + " joindate = ?,"
	                   + " WHERE id = ?";
	        
	       StringBuilder sb = new StringBuilder();
	       sb.append("UPDATE member1_tbl SET ");
	       sb.append("pw = ?,");
	       sb.append("name = ?,");
	       sb.append("gender = ?,");
	       sb.append("email = ?,");
	       sb.append("mobile = ?,");
	       sb.append("phone = ?,");
	       sb.append("zip = ?,");
	       sb.append("address = ?,");
	       sb.append("birthday = ?,");
	       sb.append("joindate = ?,");
	       sb.append("WHERE id = ?,");
	        try {
	               
	                pstmt = con.prepareStatement(sql);
	               
	                // 5. SQL 구문 인자 처리(대입)
	                pstmt.setString(1, member.getPw());
	                pstmt.setString(2, member.getName());
	                pstmt.setString(3, member.getGender()+"");
	                pstmt.setString(4, member.getEmail());
	                pstmt.setString(5, member.getMobile());
	                pstmt.setString(6, member.getPhone());
	                pstmt.setString(7, member.getZip());
	                pstmt.setString(8, member.getAddress());
	                pstmt.setDate(9, member.getBirthday());
	                pstmt.setString(10, member.getJoindate());
	                pstmt.setString(11, member.getId());
	                // 6. SQL 구문 실행/메시징
	                if (pstmt.executeUpdate() == 1) {
	                    System.out.println("회원 정보 갱신에 성공하였습니다.");
	                } else {
	                    System.out.println("회원 정보 갱신에 실패하였습니다.");
	                }
	               
	        } catch (SQLException e) {
	            System.out.println("MemberDAOImpl updateMember SE :");
	            e.printStackTrace();
	        } catch (Exception e) {
	            System.out.println("MemberDAOImpl updateMember E :");
	            e.printStackTrace();
	        } finally {
	            // 7. DB 연결 해제(자원 반납)
	            DbUtil.close(con, pstmt, null);
	        } // try
	        System.out.println("UPDATE COMPLETE");
	       
	    } //

	/* (non-Javadoc)
	 * @see com.bucheon_it.member.dao.MemberDAO#getAllMembers()
	 */
	@Override
	public List<MemberVO> getAllMembers(StringBuffer sb) throws Exception {
		
		 Connection con = DbUtil.connect(); // DB 연결
	        List<MemberVO> members = new ArrayList<>();
	        // MemberVO member = new MemberVO(); // 결과값(개별 회원 정보)
	        MemberVO member = null;
	        PreparedStatement pstmt = null; // SQL 처리 객체
	        ResultSet rs = null; // SQL 결과셋 객체
	        String sql = "SELECT * FROM member1_tbl";
	       
	        try {
	        	pstmt = con.prepareStatement(sql.toString()); 
	            rs = pstmt.executeQuery(); // SQL 구문 실행 -> 결과셋
	           
	            while (rs.next()) {
	               
	                member = new MemberVO();
	                member.setId(rs.getString("id"));
	                member.setPw(rs.getString("pw"));
	                member.setName(rs.getString("name"));
	                member.setGender(rs.getString("gender").charAt(0));
	                member.setEmail(rs.getString("email"));
	                member.setMobile(rs.getString("mobile"));
	                member.setPhone(rs.getString("phone"));
	                member.setZip(rs.getString("zip"));
	                member.setAddress(rs.getString("address"));
	                member.setBirthday(rs.getDate("birthday"));
	                member.setJoindate(rs.getString("joindate"));
	               
	                members.add(member);
	            } //
	           
	        } catch (SQLException e) {
	            System.out.println("MemberDAOImpl getAllMembers SE : ");
	            e.printStackTrace();
	        } catch (Exception e) {
	            System.out.println("MemberDAOImpl getAllMembers E : ");
	            e.printStackTrace();
	        } finally {
	            DbUtil.close(con, pstmt, rs);
	        } //
	       
	        return members;
	    }

	/* (non-Javadoc)
	 * @see com.bucheon_it.member.dao.MemberDAO#getMember(java.lang.String)
	 */
	@Override
	public MemberVO getMember(String id) throws Exception {
		Connection con = DbUtil.connect(); // DB 연결
        MemberVO member = new MemberVO(); // 결과값(개별 회원 정보)
        PreparedStatement pstmt = null; // SQL 처리 객체
        ResultSet rs = null; // SQL 결과셋 객체
        String sql = "SELECT * FROM member1_tbl "
                   // + "WHERE id='"+id+"'";
                   + "WHERE id=?";
        try {
            pstmt = con.prepareStatement(sql); // SQL 구문 처리
            pstmt.setString(1,  id); // 인자 처리
            rs = pstmt.executeQuery(); // SQL 구문 실행 -> 결과셋

            while (rs.next()) {

                member.setId(rs.getString("id"));
                member.setPw(rs.getString("pw"));
                member.setName(rs.getString("name"));
                member.setGender(rs.getString("gender").charAt(0));
                member.setEmail(rs.getString("email"));
                member.setMobile(rs.getString("mobile"));
                member.setPhone(rs.getString("phone"));
                member.setZip(rs.getString("zip"));
                member.setAddress(rs.getString("address"));
                member.setBirthday(rs.getDate("birthday"));
                member.setJoindate(rs.getString("joindate"));
            } //
           
        } catch (SQLException e) {
            System.out.println("MemberDAOImpl getMember SE : ");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("MemberDAOImpl getMember E : ");
            e.printStackTrace();
        } finally {
            DbUtil.close(con, pstmt, rs);
        } //
        return member;
    }
	/**
     * @see com.javateam.member.dao.MemberDAO#getRowCount()
     */
    @Override
    public int getRowCount() { // throws Exception {
 
        ExceptionMetadata emd
            = new ExceptionMetadata(new Exception().getStackTrace()[0]);
        Connection con = DbUtil.connect();
        int count = 0;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT count(*) FROM member1_tbl";
 
        try {
                con.setAutoCommit(false);
                pstmt = con.prepareStatement(sql); // SQL 구문 처리
                rs = pstmt.executeQuery(); // SQL 구문 실행 -> 결과셋
               
                if (rs.next()) {
                    count = rs.getInt(1);
                } //
               
                con.commit();
               
        } catch (SQLException e) {
            emd.printErr(e, con, true);        
        } catch (Exception e) {
            emd.printErr(e, con, true);
        } finally {
            DbUtil.close(con, pstmt, rs);
        } //
       
        return count;
    }
	/* (non-Javadoc)
	 * @see com.bucheon_it.member.dao.MemberDAO#getAllMembers(java.lang.String)
	 */
	@Override
	public MemberVO[] getAllMembersArray() {
		
		ExceptionMetadata emd
        = new ExceptionMetadata(new Exception().getStackTrace()[0]);
    MemberVO[] members = new MemberVO[this.getRowCount()];
    Connection con = DbUtil.connect();
    MemberVO member = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String sql = "SELECT * FROM member1_tbl";
    int count = 0;
   
    try {
            con.setAutoCommit(false);
           
            // ResultSet 모드(mode) 조정
            pstmt = con.prepareStatement(sql,
                                ResultSet.TYPE_SCROLL_INSENSITIVE,
                                ResultSet.CONCUR_READ_ONLY);
           
            // ResultSet 모드(mode)
           
            // ResultSet.TYPE_FORWARD_ONLY
            // : ResultSet의 커서가 앞으로만 이동 가능
            // ResultSet.TYPE_SCROLL_INSENSITIVE
            // : ResultSet 위 커서가 앞뒤로 이동 가능하지만 해당 데이터의 변경이 바로 적용되지 않음.
            // ResultSet.TYPE_SCROLL_SENSITIVE
            // : ResultSet 위 커서가 앞뒤로 이동 가능하지만 해당 데이터의 변경이 바로 적용됨.
           
            // ResultSet.CONCUR_READ_ONLY
            // : ResultSet을 이용해서 데이터를 읽을 수 있음.
            // ResultSet.CONCUR_UPDATABLE
            // : ResultSet을 통해 데이터를 수정할 수 있음.
           
            rs = pstmt.executeQuery();
           
            rs.last(); // ResultSet 커서(cursor)를 맨마지막으로 이동
           
            // 여기서는 반드시 do ~ while을 사용해야 모든 행을 구할 수 있음.
            do {
               
                member = new MemberVO();
                member.setId(rs.getString("id"));
                member.setPw(rs.getString("pw"));
                member.setName(rs.getString("name"));
                member.setGender(rs.getString("gender").charAt(0));
                member.setEmail(rs.getString("email"));
                member.setMobile(rs.getString("mobile"));
                member.setPhone(rs.getString("phone"));
                member.setZip(rs.getString("zip"));
                member.setAddress(rs.getString("address"));
                member.setBirthday(rs.getDate("birthday"));
                member.setJoindate(rs.getString("joindate"));
                members[count++] = member;
               
            } while (rs.previous()); //
           
            con.commit();
       
    } catch (SQLException e) {
        emd.printErr(e, con, true);
    } catch (Exception e) {
        emd.printErr(e, con, true);
    } finally {
        DbUtil.close(con, pstmt, rs);
    } //
   
    return members;
} //

	/* (non-Javadoc)
	 * @see com.bucheon_it.member.dao.MemberDAO#deleteMember(java.lang.String)
	 */
	@Override
	public void deleteMember(String id) throws Exception {
        Connection con = DbUtil.connect();
        PreparedStatement pstmt = null;
        String sql = "DELETE member1_tbl "
                   + "WHERE id=?";
       
        try {
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, id);
                if (pstmt.executeUpdate() == 1) {
                    System.out.println("회원 정보 삭제에 성공하였습니다.");
                } else {
                    System.out.println("회원 정보 삭제에 실패하였습니다.");
                }
               
        } catch (SQLException e) {
            System.out.println("MemberDAOImpl deleteMember SE :");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("MemberDAOImpl deleteMember E :");
            e.printStackTrace();
        } finally {
            DbUtil.close(con, pstmt, null);
        } // try
 
    } //

	@Override
	public boolean isMember(String id) throws Exception {
		 Connection con = DbUtil.connect(); // DB 연결
	        boolean flag = false; // 결과값(회원 존재 여부)
	        PreparedStatement pstmt = null; // SQL 처리 객체
	        ResultSet rs = null; // SQL 결과셋 객체
	        String sql = "SELECT count(*) FROM member1_tbl "
	                   + "WHERE id=?";
	        try {
	                con.setAutoCommit(false);
	               
	                pstmt = con.prepareStatement(sql); // SQL 구문 처리
	                pstmt.setString(1,  id); // 인자 처리
	                rs = pstmt.executeQuery(); // SQL 구문 실행 -> 결과셋
	               
	                if (rs.next()) {
	                    flag = rs.getInt(1) == 1 ? true : false;
	                } //
	               
	                con.commit();
	           
	        } catch (SQLException e) {
	           
	            try {
	                    System.out.println("MemberDAOImpl isMember SE : ");
	                    e.printStackTrace();
	                    con.rollback();
	            } catch (Exception e2) {
	                e.printStackTrace();
	            }
	           
	        } catch (Exception e) {
	            try {
	                System.out.println("MemberDAOImpl isMember E : ");
	                e.printStackTrace();
	                con.rollback();
	            } catch (Exception e2) {
	                e.printStackTrace();
	            }
	        } finally {
	            DbUtil.close(con, pstmt, rs);
	        } //
	       
	        return flag;
	}

	@Override
	public boolean isMember(String id, String pw) throws Exception {
		Connection con = DbUtil.connect(); // DB 연결
        boolean flag = false; // 결과값(회원 존재 여부)
        PreparedStatement pstmt = null; // SQL 처리 객체
        ResultSet rs = null; // SQL 결과셋 객체
        String sql = "SELECT count(*) FROM member1_tbl "
                   + "WHERE id=? AND pw=?";
        try {
                con.setAutoCommit(false);
               
                pstmt = con.prepareStatement(sql); // SQL 구문 처리
                pstmt.setString(1,  id); // 인자 처리
                pstmt.setString(2,  pw); // 인자 처리
                rs = pstmt.executeQuery(); // SQL 구문 실행 -> 결과셋
               
                if (rs.next()) {
                    flag = rs.getInt(1) == 1 ? true : false;
                } //
               
                con.commit();
           
        } catch (SQLException e) {
           
            try {
                    System.out.println("MemberDAOImpl isMember SE : ");
                    e.printStackTrace();
                    con.rollback();
            } catch (Exception e2) {
                e.printStackTrace();
            }
           
        } catch (Exception e) {
            try {
                System.out.println("MemberDAOImpl isMember E : ");
                e.printStackTrace();
                con.rollback();
            } catch (Exception e2) {
                e.printStackTrace();
            }
        } finally {
            DbUtil.close(con, pstmt, rs);
        } //
       
        return flag;
	}
}

