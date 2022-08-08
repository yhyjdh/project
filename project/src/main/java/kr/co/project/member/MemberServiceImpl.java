package kr.co.project.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import util.SendMail;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper mapper;
	
	@Override
	public int insert(MemberVO vo) {
	
		return mapper.insert(vo);
	}
	
	@Override
	public int emailDupCheck(String email) {
		return mapper.emailDupCheck(email);
	}

	@Override
	public boolean loginCheck(MemberVO vo, HttpSession sess) {
		
		boolean r = false;
		
		MemberVO loginInfo = mapper.loginCheck(vo);
		
		if(loginInfo != null) {
			r = true;
			// 로그인 성공시 세션에 저장
			sess.setAttribute("loginInfo", loginInfo);
		}		
		return r;
	}

	@Override
	public MemberVO findEmail(MemberVO vo) {		
		return mapper.findEmail(vo);
	}

	@Override
	public MemberVO findPwd(MemberVO vo) {
		// update
		MemberVO mv = mapper.findEmail(vo);
		if(mv != null) {
			// 임시비밀번호 생성
			// 영문두자리(65~91), 숫자두자리(1~9)
			String temp = "";
			for(int i = 0; i<2; i++) {
				temp += (char)(Math.random()*26+65);
			}			
			for(int i = 0; i<2; i++) {
				temp += (int)(Math.random()*9);
			}			
			
			// 임시비밀번호 update
			vo.setPwd(temp); // vo에 비밀번호가 set되어야함
			mapper.updateTempPwd(vo);
			
			// email 발송
			SendMail.sendMail("yhyjdh@naver.com", vo.getEmail(), "[더조은]임시비밀번호", "임시비밀번호: "+temp);			
			
			return mv;
		} else {				
			return null;
		
		}
	}
}
