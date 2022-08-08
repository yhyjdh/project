package kr.co.project.news;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NewsMapper { 

	int insert(NewsVO vo); 
	
	int count(NewsVO vo); //(Map map)
	
	List<NewsVO> list(NewsVO vo); //select list 리턴타입으로 확인
	
	NewsVO view(int no); // 상세 조회 //select one
	
	void updateViewcount(int no);
	
	int update(NewsVO vo);
	
	int delete(int no);
	
}
