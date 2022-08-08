package kr.co.project.board;

import java.util.Map;

public interface BoardService {

	// 목록 -리턴타입생각(컨트롤러로 넘어감 컨트롤러에서 뭐가필요한지)
	//총개수, 총페이지, 리스트 // Map 담아서 리턴 put
	Map index(BoardVO vo);
	
	// 상세 
	BoardVO view(int no);
	
	// 수정폼
	BoardVO edit(int no);
	
	// 수정처리	// 매개변수 객체
	boolean update(BoardVO vo);
	
	// 삭제처리
	boolean delete(int no);
	
	// 등록처리
	boolean insert(BoardVO vo);

}
