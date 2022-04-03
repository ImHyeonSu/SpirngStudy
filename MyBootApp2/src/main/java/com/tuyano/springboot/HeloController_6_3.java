//package com.tuyano.springboot;
//
//
//import javax.annotation.PostConstruct;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
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
//import javax.servlet.http.HttpServletRequest;
//import java.util.List;
//
//@Controller
//public class HeloController_6_3 {
//
//	@Autowired 					   //@Autowired - 컨트롤러 측에서 애플리케이션에 있는 Bean 객채(스프링 mvc에 의해 자동으로 인스턴스가 생성되서 애플리케이션 내에서 사용할 수 있게 된 것)와 연동하기 위한 것 - 이것을 통해 리포지터리 인스턴스가 자동으로 리포지토리 필드로 설정됨
//	MyDataRepository_4 repository; //리포지터리는 인터페이스이지만 인스턴스가 제대로 설정된다, 그 이유는 스프링 mvc에 의해 인터페이스에 필요한 처리를 탑재한 무명클래스가 만들어지면 이 클래스의 인스턴스가 생성되는 것
//								   //스프링 프레임워크에선 미리 클래스를 Bean으로 등로갷두고 해당 Bean을 인스턴스 필드에 자동으로 연동해서 사용할 수 있게 만든다.
//								   //정리하면 애플리케이션 실행시 @Repository가 붙은 인터페이스를 검색해서 자동으로 클래스를 만들고, 해당 인스턴스를 애플리케이션에 Bean으로 등록
//								   //이후 컨트롤러 등의 클래스가 로드될 때 @Autowired가 설정된 필드가 있으면 등록 완료된 Bean에서 동일 클래스를 검색해서 자동으로 해당 필드에 할당.
//	@PersistenceContext
//	EntityManager entityManager; // Entitymager 사용시 기본적으로 @persistenceContext를 사용해야한다. 또한 기본적으로 PersistenceContext는 애플리케이션별로 하나만 설정가능 그렇기때문에 MyDataDaoimpl클래스에서 선언해줘도 된다.그럴려면 controller부분에서 Persistencecontext를빼줘야한다.
//	
//	MyDataDaoImpl_6_6 dao;
//	
//	@RequestMapping(value = "/" , method = RequestMethod.GET)
//	public ModelAndView find(ModelAndView mav) {
//		mav.setViewName("find_31");
//		mav.addObject("title", "Find Page");
//		mav.addObject("msg", "MyData의 예제입니다.");
//		mav.addObject("value","");
//		Iterable<MyData_5_3> list = dao.findByAge(10, 40);//dao.getAll();repository.findAllOrderByName();
//		mav.addObject("datalist",list);
//		return mav;
//	}
//	
////	@RequestMapping(value = "/find", method = RequestMethod.POST)
////	public ModelAndView search(HttpServletRequest request, ModelAndView mav) { //HttpServletRequest라는 것은 JSP 서블릿에서 사용되는 HttpServletRequest와 같은 것이다.
////		mav.setViewName("find_31");											   //서블릿에서 doGet,doPost를 할 때 반드시 필요한 기능이다.		
////		String param = request.getParameter("fstr");						   //서블릿에서 자주사용되는 객체도 스프링부트서 이용가능 또한 이전에 사용했던@requestParam같은 경우도 HttpServletRequest-getParameter를 홏룰해서 자동으로 피라미터를 받고 그결과를 인수로 설정하는 것이다.	
////		if(param == "") {
////			mav = new ModelAndView("redirect:/find");
////		}else {
////			mav.addObject("title","Find result");
////			mav.addObject("msg"," " + param + "의 검색결과");
////			mav.addObject("value",param);
////			List<MyData_5_3> list = dao.find(param);
////			mav.addObject("datalist", list);
////		}
////		return mav;
////	}
//
//	@PostConstruct
//	public void init() {
//		dao = new MyDataDaoImpl_6_6(entityManager);
//		MyData_5_3 d1 = new MyData_5_3();
//		d1.setName("kim");
//		d1.setAge(123);
//		d1.setMail("kim@gilbut.co.kr");
//		d1.setMemo("090999999");
//		repository.save(d1);
//		MyData_5_3 d2 = new MyData_5_3();
//		d2.setName("lee");
//		d2.setAge(15);
//		d2.setMail("lee@flower");
//		d2.setMemo("080888888");
//		repository.save(d2);
//		MyData_5_3 d3 = new MyData_5_3();
//		d3.setName("choi");
//		d3.setAge(37);
//		d3.setMail("choi@happy");
//		d3.setMemo("070777777");
//		repository.save(d3);
//	}
//	
//}
