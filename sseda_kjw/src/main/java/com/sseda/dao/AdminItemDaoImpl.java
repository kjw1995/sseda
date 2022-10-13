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

import oracle.jdbc.OracleTypes;

@Repository
public class AdminItemDaoImpl implements AdminItemDao {


	@Autowired
	private DataSource ds;
	
	@Override
	public List<Item> itemList(Cre c) {
		Connection conn = null;
		CallableStatement stmt = null;
		List<Item> item = new ArrayList<Item>();
		

		String sql = "call p_admin_item(?,?,?,?,?)";
			
			try {
				conn = ds.getConnection();
				stmt = conn.prepareCall(sql);
				stmt.setString(1, c.getSearchField());
				stmt.setString(2, c.getSearchText());
				stmt.setInt(3, c.getCpage());
				stmt.setInt(4, c.getRow());
				stmt.registerOutParameter(5, OracleTypes.CURSOR);
				stmt.executeQuery();
				
				ResultSet rs = (ResultSet)stmt.getObject(5);
				
				while(rs.next()) {
					Item i = new Item();
					i.setSeqno(rs.getString("item_seqno"));
					i.setTitle(rs.getString("title"));
					i.setWdate(rs.getString("wdate"));
					i.setId(rs.getString("id"));
					i.setContent(rs.getString("content"));
					item.add(i);
				}
					conn.close();
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		
		
		return item;
	}

	@Override
	public int delete(String ino) {
		int rs = 0;
		
		String sql =  "call p_admin_deleteitem(?,?)";
		Connection conn;
		try {
			conn = ds.getConnection();
			CallableStatement stmt = conn.prepareCall(sql);
			stmt.setString(1, ino);
			stmt.registerOutParameter(2, OracleTypes.INTEGER);
			stmt.executeQuery();
			rs = stmt.getInt(2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public int gettotal(Cre c) {
		int t = 0;
		
		String sql = "call p_admin_totalitem(?,?,?)";
		Connection conn;
		try {
			conn = ds.getConnection();
			CallableStatement stmt = conn.prepareCall(sql);
			stmt.setString(1, c.getSearchField());
			stmt.setString(2, c.getSearchText());
			stmt.registerOutParameter(3, OracleTypes.INTEGER);
			stmt.executeQuery();
			t = stmt.getInt(3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t;
	}

}
