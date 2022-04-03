//package com.tuyano.springboot;
//
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//import java.util.ArrayList;
//
//@RestController
//public class HeloController_each_3_15 {
//	
//	@RequestMapping("/")
//	public ModelAndView index(ModelAndView mav) {
//		mav.setViewName("index_16");
//		ArrayList<String[]> data = new ArrayList<String[]>();
//		data.add(new String[]{"park","park@yamada","000-111-222"});
//		data.add(new String[]{"lee", "lee@flower", "000-333-444"});
//		data.add(new String[]{"choi","choi@happy","000-555-666"});
//		mav.addObject("data",data);
//		return mav;
//	}
//	
//}
