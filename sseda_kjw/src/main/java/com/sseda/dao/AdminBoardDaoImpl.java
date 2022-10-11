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

import oracle.jdbc.OracleTypes;

@Repository
public class AdminBoardDaoImpl implements AdminBoardDao {

	@Autowired
	private DataSource ds;
	
	public List<Board> boardList(Cre cri) {
		Connection conn = null;
		CallableStatement stmt = null;
		List<Board> board = new ArrayList<Board>();
		
		
	
		String sql = "call p_admin_boardlist(?,?,?,?,?)";
			
			try {
				conn = ds.getConnection();
				stmt = conn.prepareCall(sql);
				stmt.setString(1, cri.getSearchField());
				stmt.setString(2, cri.getSearchText());
				stmt.setInt(3, cri.getCpage());
				stmt.setInt(4, cri.getRow());
				stmt.registerOutParameter(5, OracleTypes.CURSOR);
				stmt.executeQuery();
				
				ResultSet rs = (ResultSet)stmt.getObject(5);
				
				while(rs.next()) {
					Board b = new Board();
					b.setNo(rs.getString("board_seqno"));
					b.setTitle(rs.getString("title"));
					b.setWdate(rs.getString("wdate"));
					b.setId(rs.getString("id"));
					b.setContent(rs.getString("content"));
					board.add(b);
				}
					conn.close();
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			return board;
	}

	@Override
	public int delete(String string) {
		int rs = 0;
		
		String sql =  "call p_admin_deleteboard(?,?)";
		Connection conn;
		try {
			conn = ds.getConnection();
			CallableStatement stmt = conn.prepareCall(sql);
			stmt.setString(1, string);
			stmt.registerOutParameter(2, OracleTypes.INTEGER);
			stmt.executeQuery();
			rs = stmt.getInt(2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}

	@Override
	public int gettotal(Cre cri) {
		int total = 0;
		
		String sql = "call p_admin_totalboard(?,?,?)";
		Connection conn;
		try {
			conn = ds.getConnection();
			CallableStatement stmt = conn.prepareCall(sql);
			stmt.setString(1, cri.getSearchField());
			stmt.setString(2, cri.getSearchText());
			stmt.registerOutParameter(3, OracleTypes.INTEGER);
			stmt.executeQuery();
			total = stmt.getInt(3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}
}
