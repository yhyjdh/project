package interceptor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class MemberLoginInterceptor implements HandlerInterceptor {

	/*
	  preHandle : 컨트롤러 실행 전
	  postHandle : 컨트롤러 실행 후 (뷰 리턴전)
	  afterCompletion : 뷰 실행 후   
	*/
	
	// Handler 재정의
	@Override          // req객체로 세션가져오기
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws IOException {
		// 세션객체에서 loginInfo이름으로 꺼내서 있으면(로그인 상태) return true,
		// 아니면(로그아웃) return false
							// req객체로 세션가져오기
		HttpSession sess = req.getSession();
		if(sess.getAttribute("loginInfo") == null) { // 로그아웃상태
			res.setContentType("text/html; charset=utf-8");
			PrintWriter out = res.getWriter();
			out.println("<script>");
			out.println("alert('로그인 후 사용가능합니다.(인터셉터)')");//(인터셉터)
			out.println("location.href='/project/member/login.do';");
			out.println("</script>");
			out.flush();
			return false;
		}
		return true;
	}
	
	
}
