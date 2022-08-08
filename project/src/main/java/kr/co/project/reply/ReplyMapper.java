package kr.co.project.reply;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReplyMapper { 

	int insert(ReplyVO vo); 
	
	int count(ReplyVO vo); //(Map map)
	
	List<ReplyVO> list(ReplyVO vo); //select list 리턴타입으로 확인
	
	ReplyVO view(int no); // 상세 조회 //select one
	
	void updateViewcount(int no);
	
	int update(ReplyVO vo);
	int gnoUpdate(int gno);
	int onoUpdate(ReplyVO vo);
	int reply(ReplyVO vo);
	
	int delete(int no);
	
	
	
}
