package kr.co.project.board;

import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.co.project.comment.CommentService;
import kr.co.project.comment.CommentVO;
import kr.co.project.member.MemberVO;

@Controller
public class BoardController {
	
	@Autowired
	BoardService service;
	
	@Autowired
	CommentService cService;
	
	@GetMapping("/board/index.do")//modelAttrbuteboard
	public String index(Model model, BoardVO vo) {
		model.addAttribute("data", service.index(vo));
		return "board/index"; // (.jps)포워딩
	}
	
	// 글쓰기 화면
	@GetMapping("/board/write.do")
	public String write() {
		
		return "board/write";
	}
	
	
	// 새글 저장
	@PostMapping("board/insert.do")						      // 파일 업로드
	public String insert(BoardVO vo, Model model, @RequestParam MultipartFile filename,
			HttpServletRequest req) {
		// 첨부파일 처리
			// 비어있지않아야함
		if (!filename.isEmpty()) {
			// 파일 구하기(서버저장명)
			String org = filename.getOriginalFilename(); // 사용자가 첨부한 첨부파일명
			String ext = org.substring(org.lastIndexOf(".")); // 확장자
			String real = new Date().getTime()+ext; // 서버저장실제파일명
			
			// 파일저장
			String path = req.getRealPath("/upload/");
			try {
				filename.transferTo(new File(path+real));
			} catch (Exception e) {}
			
			vo.setFilename_org(org);
			vo.setFilename_real(real);
		}
		// member_no 저장
		HttpSession sess = req.getSession();
		MemberVO mv = (MemberVO)sess.getAttribute("loginInfo");
		vo.setMember_no(mv.getNo()); //mv안에 no만 
		
		if (service.insert(vo)){
			model.addAttribute("msg", "정상적으로 저장되었습니다.");
			model.addAttribute("url", "index.do");
			return "common/alert"; // alert 띄우는 jsp파일 // redirect:index.do
		} else {
			model.addAttribute("msg", "저장을 실패했습니다.");
			return "common/alert"; 
		}		
	}
	
	// 리스트 클릭시 글보임
	@GetMapping("board/view.do")
	public String view(BoardVO vo, Model model) {
		BoardVO data = service.view(vo.getNo());
		model.addAttribute("data", data); //댓글
		return "board/view";
	}
	
	// 수정
	@GetMapping("board/edit.do")
	public String edit(BoardVO vo, Model model) {
		BoardVO data = service.edit(vo.getNo());
		model.addAttribute("data", data);
		
		return "board/edit";
	}
	
	// 업데이트
	@PostMapping("/board/update.do")
	public String update(BoardVO vo, Model model) {
		if(service.update(vo)) {
			model.addAttribute("msg", "정상적으로 수정되었습니다.");
			model.addAttribute("url", "view.do?no="+vo.getNo());
			return "common/alert"; 
		} else {
			model.addAttribute("msg", "수정을 실패하였습니다.");
			return "common/alert"; 
		}
	}
	
	//삭제
	@GetMapping("/board/delete.do")
	public String delete(BoardVO vo, Model model) {
		if(service.delete(vo.getNo())) {
			model.addAttribute("msg", "정상적으로 삭제되었습니다.");
			model.addAttribute("url", "index.do");
			return "common/alert"; 
		} else {
			model.addAttribute("msg", "삭제를 실패하였습니다.");
			return "common/alert"; 
		}
	}
	
	
	
}
