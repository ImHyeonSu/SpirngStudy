//package com.tuyano.springboot;
//
//
//import javax.annotation.PostConstruct;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.tuyano.springboot.repositories.MyDataRepository_4;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
//
//
//@Controller
//public class HeloController_5_6 {
//
//	@Autowired //@Autowired - 컨트롤러 측에서 애플리케이션에 있는 Bean 객채(스프링 mvc에 의해 자동으로 인스턴스가 생성되서 애플리케이션 내에서 사용할 수 있게 된 것)와 연동하기 위한 것 - 이것을 통해 리포지터리 인스턴스가 자동으로 리포지토리 필드로 설정됨
//	MyDataRepository_4 repository; //리포지터리는 인터페이스이지만 인스턴스가 제대로 설정된다, 그 이유는 스프링 mvc에 의해 인터페이스에 필요한 처리를 탑재한 무명클래스가 만들어지면 이 클래스의 인스턴스가 생성되는 것
//	//스프링 프레임워크에선 미리 클래스를 Bean으로 등로갷두고 해당 Bean을 인스턴스 필드에 자동으로 연동해서 사용할 수 있게 만든다.
//	//정리하면 애플리케이션 실행시 @Repository가 붙은 인터페이스를 검색해서 자동으로 클래스를 만들고, 해당 인스턴스를 애플리케이션에 Bean으로 등록
//	//이후 컨트롤러 등의 클래스가 로드될 때 @Autowired가 설정된 필드가 있으면 등록 완료된 Bean에서 동일 클래스를 검색해서 자동으로 해당 필드에 할당.
//	
//	
//	@RequestMapping(value = "/" , method = RequestMethod.GET) //엔터티 클래스(myadata_5_2)의 인스턴스를 자동으러 적용할 때 사용된다. 인수에는 인스턴스의이름을 지정한다. >> 이것은 th:object로 지정하는 값
//	public ModelAndView index(@ModelAttribute("formModel") MyData_5_2 mydata, ModelAndView mav) {
//		mav.setViewName("index_29");
//		mav.addObject("msg", "this is sample content.");
//		mav.addObject("formModel",mydata);
//		Iterable<MyData_5_2> list = repository.findAll(); // findAll을 통해 모든 엔터티가 자동으로 추출된다. 또한 제네릭설정으로 대상 엔터티 클래스는 MyData_5_1이고 메인 키가 Long 형으로 지정된다
//		mav.addObject("datalist",list);
//		return mav;
//	}
//	@RequestMapping(value = "/", method = RequestMethod.POST)
//	@Transactional(readOnly=false) //트랜잭션기능을 위한 애너테이션, 트랜잭션은 데이터베이스의 일련의 처리를 일괄적으로 실행하기 위한 구조인데, 이 애너테이션을 사용하면서 메서드 내에서 실행되는 테이터베이스 처리가 일괄실행됨./ 또한 readonly는 읽기전용
//	public ModelAndView form(@ModelAttribute("formModel")@Validated MyData_5_2 mydata, BindingResult result, ModelAndView mov) {
//		ModelAndView res = null;	//@Validated는 유효성 검증을 하는것, 이 에너테이션을 통해 유효성 자동으로 검증, 이후 BindingResult를 통해 결과 값이 반환된다. 이후 에러체크
//		if(!result.hasErrors()) {
//			repository.saveAndFlush(mydata);
//			res = new ModelAndView("redirect://");
//		}else {
//		mov.setViewName("index_29");
//		mov.addObject("msg", "sorry, error is ouuured...");
//		Iterable<MyData_5_2> list = repository.findAll();
//		mov.addObject("datalist", list);
//		res = mov;
//			}
//		return res;
//	}
//	@PostConstruct
//	public void init() {
//		MyData_5_2 d1 = new MyData_5_2();
//		d1.setName("kim");
//		d1.setAge(123);
//		d1.setMail("kim@gilbut.co.kr");
//		d1.setMemo("090999999");
//		repository.saveAndFlush(d1);
//		MyData_5_2 d2 = new MyData_5_2();
//		d2.setName("lee");
//		d2.setAge(15);
//		d2.setMail("lee@flower");
//		d2.setMemo("080888888");
//		repository.saveAndFlush(d2);
//		MyData_5_2 d3 = new MyData_5_2();
//		d3.setName("choi");
//		d3.setAge(37);
//		d3.setMail("choi@happy");
//		d3.setMemo("070777777");
//		repository.saveAndFlush(d3);
//	}
//	
//}
