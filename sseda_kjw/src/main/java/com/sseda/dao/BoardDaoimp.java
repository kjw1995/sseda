package com.sseda.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sseda.common.OracleConn;
import com.sseda.dto.Board;
import com.sseda.dto.BoardList;
import com.sseda.dto.Cre;
import com.sseda.dto.Files;
import com.sseda.dto.Keyword;

import oracle.jdbc.OracleTypes;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

@Repository
public class BoardDaoimp implements BoardDao {
	
	
	@Autowired
	private DataSource dbconn;
	
	@Override
	public String insert(Board b,Files file) {
		String n = null;
		String sql="CALL p_boardinsert(?,?,?,?,?,?,?,?)";
		try {
			Connection conn = dbconn.getConnection();
			CallableStatement stmt = conn.prepareCall(sql);
			stmt.setString(1, b.getTitle());
			stmt.setString(2, b.getContent());
			stmt.setString(3, b.getOpen());
			stmt.setString(4, b.getId());
			stmt.setString(5, file.getFilename());
			stmt.setString(6, file.getSavefile());
			stmt.setString(7, file.getFilepath());
			stmt.registerOutParameter(8, OracleTypes.INTEGER);
			stmt.executeQuery();
			n = Integer.toString(stmt.getInt(8));
			conn.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	@Override
	public Board detail(String no, String id) {
		String sql="CALL p_boarddetail(?,?,?)";
		Board b = new Board();
		try {
			Connection conn = dbconn.getConnection();
			CallableStatement stmt = conn.prepareCall(sql);
			stmt.setString(1, id);
			stmt.setString(2, no);
			stmt.registerOutParameter(3, OracleTypes.CURSOR);
			stmt.executeUpdate();
			ResultSet rs = (ResultSet)stmt.getObject(3);
			rs.next();
			b.setTitle(rs.getString("title"));
			b.setNo(rs.getString("board_seqno"));
			b.setContent(rs.getString("content"));
			b.setName(rs.getString("name"));
			b.setWdate(rs.getString("wdate"));
			b.setId(rs.getString("id"));
			b.setOpen(rs.getString("isopen"));
			b.setLike(rs.getString("cnt"));
			if(rs.getString("t") != null) {
				b.setLike_seqno(rs.getString("t"));
			}else {
				b.setLike_seqno("no");
			}
			
			conn.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}
	
	@Override
	public BoardList board(Cre c) {
		String sql="CALL p_boardlist(?,?,?,?,?,?)";
		BoardList bl = new BoardList();
		try {
			Connection conn = dbconn.getConnection();
			List<Board> board = new ArrayList<>();
			CallableStatement stmt = conn.prepareCall(sql);
			stmt.setInt(1, c.getCpage());
			stmt.setInt(2, c.getRow());
			stmt.setString(3, c.getCate());
			stmt.setString(4, c.getKey());
			stmt.registerOutParameter(5, OracleTypes.CURSOR);
			stmt.registerOutParameter(6, OracleTypes.CURSOR);
			stmt.executeQuery();
			ResultSet rs = (ResultSet)stmt.getObject(5);
			while(rs.next()) {
				Board b = new Board();
				b.setTitle(rs.getString("title"));
				b.setCount(rs.getString("views"));
				b.setWdate(rs.getString("wdate"));
				b.setName(rs.getString("name"));
				b.setNo(rs.getString("board_seqno"));
				b.setNum(rs.getString("rownum"));
				board.add(b);
			}
			bl.setB(board);
			rs = (ResultSet)stmt.getObject(6);
			//키워드 관련
			Keyword k = new Keyword();
			rs.next();
			k.setSeqno(rs.getString("keyword_seqno"));
			k.setKeyword(rs.getString("keyword"));
			bl.setK(k);
			
			conn.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bl;
	}

	public void reg(Board b) {
		String sql="UPDATE eventboard SET title=? , content=?, isopen=? WHERE board_seqno=?";
		try {
			Connection conn = dbconn.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, b.getTitle());
			stmt.setString(2, b.getContent());
			stmt.setString(3, b.getOpen());
			stmt.setString(4, b.getNo());
			stmt.executeUpdate();
			
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void del(String no) {
		String sql="DELETE FROM reply WHERE board_seqno=?";
		try {
			Connection conn = dbconn.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, no);
			stmt.executeUpdate();
			sql="DELETE FROM recom WHERE board_seqno=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, no);
			stmt.executeUpdate();
			sql="UPDATE eventboard SET board_de = 'Y' WHERE board_seqno=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, no);
			stmt.executeUpdate();
			
			conn.close();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void report(String no) {
		String sql="UPDATE eventboard SET report = report + 1 WHERE board_seqno = ?";
		try {
			Connection conn = dbconn.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1,no);
			stmt.executeUpdate();
			
			
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public int getT(Cre c) {
		String sql="CALL p_boardtotal(?,?,?)";
		System.out.println("카테고리 :"+c.getCate());
		System.out.println("키워드 :"+c.getKey());
		int s = 0;
		try {
			Connection conn = dbconn.getConnection();
			CallableStatement stmt = conn.prepareCall(sql);
			stmt.setString(1, c.getCate());
			stmt.setString(2, c.getKey());
			stmt.registerOutParameter(3, OracleTypes.INTEGER);
			stmt.executeQuery();
			s = stmt.getInt(3);
			System.out.println("레코드 수 : "+s);
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
	public int like(HttpServletRequest request) {
		int s = 0;
		String sql="CALL p_like(?,?,?,?)";
		HttpSession sess = request.getSession();
		try {
			Connection conn = dbconn.getConnection();
			String stat = null;
			if(request.getParameter("stat") == null){
				stat = "";
			}else {
				stat = request.getParameter("stat");
			}
			CallableStatement stmt = conn.prepareCall(sql);
			stmt.setString(1, stat);
			stmt.setInt(2, Integer.parseInt(request.getParameter("no")));
			stmt.registerOutParameter(3, OracleTypes.INTEGER);
			stmt.setString(4, (String)sess.getAttribute("sess_id"));
			stmt.executeQuery();
			s = stmt.getInt(3);
			
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return s;
	}

}
