package com.sseda.dto;

import java.util.List;

public class Replylist {
	private List<Reply> reply;
	private int total;
	
	
	public List<Reply> getReply() {
		return reply;
	}
	public void setReply(List<Reply> reply) {
		this.reply = reply;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
	
	
}
