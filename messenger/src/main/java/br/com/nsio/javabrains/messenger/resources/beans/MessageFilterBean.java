package br.com.nsio.javabrains.messenger.resources.beans;

import javax.ws.rs.QueryParam;

public class MessageFilterBean {

	private @QueryParam("year") int year;
	private @QueryParam("start") int start;
	private @QueryParam("pageSize") int pageSize;
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
