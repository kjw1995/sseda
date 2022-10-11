package com.sseda.dao;

import java.sql.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sseda.dto.Cre;
import com.sseda.dto.Item;
import com.sseda.dto.Files;

import oracle.jdbc.internal.OracleTypes;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

@Repository
public class ItemDaoimp implements ItemDao {
	
	@Autowired
	private DataSource dbconn;
	
	@Override
	public List<Item> list(Cre c) {
		List<Item> i = new ArrayList<Item>();
		String sql ="CALL p_itemlist(?,?,?,?,?,?,?)";
		try {
			Connection conn = dbconn.getConnection();
			CallableStatement stmt = conn.prepareCall(sql);
			stmt.setInt(1, c.getCpage());
			stmt.setInt(2, c.getRow());
			stmt.setString(3, c.getCode());
			System.out.println("리스트코드"+c.getCode());
			stmt.setString(4, c.getMeto_meti());
			stmt.setString(5, c.getDivision());
			stmt.setString(6, c.getKey());
			stmt.registerOutParameter(7,OracleTypes.CURSOR);
			stmt.executeQuery();
			ResultSet rs = (ResultSet)stmt.getObject(7);
			while(rs.next()) {
				Item it = new Item();
				it.setTitle(rs.getString("title"));
				it.setName(rs.getString("name"));
				it.setSeqno(rs.getString("item_seqno"));
				it.setCount(rs.getString("cnt"));
				it.setWdate(rs.getString("wdate"));
				it.setPrice(rs.getString("price"));
				i.add(it);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	public Item detail(String seqno, String id) {
		Item i = new Item();
	      try {
	    	 Connection conn = dbconn.getConnection();
	         String sql="CALL p_itemdetail(?,?,?,?)";
	         int no = Integer.parseInt(seqno);
	         CallableStatement stmt = conn.prepareCall(sql);
	         stmt.setInt(1, no);
	         stmt.setString(2, id);
	         stmt.registerOutParameter(3, OracleTypes.CURSOR);
	         stmt.registerOutParameter(4, OracleTypes.INTEGER);
	         stmt.executeQuery();
	         ResultSet rs = (ResultSet)stmt.getObject(3);
	         rs.next();
	         i.setTitle(rs.getString("title"));
	         i.setContent(rs.getString("content"));
	         i.setCount(rs.getString("cnt"));
	         i.setPrice(rs.getString("price"));
	         i.setName(rs.getString("name"));
	         i.setWdate(rs.getString("wdate"));
	         i.setId(rs.getString("id"));
	         i.setSeqno(rs.getString("item_seqno"));
	         i.setCfcheck(rs.getString("cfcheck"));
	         i.setLike(stmt.getInt(4));
	         if(rs.getString("f_seqno")!= null) {
	        	 Files f = new Files();
	        	 f.setSeqno(rs.getString("f_seqno"));
	        	 f.setFilename(rs.getString("upfile"));
	        	 f.setSavefile(rs.getString("savefile"));
	        	 f.setFilepath(rs.getString("filepath"));
	        	 i.setFile(f);
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return i;
	}
	public void delete(String no) {
		String sql="UPDATE item SET item_de='Y' WHERE item_seqno =?";
		try {
			Connection conn = dbconn.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, no);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void reg(Item i) {
		String sql="CALL p_itemreg(?,?,?,?)";
		try {
			Connection conn = dbconn.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, i.getTitle());
			stmt.setString(2, i.getContent());
			stmt.setString(3, i.getOpen());
			stmt.setString(4, i.getSeqno());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public String insert(Item i,Files fi){
		String sql = "Call p_iteminsert(?,?,?)";
		String no = null;
		try {
			Connection conn = dbconn.getConnection();
			CallableStatement stmt = conn.prepareCall(sql);
			StructDescriptor sd = StructDescriptor.createDescriptor("OBJ_ITEM",conn);
			Object[] o = {i.getTitle(),i.getContent(),i.getId(),i.getCfcheck(),i.getOpen(),i.getPrice(),i.getCode()};
			STRUCT s = new STRUCT(sd,conn,o);
			stmt.setObject(1, s);
			StructDescriptor fsd = StructDescriptor.createDescriptor("OBJ_ITEMFILE",conn);
			Object[] fo = {fi.getFilename(),fi.getSavefile(),fi.getFilesize(),fi.getFiletype(),fi.getFilepath()};
			STRUCT sf = new STRUCT(fsd,conn,fo);
			stmt.setObject(2, sf);
			stmt.registerOutParameter(3, OracleTypes.INTEGER);
			stmt.executeQuery();
			no = Integer.toString((int)stmt.getInt(3));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return no;
	}
	public void report(String no) {
		String sql="CALL p_itemreport(?)";
		try {
			Connection conn = dbconn.getConnection();
			CallableStatement stmt = conn.prepareCall(sql);
			stmt.setString(1, no);
			stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public int getT(Cre c) {
		String sql="CALL p_itemtotal(?,?,?,?,?)";
		int s = 0;
		try {
			Connection conn = dbconn.getConnection();
			CallableStatement stmt = conn.prepareCall(sql);
			stmt.setString(1, c.getCode());
			stmt.setString(2, c.getMeto_meti());
			stmt.setString(3, c.getDivision());
			stmt.setString(4, c.getKey());
			stmt.registerOutParameter(5, oracle.jdbc.OracleTypes.INTEGER);
			stmt.executeQuery();
			s = (int)stmt.getInt(5);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
}
