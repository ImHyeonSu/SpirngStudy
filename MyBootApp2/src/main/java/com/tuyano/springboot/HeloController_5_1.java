//package com.tuyano.springboot;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.tuyano.springboot.repositories.MyDataRepository;
//
//
//@Controller
//public class HeloController_5_1 {
//
//	@Autowired //@Autowired - 컨트롤러 측에서 애플리케이션에 있는 Bean 객채(스프링 mvc에 의해 자동으로 인스턴스가 생성되서 애플리케이션 내에서 사용할 수 있게 된 것)와 연동하기 위한 것 - 이것을 통해 리포지터리 인스턴스가 자동으로 리포지토리 필드로 설정됨
//	MyDataRepository repository; //리포지터리는 인터페이스이지만 인스턴스가 제대로 설정된다, 그 이유는 스프링 mvc에 의해 인터페이스에 필요한 처리를 탑재한 무명클래스가 만들어지면 이 클래스의 인스턴스가 생성되는 것
//	//스프링 프레임워크에선 미리 클래스를 Bean으로 등로갷두고 해당 Bean을 인스턴스 필드에 자동으로 연동해서 사용할 수 있게 만든다.
//	//정리하면 애플리케이션 실행시 @Repository가 붙은 인터페이스를 검색해서 자동으로 클래스를 만들고, 해당 인스턴스를 애플리케이션에 Bean으로 등록
//	//이후 컨트롤러 등의 클래스가 로드될 때 @Autowired가 설정된 필드가 있으면 등록 완료된 Bean에서 동일 클래스를 검색해서 자동으로 해당 필드에 할당.
//	
//	
//	@RequestMapping("/")
//	public ModelAndView index(ModelAndView mav) {
//		mav.setViewName("index_23");
//		Iterable<MyData_5_1> list = repository.findAll(); // findAll을 통해 모든 엔터티가 자동으로 추출된다. 또한 제네릭설정으로 대상 엔터티 클래스는 MyData_5_1이고 메인 키가 Long 형으로 지정된다
//		mav.addObject("data",list);
//		return mav;
//	}
//}
