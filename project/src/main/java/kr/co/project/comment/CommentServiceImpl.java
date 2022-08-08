package kr.co.project.comment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.project.board.BoardVO;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentMapper mapper;
	
	@Override
	public Map index(CommentVO vo) {
		
		int totalCount = mapper.count(vo); // 총게시물수
		// 총페이지수
		int totalPage = totalCount / vo.getPageRow(); //->기본 10;
		if(totalCount % vo.getPageRow() > 0) totalPage++; 
		
		// 시작인덱스
		
		int startIdx = (vo.getPage()-1) * vo.getPageRow();
		vo.setStartIdx(startIdx); // vo 주입
		
		List<CommentVO> list = mapper.list(vo); //list 호출
		
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
	public int insert(CommentVO vo) {
		
		return mapper.insert(vo);
	}

	@Override
	public int delete(CommentVO vo) {
		
		return mapper.delete(vo.getNo());
	}

}
