//package com.tuyano.springboot;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//
//@Controller
//public class HeloController_what_3_12 {
//	@RequestMapping("/{id}")
//	public ModelAndView index(@PathVariable int id, ModelAndView mav) {
//		mav.setViewName("index_13");
//		mav.addObject("id",id);
//		mav.addObject("check", id % 2 == 0);
//		mav.addObject("trueVal", "Even number!");
//		mav.addObject("falseVal","Odd number...");
//		return mav;
//	}
//}
