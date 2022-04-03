//package com.tuyano.springboot;
//
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//
//@RestController //컨트롤러 즉 전체처리를 제어하는 클래스라는 것을 명시하는 어노테이션, REST는 REpresentative State Transfer이며 분산 시스템을 위한 아키텍쳐이다.
//				// 네트워크를 경유해서 외부 서버에 접속하거나 필요한 정보를 불러오기 위한 구조 >> 즉 REST가 가능한 컨트롤러라는 annotation(주석) 을 표현하는 것!
//				// REST개념을 바탕으로 설계된 시스템을 RESTFul 이라고 한다. >> 이것을 사용하려면 RestController가 필요
//public class HeloController_RestController_1_1 {
//	@RequestMapping("/") //리퀘스트 매핑은 서버의 URL과 특정 처리를 연동시키는 구조, 매서드를 생성해 리퀘스트 매핑으로 선언해둔 후 서버로 해당 URL요청이 온경우 매서드가 자동으로 실행된다.
//						 // 여기선 URL/ 에 접속히 index 메서드가 실행된다.
//	public String index() {
//		return "Hello Spring-Boot World!!";
//	}
//}
