//package com.tuyano.springboot;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//public class HeloController__templet_2_5 {
//
//	@RequestMapping("/{num}")
//	public String index(@PathVariable int num, Model model) {//Model model >> ModelAndView mav
//		int res = 0;
//		for(int i=1; i<=num;i++)
//			res+=i;
//		model.addAttribute("msg", "total: " +res);
//
//		return "index_2"; // index.html을 읽어서 그걸 그대로 표현함
//						  // Model.addAttribute
//	}
//}
