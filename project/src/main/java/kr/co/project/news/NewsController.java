package kr.co.project.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NewsController {
	
	@Autowired
	NewsService service;
	
	@GetMapping("/news/index.do")//modelAttrbuteboard
	public String index(Model model, NewsVO vo) {
		model.addAttribute("data", service.index(vo));
		return "news/index"; // (.jps)포워딩
	}
	
	// 글쓰기 화면
	@GetMapping("/news/write.do")
	public String write() {
		return "news/write";
	}
	
	
	// 새글 저장
	@PostMapping("/news/insert.do")
	public String insert(NewsVO vo, Model model) {
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
	@GetMapping("/news/view.do")
	public String view(NewsVO vo, Model model) {
		NewsVO data = service.view(vo.getNo());
		model.addAttribute("data", data);
		return "news/view";
	}
	
	// 수정
	@GetMapping("/news/edit.do")
	public String edit(NewsVO vo, Model model) {
		NewsVO data = service.edit(vo.getNo());
		model.addAttribute("data", data);
		
		return "news/edit";
	}
	
	// 업데이트
	@PostMapping("/news/update.do")
	public String update(NewsVO vo, Model model) {
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
	@GetMapping("/news/delete.do")
	public String delete(NewsVO vo, Model model) {
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
