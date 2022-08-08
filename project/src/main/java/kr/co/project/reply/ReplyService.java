package kr.co.project.reply;

import java.util.Map;

public interface ReplyService {

	// 목록 -리턴타입생각(컨트롤러로 넘어감 컨트롤러에서 뭐가필요한지)
	//총개수, 총페이지, 리스트 // Map 담아서 리턴 put
	Map index(ReplyVO vo);
	
	// 상세 
	ReplyVO view(int no);
	
	// 수정폼
	ReplyVO edit(int no);
	
	// 수정처리	// 매개변수 객체
	boolean update(ReplyVO vo);
	
	// 삭제처리
	boolean delete(int no);
	
	// 등록처리
	boolean insert(ReplyVO vo); //gno update 여기서
	
	// 답변등록
	boolean reply(ReplyVO vo);

}
