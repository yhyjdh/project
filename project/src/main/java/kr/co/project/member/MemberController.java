package kr.co.project.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.Getter;

@Controller
public class MemberController {
	
	@Autowired
	MemberService service;
	
	@GetMapping("/member/join.do")
	public String join() {
		return "member/join";
	}
	
	@PostMapping("/member/join.do")
	public String join(MemberVO vo, Model model) {
		if(service.insert(vo) > 0) {
			model.addAttribute("msg","회원가입이 정상적으로 되었습니다.");
			model.addAttribute("url","login.do");			
			
			return "common/alert";
			
		}else {
			model.addAttribute("msg","회원가입 오류입니다.");
			return "common/alert";
		}
	}
	
	@GetMapping("/member/emailDupCheck.do")					// 서블릿으로 출력
	public void emailDupCheck(@RequestParam String email, HttpServletResponse res) throws IOException {
		int count = service.emailDupCheck(email);
		boolean r = false;
		if(count == 1) r = true; //count가 1이면 r을 true로 바꿈
		
		PrintWriter out = res.getWriter();
		out.print(r);
		out.flush();
	}
	
	@GetMapping("/member/login.do")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("/member/login.do")
	public String login(MemberVO vo, HttpSession sess, Model model) {
		if(service.loginCheck(vo, sess)) {
			return "redirect:/board/index.do"; // 저장되어있는 board/index.do 불러오는거 
		} else {
			model.addAttribute("msg", "이메일 비밀번호를 확인해 주세요");
			return "common/alert";
		}
	}
	
	@GetMapping("/member/logout.do") // 세션객체 필요
	public String logout(Model model, HttpServletRequest req) {
		HttpSession sess = req.getSession();
		sess.invalidate(); // 세션초기화 (세션객체에있는 모든 값들이 삭제)
		//sess.removeAttribute("loginInfo"); // 세션객체의 해당값만 삭제
		model.addAttribute("msg", "로그아웃되었습니다.");
		model.addAttribute("url", "/project/board/index.do");
		
		return "common/alert";
	}
	
	@GetMapping("/member/findEmail.do") 
	public String findEmail() {
		return "member/findEmail";
	}
	
	@PostMapping("/member/findEmail.do") // 파라미터 받는것 대부분 커맨트 객체
	public String findEmail(Model model, MemberVO param) {
		MemberVO vo = service.findEmail(param);
		if (vo != null) {
			model.addAttribute("result", vo.getEmail());
		}
		return "common/return";
	}
	
	@GetMapping("/member/findPwd.do") 
	public String findPwd() {
		return "member/findPwd";
	}
	
	@PostMapping("/member/findPwd.do") // 파라미터 받는것 대부분 커맨트 객체
	public String findPwd(Model model, MemberVO param) {
		MemberVO vo = service.findPwd(param);
		if (vo != null) {
			model.addAttribute("result", vo.getEmail()); // null이아님됨
		}
		return "common/return";
	}
	
	
}
