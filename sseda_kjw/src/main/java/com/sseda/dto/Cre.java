package com.sseda.dto;

public class Cre {
	private int cpage;
	private int row;
	private String code;
	private String meto_meti;
	private String division;
	private String key;
	private String cate;
	private String searchField;
	private String searchText;
	private SeachName searchname;
	
	public Cre() {
		super();
	}
	public Cre(int page,int row) {
		super();
		this.cpage = page;
		this.row = row;
	}
	public int getCpage() {
		return cpage;
	}
	public void setCpage(int cpage) {
		this.cpage = cpage;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMeto_meti() {
		return meto_meti;
	}
	public void setMeto_meti(String meto_meti) {
		this.meto_meti = meto_meti;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	public String getSearchField() {
		return searchField;
	}
	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}
	public String getSearchText() {
		return searchText;
	}
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	public SeachName getSearchname() {
		return searchname;
	}
	public void setSearchname(SeachName searchname) {
		this.searchname = searchname;
	}
	
	
	
	
	
}
