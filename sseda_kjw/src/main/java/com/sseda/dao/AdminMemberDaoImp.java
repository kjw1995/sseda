package com.sseda.dao;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sseda.common.OracleConn;
import com.sseda.dto.AdminList;
import com.sseda.dto.Cre;
import com.sseda.dto.Member;
import com.sseda.dto.SeachName;

import oracle.jdbc.OracleTypes;

@Repository
public class AdminMemberDaoImp implements AdminMemberDao {
	
		@Autowired
		DataSource ds;
		
		@Override
		public AdminList memberlist(Cre cre) {
			
			Connection conn = null;
			CallableStatement stmt = null;
			
			AdminList l = new AdminList();
			List<Member> member = new ArrayList<Member>();
			
			String sql = "call p_admim_memberlist(?,?,?,?,?,?,?,?,?)";
			
			String grade1 = null;
			String grade2 = null;
			
			 try {
				conn = ds.getConnection(); 
				stmt = conn.prepareCall(sql);
				if(cre.getSearchname().getGrade() == null) {
					grade1 = "";
					grade2 = "";
					
				} else {
					grade1 = cre.getSearchname().getGrade()[0];
					grade2 = cre.getSearchname().getGrade()[1];
				}
				
				stmt.setString(1, grade1);
				stmt.setString(2, grade2);
				stmt.setString(3, cre.getSearchname().getStart());
				stmt.setString(4, cre.getSearchname().getEnd());
				stmt.setString(5, cre.getSearchname().getSh());
				stmt.setString(6, cre.getSearchname().getKey());
				stmt.setInt(7, cre.getCpage());
				stmt.setInt(8, cre.getRow());
				
				stmt.registerOutParameter(9, OracleTypes.CURSOR);
				
			    stmt.executeQuery();
				
			    ResultSet rs =(ResultSet)stmt.getObject(9);
				
				while(rs.next()) {
					Member m = new Member();
					m.setId(rs.getString("id"));
					m.setName(rs.getString("name"));
					m.setNickname(rs.getString("nickname"));
					m.setEmail(rs.getString("email"));
					m.setG(rs.getString("grade"));
					m.setWdate(rs.getString("wdate"));
					
					member.add(m);
				}
				l.setM(member);		
			} catch (SQLException e) {
				e.printStackTrace();
			}	
			return l;
		}

		@Override
		public Member detailList(String id) {
			
			Connection conn = null;
			CallableStatement stmt = null;
			
			Member m = new Member();
			List<String> g = new ArrayList<String>();
			
			String sql = "call p_admin_memberdetail(?,?)";
				   
				   
				   try {
					conn = ds.getConnection();
					stmt = conn.prepareCall(sql);
					stmt.setString(1, id);
					stmt.registerOutParameter(2, OracleTypes.CURSOR);
					stmt.executeQuery();
					
					ResultSet rs = (ResultSet)stmt.getObject(2);
					
					 if(rs.next()) {
						  m.setId(rs.getString("id"));
						  m.setPw(rs.getString("pw"));
						  m.setGender(rs.getString("gender"));
						  m.setPhonenumber(rs.getString("phonenumber"));
						  m.setName(rs.getString("name"));
						  m.setEmail(rs.getString("email"));
						  m.setNickname(rs.getString("nickname"));
						  m.setIsdel(rs.getString("isdel"));
						  m.setWdate(rs.getString("wdate"));
						  if(rs.getString("gradeo") == null ) {
							  g.add(rs.getString("gradei"));	  
							  m.setAgrade(g);
						  } else {
							  g.add(rs.getString("gradei"));
							  g.add(rs.getString("gradeo"));
							  m.setAgrade(g);
						  }
						  
						  m.setAmount(rs.getString("amount"));
					  }
					
				} catch (SQLException e) {
					e.printStackTrace();
				}	finally {
					resourceClose(conn, stmt);
				}
				   
				  System.out.println("다오값" + m.getId());
			return m;
		}


		private void resourceClose(Connection conn, CallableStatement stmt) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<Member> deleteList() {

			Connection conn = null;
			CallableStatement stmt = null;
			
			List<Member> member = new ArrayList<Member>();
			
			String sql = "call p_admin_deletelist(?)";
			
		
			
			try {
				conn = ds.getConnection();
				stmt = conn.prepareCall(sql);
				stmt.registerOutParameter(1, OracleTypes.CURSOR);
		
			    stmt.executeQuery();
			    ResultSet rs = (ResultSet)stmt.getObject(1);
			    
				while(rs.next()) {
					Member m = new Member();
					m.setId(rs.getString("id"));
					m.setName(rs.getString("name"));
					m.setNickname(rs.getString("nickname"));
					m.setEmail(rs.getString("email"));
					m.setG(rs.getString("grade"));
					m.setIsdeldate("isdeldate");
					
					member.add(m);
				}
			    
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			return member;
		}


		@Override
		public void delete(String id) {

			Connection conn = null;
			CallableStatement stmt = null;
			
			String sql = "call p_admin_delete(?)";
			System.out.println("아이디" + id);
			
			try {
				conn = ds.getConnection();
				stmt = conn.prepareCall(sql);
				stmt.setString(1, id);
				
				stmt.executeQuery();
				stmt.close();
				conn.close();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		}
		
		@Override
		public int total(Cre cre) {
			int total = 0;
			Connection conn = null;
			CallableStatement stmt = null;
			
			String sql = "call p_admember_total(?,?,?,?,?,?,?)";
			
			String grade1 = null;
			String grade2 = null;
			
			try {
				conn = ds.getConnection();
				stmt = conn.prepareCall(sql);
				
				if(cre.getSearchname().getGrade() == null) {
					grade1 = "";
					grade2 = "";
					
				} else {
					grade1 = cre.getSearchname().getGrade()[0];
					grade2 = cre.getSearchname().getGrade()[1];
				}
				
				stmt.setString(1, grade1);
				stmt.setString(2, grade2);
				stmt.setString(3, cre.getSearchname().getStart());
				stmt.setString(4, cre.getSearchname().getEnd());
				stmt.setString(5, cre.getSearchname().getSh());
				stmt.setString(6, cre.getSearchname().getKey());
				stmt.registerOutParameter(7,OracleTypes.INTEGER);
				stmt.executeQuery();
				total = stmt.getInt(7);
			} 
				catch (SQLException e) {
				
				e.printStackTrace();
			}
			System.out.println(total);
			return total;
			
		}
		
		@Override
		public String update(String id) {
			System.out.println("---------------업데이트-------- " + id);
			Connection conn = null;
			PreparedStatement stmt = null;
			
			
			String sql="insert into grade(grade_seqno,id,grade) "
					+ "values(GRADE_SEQNO.nextval,?,'O')";
			
			try {
				conn = ds.getConnection();
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, id);
				stmt.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return "updateOk"; 
		}

}
