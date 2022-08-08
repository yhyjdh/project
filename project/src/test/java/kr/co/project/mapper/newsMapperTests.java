package kr.co.project.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.project.board.BoardVO;
import kr.co.project.news.NewsMapper;
import kr.co.project.news.NewsVO;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/config/servlet-context.xml")
@Log4j
public class newsMapperTests {
	
	@Autowired	
	private NewsMapper mapper; // 타입만 BoardMapper
	
	@Test 
	public void testObj() {
		
		NewsVO vo= new NewsVO();
		
		vo.setTitle("게시물 제목");
		vo.setContent("게시물 내용");
		
		int r = 0;
		for (int i=0; i<30; i++) { //20개추가
			r += mapper.insert(vo);
		}
		log.info("등록개수" + r);
	}
	
	//@Test
//	public void count() {
//		Map map = new HashMap();
//		map.put("stype", "all");
//		map.put("sword", "게시물");
//		int totalCount = mapper.count(map);
//		System.out.println("총카운드: " + totalCount);
//	}
	
	//@Test
//	public void list() {
//		Map map = new HashMap();
//		map.put("startIdx", 0);
//		map.put("pageRow", 10);
//		List<BoardVO> list = mapper.list(map);
//		
//		list.forEach(vo->log.info(vo)); //람다식
//		//for(BoardVO vo : mapper.list(map)) { log.info(vo); }
//
//		//log.info(list);
//	}
//	
	//@Test
	public void view() {
		//업데이트 후 조회 증가
		mapper.updateViewcount(1);
		log.info(mapper.view(1));
	}
	
	//@Test
	public void update() {
		NewsVO vo = new NewsVO();
		vo.setTitle("제목수정");
		vo.setContent("내용수정");
		vo.setNo(24);
		log.info("update:"+mapper.update(vo));
	}
	
	//@Test
	public void delete() {
		log.info("delete:" + mapper.delete(23));
	}
}
