//package com.tuyano.springboot;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//
//@Controller
//public class HeloController__templet_2_8 {
//
//	@RequestMapping(value="/", method=RequestMethod.GET)
//	public ModelAndView index(ModelAndView mav) {
//		mav.setViewName("index_4");
//		mav.addObject("msg", "폼을 전송해주세요.");
//		return mav;
//	}
//	
//	@RequestMapping(value="/", method=RequestMethod.POST)
//	public ModelAndView send(@RequestParam(value="check1", required=false)boolean check1, 
//							 @RequestParam(value="radio1",required=false)String radio1, 
//							 @RequestParam(value="select1",required=false)String select1, 
//							 @RequestParam(value="select2",required=false)String[] select2, ModelAndView mav) {
//		//여기서 required 같은경우는 이 값이 필수항목인지 아닌지를 체크해서 false인 경우에는 선택을 하지않아도 처리가 지속되도록해준다.
//
//		String res = "";
//		try {
//			res = "check:"+ check1 + "radio:" + radio1 + "select:" + select1 + "\nselect2:";}
//		catch(NullPointerException e) {}
//		try {
//			res += select2[0];
//			for(int i = 1; i<select2.length; i++)
//				res += "," +select2[i];
//		}catch(NullPointerException e) {
//			res += "null";
//		}
//		mav.addObject("msg",res);
//		mav.setViewName("index_4");
//		return mav;
//	}
//}
