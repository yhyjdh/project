package kr.co.project.member;

import javax.servlet.http.HttpSession;

public interface MemberService {
	
	int insert(MemberVO vo);
	
	int emailDupCheck(String email);
	
	// 리턴 할 필요없고 됐는지 체크만
	boolean loginCheck(MemberVO vo, HttpSession sess);
	
	MemberVO findEmail(MemberVO vo);
	
	MemberVO findPwd(MemberVO vo);
}
