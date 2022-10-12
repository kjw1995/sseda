package com.sseda.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sseda.dto.Board;
import com.sseda.dto.Cre;
import com.sseda.dto.Item;
import com.sseda.dto.Reply;
import com.sseda.dto.myList;

import oracle.jdbc.OracleTypes;

@Repository
public class MyPageDaoImp implements MyPageDao{

	@Autowired
	DataSource dbconn;
		
	@Override
	public myList mylist(Cre cre, String id,String cate) {
		
		Connection conn = null;
		CallableStatement stmt = null;
		
		myList list = new myList();
		List<Item> itemList = new ArrayList<Item>();
		List<Board> boardList = new ArrayList<Board>();
		List<Reply> replyList = new ArrayList<Reply>();
		
		String sql = "call p_get_mylist(?,?,?,?,?)";
	
		try {
			conn = dbconn.getConnection();
			stmt = conn.prepareCall(sql);
			stmt.setString(1, id);
			stmt.setString(2, cate);
			stmt.setInt(3, cre.getCpage());
			stmt.setInt(4, cre.getRow());
			stmt.registerOutParameter(5, OracleTypes.CURSOR);
			stmt.executeQuery();
			
			ResultSet rs = (ResultSet)stmt.getObject(5);
			if(cate.equals("item")) {
				
				while(rs.next()) {
					Item item = new Item();
					item.setSeqno(rs.getString("item_seqno"));
					item.setTitle(rs.getString("title"));
					if(rs.getString("code").equals("N")) {
						item.setCode("소설");
					} else if(rs.getString("code").equals("W")) {
						item.setCode("웹소설");
					} else if(rs.getString("code").equals("E")) {
						item.setCode("에세이");
					} else {
						item.setCode("시");
					}
					item.setMatching(rs.getString("matching"));
					item.setCount(rs.getString("cnt"));
					item.setPrice(rs.getString("price"));
					if(rs.getString("isopen").equals("Y")) {
						item.setOpen("공개");
					} else {
						item.setOpen("비공개");
					}
					item.setCfcheck(rs.getString("cfcheck"));
					itemList.add(item);
					list.setItem(itemList);
			}
			
			} else if(cate.equals("board")) {
				
				while(rs.next()) {
					Board board = new Board();
					board.setNo(rs.getString("board_seqno"));
					board.setTitle(rs.getString("title"));
					board.setWdate(rs.getString("wdate"));
					board.setCount(rs.getString("views"));
					board.setKeyword(rs.getString("keyword"));
					boardList.add(board);
				}
				list.setBoard(boardList);
			} else if(cate.equals("reply")) {
				
				while(rs.next()) {
					Reply reply = new Reply();
					reply.setBoard_no(rs.getString("board_seqno"));
					reply.setContent(rs.getString("content"));
					reply.setWdate(rs.getString("wdate"));
					reply.setBoard_title(rs.getString("title"));
					replyList.add(reply);
				}
				list.setReply(replyList);
			} 
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			resourceClose(conn, stmt);
		}
		
		return list;
	}

	@Override
	public int total(String id, String cate) {
		Connection conn = null;
		CallableStatement stmt = null;
		int result = 0;
		
		String sql = "call p_get_mylisttotal(?,?,?)";
		
		try {
			
			conn = dbconn.getConnection();
			stmt = conn.prepareCall(sql);
			
			stmt.setString(1, id);
			stmt.setString(2, cate);
			stmt.registerOutParameter(3, OracleTypes.INTEGER);
			
			stmt.executeQuery();
			
			result = stmt.getInt(3);
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			resourceClose(conn, stmt);
		}
		
		
		return result;
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
	
	
}
