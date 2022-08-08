package kr.co.project.comment;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentVO {
	
	private int no;
	private String content;
	private int member_no;
	private int board_no;
	private Timestamp regdate;
	private String tablename;
	private String member_name;
	
	private int page; // 파라미터로 보낼때 같은 이름이면 원하는 화면이 안날올수있음
	private int startIdx;
	private int pageRow; // 
	
			// 생성자
	public CommentVO() {
		this.page = 1;
		this.pageRow = 10; // 10으로 초기화 
	}
}
