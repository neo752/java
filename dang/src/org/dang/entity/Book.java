package org.dang.entity;

import java.sql.Date;

public class Book extends Product{
	private static final long serialVersionUID = 1L;
	private int id;
	private String author,publishing,word_number,which_edtion,total_page,print_number,
	isbn,author_summary,catalogue ;
	private Date publish_time,print_time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublishing() {
		return publishing;
	}
	public void setPublishing(String publishing) {
		this.publishing = publishing;
	}
	public String getWord_number() {
		return word_number;
	}
	public void setWord_number(String wordNumber) {
		word_number = wordNumber;
	}
	public String getWhich_edtion() {
		return which_edtion;
	}
	public void setWhich_edtion(String whichEdtion) {
		which_edtion = whichEdtion;
	}
	public String getTotal_page() {
		return total_page;
	}
	public void setTotal_page(String totalPage) {
		total_page = totalPage;
	}
	public String getPrint_number() {
		return print_number;
	}
	public void setPrint_number(String printNumber) {
		print_number = printNumber;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getAuthor_summary() {
		return author_summary;
	}
	public void setAuthor_summary(String authorSummary) {
		author_summary = authorSummary;
	}
	public String getCatalogue() {
		return catalogue;
	}
	public void setCatalogue(String catalogue) {
		this.catalogue = catalogue;
	}
	public Date getPublish_time() {
		return publish_time;
	}
	public void setPublish_time(Date publishTime) {
		publish_time = publishTime;
	}
	public Date getPrint_time() {
		return print_time;
	}
	public void setPrint_time(Date printTime) {
		print_time = printTime;
	}
	
}
