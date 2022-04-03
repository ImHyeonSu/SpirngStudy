//package com.tuyano.springboot;
//
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.PathVariable;
//
//@RestController
//public class HeloController_RestController_1_2 {
//	@RequestMapping("/{num}") //url에 숫자 num을 집어넣으면
//	public String index(@PathVariable int num) { //여기서 @pathvariable의 숫자를 매개변수로 사용하겠다는 선언으로써 숫자값을 받아와서 밑의 코드들이 실행된다.
//		int res = 0;
//		for(int i = 1; i<=num; i++)
//			res+=i;
//		return "total:" + res;	
//		
//	}
//}
