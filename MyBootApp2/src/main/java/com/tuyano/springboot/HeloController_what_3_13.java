//package com.tuyano.springboot;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//
//@Controller
//public class HeloController_what_3_13 {
//	@RequestMapping("/{id}")
//	public ModelAndView index(@PathVariable int id, ModelAndView mav) {
//		mav.setViewName("index_14");
//		mav.addObject("id",id);
//		mav.addObject("check", id >= 0);
//		mav.addObject("trueVal", "맞슴다");
//		mav.addObject("falseVal","아니에요");
//		return mav;
//	}
//}
