package kr.co.project.news;


import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NewsVO {

	private int no;
	private String title;
	private String content;
	private Timestamp regdate;
	private int viewcount;
	private int member_no;
	private String filename_org;
	private String filename_real;
	
	//service
	private int page; // 페이지
	private String stype; // 검색타입
	private String sword; // 검색어
	
	
	private int startIdx;
	private int pageRow; // 생성되는 순간 10
	private String tableName;

	// 페이지
	public NewsVO() {
//		this.page = 1;
//		this.pageRow = 10;
		this(1, 10);
	}
	public NewsVO (int page, int pageRow) {
		this.page = page;
		this.pageRow = pageRow;
		this.tableName = "news";
	}
	
}
