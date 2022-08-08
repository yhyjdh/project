package kr.co.project.board;


import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardVO {

	private int no;
	private String title;
	private String content;
	private Timestamp regdate;
	private int viewcount;
	private int member_no;
	private String filename_org;
	private String filename_real;
	
	// 작성자
	private String member_name;	
	// 댓글담을 
	private int comment_count;
	
	
	// service // 파라미터
	private int page; // 페이지
	private String stype; // 검색타입
	private String sword; // 검색어
	
	// map -> BoardVO
	private int startIdx; // 시작 인덱스
	private int pageRow; //페이지당 개수 생성되는 순간 10
	// 시작 인덱스 ~ 10개
	

	// 페이지
	public BoardVO() {
//		this.page = 1;
//		this.pageRow = 10;
		this(1, 10);
	}
	public BoardVO (int page, int pageRow) {
		this.page = page;
		this.pageRow = pageRow;
	}
	
}
