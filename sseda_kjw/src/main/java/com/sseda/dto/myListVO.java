package com.sseda.dto;

import java.util.List;

public class myListVO {

	private myList mylist;
	private int total;
	
	public myListVO(int total, myList mylist) {
		this.mylist = mylist;
		this.total = total;
	}

	public myList getMylist() {
		return mylist;
	}

	public void setMylist(myList mylist) {
		this.mylist = mylist;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	
	
}
