package kr.co.project.board;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper { 

	int insert(BoardVO vo); 
	
	int count(BoardVO vo); //(Map map)
	
	List<BoardVO> list(BoardVO vo); //select list 리턴타입으로 확인
	
	BoardVO view(int no); // 상세 조회 //select one
	
	void updateViewcount(int no);
	
	int update(BoardVO vo);
	
	int delete(int no);
	
}
