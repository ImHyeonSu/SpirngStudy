//package com.tuyano.springboot;
//
//import javax.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;
//import com.tuyano.springboot.repositories.MyDataRepository_2;
//
//
//
//
//@Controller
//public class DeleteController_5_4 {
//
//	@Autowired //@Autowired - 컨트롤러 측에서 애플리케이션에 있는 Bean 객채(스프링 mvc에 의해 자동으로 인스턴스가 생성되서 애플리케이션 내에서 사용할 수 있게 된 것)와 연동하기 위한 것 - 이것을 통해 리포지터리 인스턴스가 자동으로 리포지토리 필드로 설정됨
//	MyDataRepository_2 repository; //리포지터리는 인터페이스이지만 인스턴스가 제대로 설정된다, 그 이유는 스프링 mvc에 의해 인터페이스에 필요한 처리를 탑재한 무명클래스가 만들어지면 이 클래스의 인스턴스가 생성되는 것
//	//스프링 프레임워크에선 미리 클래스를 Bean으로 등로갷두고 해당 Bean을 인스턴스 필드에 자동으로 연동해서 사용할 수 있게 만든다.
//	//정리하면 애플리케이션 실행시 @Repository가 붙은 인터페이스를 검색해서 자동으로 클래스를 만들고, 해당 인스턴스를 애플리케이션에 Bean으로 등록
//	//이후 컨트롤러 등의 클래스가 로드될 때 @Autowired가 설정된 필드가 있으면 등록 완료된 Bean에서 동일 클래스를 검색해서 자동으로 해당 필드에 할당.		
//	@RequestMapping(value = "/edit/{id}" , method = RequestMethod.GET) //엔터티 클래스(myadata_5_1)의 인스턴스를 자동으러 적용할 때 사용된다. 인수에는 인스턴스의이름을 지정한다. >> 이것은 th:object로 지정하는 값
//	public ModelAndView edit(@ModelAttribute("formModel") MyData_5_1 mydata, @PathVariable int id, ModelAndView mav) {
//		//edit/1 ~3에 접속시 id를 받아서 id에 따른 엔터티 검색 그리고 가져온 엔터티를 formModel에 설정하고 있다. 이후 updata 메서드가 호출되며, 이후 전송된 폼의 데이터를 사용해 데이터를 변경 하는 것
//		mav.setViewName("edit_25");
//		mav.addObject("title", "edit mydata");		
//		MyData_5_1 data = repository.findById((long)id); 
//		mav.addObject("formModel",data);
//		return mav;
//	}
//	@RequestMapping(value = "/edit", method = RequestMethod.POST)
//	@Transactional(readOnly=false) //트랜잭션기능을 위한 애너테이션, 트랜잭션은 데이터베이스의 일련의 처리를 일괄적으로 실행하기 위한 구조인데, 이 애너테이션을 사용하면서 메서드 내에서 실행되는 테이터베이스 처리가 일괄실행됨./ 또한 readonly는 읽기전용
//	public ModelAndView update(@ModelAttribute("formModel") MyData_5_1 mydata, ModelAndView mav) {
//		repository.saveAndFlush(mydata); //saveAndFlush라는 메서드는 인수로 지정한 엔터티를 영구화한다. edit_25.html에서 formModeldml ID를 숨김 필드에 저장했었다. 그냥 한마디로 단순히 엔터티를 저장하면 상황에 맞게 신규로 저장해주거나 기존 데이터를 변경해주는 것
//		return new ModelAndView("redirect:/");
//	}
//	
//	
//	@RequestMapping(value = "/delete/{id}" , method = RequestMethod.GET) //엔터티 클래스(myadata_5_1)의 인스턴스를 자동으러 적용할 때 사용된다. 인수에는 인스턴스의이름을 지정한다. >> 이것은 th:object로 지정하는 값
//	public ModelAndView delete(@PathVariable int id, ModelAndView mav) {
//		//edit/1 ~3에 접속시 id를 받아서 id에 따른 엔터티 검색 그리고 가져온 엔터티를 formModel에 설정하고 있다. 이후 updata 메서드가 호출되며, 이후 전송된 폼의 데이터를 사용해 데이터를 변경 하는 것
//		mav.setViewName("delete_26");
//		mav.addObject("title", "delete mydata");		
//		MyData_5_1 data = repository.findById((long)id); // findAll을 통해 모든 엔터티가 자동으로 추출된다. 또한 제네릭설정으로 대상 엔터티 클래스는 MyData_5_1이고 메인 키가 Long 형으로 지정된다
//		mav.addObject("formModel",data);
//		return mav;
//	}
//	@RequestMapping(value = "/delete", method = RequestMethod.POST)
//	@Transactional(readOnly=false) //트랜잭션기능을 위한 애너테이션, 트랜잭션은 데이터베이스의 일련의 처리를 일괄적으로 실행하기 위한 구조인데, 이 애너테이션을 사용하면서 메서드 내에서 실행되는 테이터베이스 처리가 일괄실행됨./ 또한 readonly는 읽기전용
//	public ModelAndView remove(@RequestParam long id, ModelAndView mav) {
//		repository.delete(id); // 삭제처리를 하는 부분 delete메서드는 인수로 전달된 ID의 엔터티를 삭제한다. 데이터베이스 변경을 동반하므로 @Transaction 애너테이션 지정하는 것이 좋다.
//		return new ModelAndView("redirect:/");
//	}
//
//@PostConstruct
//public void init() {
//	MyData_5_1 d1 = new MyData_5_1();
//	d1.setName("kim");
//	d1.setAge(123);
//	d1.setMail("kim@gilbut.co.kr");
//	d1.setMemo("this is my data!");
//	repository.saveAndFlush(d1);
//	MyData_5_1 d2 = new MyData_5_1();
//	d2.setName("lee");
//	d2.setAge(15);
//	d2.setMail("lee@flower");
//	d2.setMemo("my girl friend");
//	repository.saveAndFlush(d2);
//	MyData_5_1 d3 = new MyData_5_1();
//	d3.setName("choi");
//	d3.setAge(37);
//	d3.setMail("choi@happy");
//	d3.setMemo("my work friend");
//	repository.saveAndFlush(d3);
//}
//}