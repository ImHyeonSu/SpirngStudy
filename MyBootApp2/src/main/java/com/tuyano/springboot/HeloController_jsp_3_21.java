//package com.tuyano.springboot;
//
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//@RestController 
//public class HeloController_jsp_3_21 {
//	@RequestMapping(value="/", method=RequestMethod.GET) //리퀘스트 매핑은 서버의 URL과 특정 처리를 연동시키는 구조, 매서드를 생성해 리퀘스트 매핑으로 선언해둔 후 서버로 해당 URL요청이 온경우 매서드가 자동으로 실행된다.
//						 // 여기선 URL/ 에 접속히 index 메서드가 실행된다.
//	public ModelAndView index(ModelAndView mav) {
//		mav.setViewName("index_22");
//		mav.addObject("val", "please type...");
//		return mav;
//	}
//	@RequestMapping(value="/", method=RequestMethod.POST)
//	public ModelAndView send(@RequestParam String text1, ModelAndView mav) {
//	mav.setViewName("index_22");
//	mav.addObject("val", "you typed : '" + text1 + "'.");
//	return mav;
//	}
//	
//}
