package kr.co.project.news;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	NewsMapper mapper;
	
	@Override				// 모델에 넣어서해도 됨 
	public Map index(NewsVO vo) {
		int totalCount = mapper.count(vo); // 총게시물수
		// 총페이지수
		int totalPage = totalCount / vo.getPageRow(); //->10;
		if(totalCount % vo.getPageRow() > 0) totalPage++; 
		
		// 시작인덱스
		
		int startIdx = (vo.getPage()-1) * vo.getPageRow();
		vo.setStartIdx(startIdx); // vo 주입
		
		List<NewsVO> list = mapper.list(vo); //list 호출
		
		// 페이징처리										// 번호가 최대나오는거
		int endPage = (int)(Math.ceil(vo.getPage()/10.0) * 10);
		int startPage = endPage-9; 
							// 뺀다음 대입
		if(endPage > totalPage) endPage = totalPage;
		boolean prev = startPage > 1 ? true : false; // 1보다 크면 true, 아님 false
		boolean next = endPage < totalPage ? true : false; 
		
		
		Map map = new HashMap();
		map.put("totalCount", totalCount);
		map.put("totalPage", totalPage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("prev", prev);
		map.put("next", next);
		map.put("list", list);
		
		return map;
	}

	@Override
	public NewsVO view(int no) {
		mapper.updateViewcount(no);
		return mapper.view(no); // 업데이트먼저
	}

	@Override
	public NewsVO edit(int no) {
		
		return mapper.view(no);
	}

	@Override
	public boolean update(NewsVO vo) {
		
		return mapper.update(vo) > 0 ? true : false;
	}

	@Override
	public boolean delete(int no) {
		
		return mapper.delete(no) > 0 ? true : false;
	}

	@Override
	public boolean insert(NewsVO vo) {
		
		return mapper.insert(vo) > 0 ? true : false; // mapper.insert(vo)호출
	}

}
