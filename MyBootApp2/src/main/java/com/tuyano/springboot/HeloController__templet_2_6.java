//package com.tuyano.springboot;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//public class HeloController__templet_2_6 {
//
//	@RequestMapping("/{num}")
//	public ModelAndView index(@PathVariable int num, ModelAndView mav) {//Model model >> ModelAndView mav
//		int res = 0;
//		for(int i=1; i<=num;i++)
//			res+=i;
//		mav.addObject("msg", "total: " +res);
//		mav.setViewName("index_2");
//		return mav;  	//>>이렇게 ModelAndView와 Model 둘다를 사용할 수 있지만 템플릿 자체를 사용할 수 있는 것은 ModelAndView이다.  
//						//또한 setViewName없이 단순히 return하게 되면 템플릿을 찾지못하고 오류 발생
//	}
//}
