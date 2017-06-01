package ncs.test4;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

public class Notice implements Serializable {
	private int no;
	private String title;
	private Date date;
	private String writer;
	private String content;

	public Notice() {
	}

	public Notice(int no, String title, Date date, String writer, String content) {
		this.no = no;
		this.title = title;
		this.date = date;
		this.writer = writer;
		this.content = content;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		String str = null;

		switch (no) {
		case 0:
			str = "첫";
			break;
		case 1:
			str = "두";
			break;
		case 2:
			str = "세";
			break;
		default:
			str = no + "";

		}
		
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
		
		return str + "번째 공지글 " + sd.format(date)+ " " + writer + " " + content;
	}

}
