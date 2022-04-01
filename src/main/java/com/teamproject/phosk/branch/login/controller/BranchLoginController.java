package com.teamproject.phosk.branch.login.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.teamproject.phosk.branch.info.vo.BranchInfoVO;
import com.teamproject.phosk.branch.login.service.BranchLoginService;
import com.teamproject.phosk.branch.login.vo.BranchLoginVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/branch/login/*")
@AllArgsConstructor
public class BranchLoginController {
	
	private BranchLoginService service;
	
	@GetMapping("/index")
	public void branchLoginIndex() {
		log.info("branchLoginIndex 호출");
	}
	
	@PostMapping("/result")
	public String branchLoginResult(BranchLoginVO blvo , HttpSession session ,RedirectAttributes rttr) {
		log.info("branchLoginResult 호출");
		BranchLoginVO loginCheckResult = service.branchLoginSelect(blvo.getOner_id() , blvo.getOner_pwd());
		if(loginCheckResult != null) {
			session.setAttribute("loginInfo", loginCheckResult);
			return "redirect:/branch/login/choiceBranch";
		}else {
			rttr.addFlashAttribute("errCode" , 1);
			return "redirect:/branch/login/index";
		}
	}
	
	@GetMapping("/choiceBranch")
	public void branchchoiceBranch(HttpServletRequest request, HttpSession session, Model model) {
		log.info("branchChoiceBranch 호출");
		BranchLoginVO vo =  (BranchLoginVO)session.getAttribute("loginInfo");
		List<BranchInfoVO> bivo = service.branchChoiceBranch(vo.getOner_id());
		model.addAttribute("info" , bivo);
		System.out.println(vo + " 세션확인.");
	}
}
