package com.sseda.dao;

import java.sql.Array;
import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sseda.common.OracleConn;
import com.sseda.dto.Cre;
import com.sseda.dto.FirstmyVo;
import com.sseda.dto.Item;
import com.sseda.dto.Member;

import oracle.jdbc.OracleType;
import oracle.jdbc.OracleTypes;


@Repository
public class MemberDaoImp implements MemberDao {
	
	@Autowired
	DataSource dbconn;
	
	@Override
	public String[] loginproc(String id, String pw) {
		String[] loginStat = new String[2];
		CallableStatement stmt = null;
		Connection conn = null;
		String sql = "{call p_loginproc(?,?,?,?)}";
		
		try {
			conn = dbconn.getConnection();
			stmt = conn.prepareCall(sql);
			stmt.setString(1, id);
			stmt.setString(2, pw);
			
			stmt.registerOutParameter(3, OracleType.VARCHAR2);
			stmt.registerOutParameter(4, OracleType.VARCHAR2);
			stmt.executeQuery();
			
			String name = stmt.getNString(3);
			String result = stmt.getString(4);
			
			if(result != null) {
				if(result.equals("ok")) {
					loginStat[0] = result;
					loginStat[1] = name;
				}
				if(result.equals("pwfail")) {
					loginStat[0] = result;
				}
				if(result.equals("loginfail")) {
					loginStat[0] = result;
				}
				if(result.equals("deluser")) {
					loginStat[0] = result;
				}	
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			resourceClose(conn, stmt);
		}
		return loginStat;
	}
	
	@Override
	public FirstmyVo firstmy(String id) {
		Connection conn = null;
		CallableStatement stmt = null;
		FirstmyVo fmv = new FirstmyVo();
		
		String sql = " call p_mypage(?,?)";
		
		try {
			conn = dbconn.getConnection();
			stmt = conn.prepareCall(sql);
						
			stmt.setString(1, id);
			stmt.registerOutParameter(2, OracleTypes.CURSOR);
			stmt.executeQuery();
			
			ResultSet rs = (ResultSet)stmt.getObject(2);
			
			if(rs.next()) {
				fmv.setId(rs.getString("id"));
				fmv.setName(rs.getString("name"));
				fmv.setEmail(rs.getString("email"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			resourceClose(conn, stmt);
		}
		return fmv;
	}	
	
	@Override
	public Member mydetail(String id) {
		
		Connection conn = null;
		CallableStatement stmt = null;
		Member member = new Member();
		String sql = " call p_mydetail(?,?)";
		
		try {
			conn = dbconn.getConnection();
			stmt = conn.prepareCall(sql);
			
			stmt.setString(1, id);
			stmt.registerOutParameter(2, OracleTypes.CURSOR);
			stmt.executeQuery();
			
			ResultSet rs = (ResultSet)stmt.getObject(2);
			
			if(rs.next()) {
				member.setId(rs.getString("id"));
				member.setPw(rs.getNString("pw"));
				member.setName(rs.getString("name"));
				member.setGender(rs.getString("gender"));
				member.setNickname(rs.getString("nickname"));
				member.setPhonenumber(rs.getString("phonenumber"));
				member.setEmail(rs.getString("email"));
				member.setGrade(rs.getInt("grade"));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			resourceClose(conn, stmt);
		}
		
		return member;
	}
	
	private void resourceClose(Connection conn, CallableStatement mt) { 
		try { 
			if(mt != null || conn != null) {
				mt.close(); 
				conn.close();
			} 
		} catch(SQLException e) { 
			e.printStackTrace(); 
		}
	  
	}
	
	@Override
	public int changeinfo(Member member) {
		Connection conn = null;
		CallableStatement stmt = null;
		String sql = "call p_changemy(?,?,?,?,?,?)";
		int rs = 0;
		
		try {
			conn = dbconn.getConnection();
			stmt = conn.prepareCall(sql);
			
			stmt.setString(1, member.getId());
			stmt.setString(2, member.getPw());
			stmt.setString(3, member.getNickname());
			stmt.setString(4, member.getEmail());
			stmt.setString(5, member.getPhonenumber());
			
			stmt.registerOutParameter(6, OracleTypes.INTEGER);
			stmt.executeQuery();

			rs = stmt.getInt(6);
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			resourceClose(conn, stmt);
		}
		return rs;
	}
	
	@Override
	public void delreq(String id) {
		
		Connection conn = null;
		CallableStatement stmt = null;
		String sql = "call p_delreq(?)";
		
		
		try {
			conn = dbconn.getConnection();
			stmt = conn.prepareCall(sql);
			
			stmt.setString(1, id);
			stmt.executeQuery();

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			resourceClose(conn, stmt);
		}
		
	}

	public String DBcheckid(String id) {
		Connection conn = null;
		CallableStatement stmt = null;
		String sql = "call p_DBcheckid(?,?)";
		String rs = null;
	
		try {
			conn = dbconn.getConnection();
			stmt = conn.prepareCall(sql);
			
			stmt.setString(1, id);
			stmt.registerOutParameter(2, OracleTypes.PLSQL_BOOLEAN);
			stmt.executeQuery();
			
			rs = String.valueOf(stmt.getBoolean(2));
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			resourceClose(conn, stmt);
		}

		return rs;
	}

	public void signup(Member member) {
		Connection conn = null;
		CallableStatement stmt = null;
		
		String sql = "call p_signup(?,?,?,?,?,?,?)";
	
		try {
			conn = dbconn.getConnection();
			stmt = conn.prepareCall(sql);
			
			stmt.setString(1, member.getId());
			stmt.setString(2, member.getPw());
			stmt.setString(3, member.getName());
			stmt.setString(4, member.getNickname());
			stmt.setString(5, member.getGender());
			stmt.setString(6, member.getPhonenumber());
			stmt.setString(7, member.getEmail() + member.getEdomain());
			
			stmt.executeQuery();
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			resourceClose(conn, stmt);
		}
		
	}

	public List<Item> myitem(String id,Cre cre) {
		
		Connection conn = null;
		CallableStatement stmt = null;
		String sql = "call p_get_myitemlist(?,?,?,?)";
		List<Item> itemlist = new ArrayList<Item>();
		
		try {
			conn = dbconn.getConnection();
			stmt = conn.prepareCall(sql);
			
			stmt.setString(1, id);
			stmt.setInt(2, cre.getCpage());
			stmt.setInt(3, cre.getRow());
			stmt.registerOutParameter(4, OracleTypes.CURSOR);
			stmt.executeQuery();
			
			ResultSet rs = (ResultSet)stmt.getObject(4);
			
			while(rs.next()) {
				Item it = new Item();
				it.setSeqno(rs.getString("item_seqno"));
				it.setTitle(rs.getString("title"));
				if(rs.getString("code").equals("N")) {
					it.setCode("소설");
				} else if(rs.getString("code").equals("W")) {
					it.setCode("웹소설");
				} else if(rs.getString("code").equals("E")) {
					it.setCode("에세이");
				} else {
					it.setCode("시");
				}
				it.setMatching(rs.getString("matching"));
				it.setCount(rs.getString("cnt"));
				it.setPrice(rs.getString("price"));
				if(rs.getString("isopen").equals("Y")) {
					it.setOpen("공개");
				} else {
					it.setOpen("비공개");
				}
				it.setCfcheck(rs.getString("cfcheck"));
				itemlist.add(it);
			}
				
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			resourceClose(conn, stmt);
		}
		return itemlist;
	}

	public void myitemdel(String[] seqno) {
		
		Connection conn = null;
		CallableStatement stmt = null;
		
		String sql = "call p_get_myitemlist(?)";
		
		try {
			conn = dbconn.getConnection();
			stmt = conn.prepareCall(sql);
			
			
			stmt.executeQuery();
			
				
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			resourceClose(conn, stmt);
		}
		
	}

	public Member changedetail(String id) {
			
		Member member = new Member();
		Connection conn = null;
		CallableStatement stmt = null;
		
		String sql = "call p_changedetail(?,?)";
		
		try {
			
			conn = dbconn.getConnection();
			stmt = conn.prepareCall(sql);
			stmt.setString(1, id);
			stmt.registerOutParameter(2, OracleTypes.CURSOR);
			stmt.executeQuery();
			
			ResultSet rs = (ResultSet)stmt.getObject(2);
			
			if(rs.next()) {
				member.setId(rs.getNString("id"));
				member.setPw(rs.getString("pw"));
				member.setNickname(rs.getString("nickname"));
				member.setPhonenumber(rs.getString("phonenumber"));
				member.setEmail(rs.getString("email"));
			}
			
				
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			resourceClose(conn, stmt);
		}
		
		return member;
	}

	public int myitemtotal(String id) {
		Connection conn = null;
		CallableStatement stmt = null;
		int result = 0;
		
		String sql = "call p_get_totalmyitemlist(?,?)";
		
		try {
			
			conn = dbconn.getConnection();
			stmt = conn.prepareCall(sql);
			stmt.setString(1, id);
			stmt.registerOutParameter(2, OracleTypes.INTEGER);
			stmt.executeQuery();
			
			result = stmt.getInt(2);
	
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			resourceClose(conn, stmt);
		}
		
		
		return result;
	}
}
