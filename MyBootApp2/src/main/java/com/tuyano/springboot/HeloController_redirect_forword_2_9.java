//package com.tuyano.springboot;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//public class HeloController_redirect_forword_2_9 {
//
//	
//	@RequestMapping("/")
//	public ModelAndView index(ModelAndView mav) {
//		mav.setViewName("index");
//		return mav;
//	}
//	@RequestMapping("/other")
//	public String other() {
//		return "redirect:/"; //리다이렉트는 클라이언트 측에 전송한 후에 다른 페이지로 이동시키는 것이다. 따라서 접속하는 주소와 이동위치 모두 변경된다.
//	}
//	@RequestMapping("/home")
//	public String home() {
//		return "forward:/";//서버내부에서 다른 페이지를 읽어 표시하는 것, 접속하는 주소는 그대로이고 표시내용만 다른페이지로 바뀐다.
//	}
//}
