package com.tuyano.springboot;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tuyano.springboot.repositories.MsgDataRepository_6_1;

@Controller
public class MsgDataController_6_6 {

	@Autowired
	MsgDataRepository_6_1 repository;
	
	@PersistenceContext
	EntityManager entityManager;
	
	MsgDataDaoImpl_6_1 dao;
	
	@RequestMapping(value= "/msg", method = RequestMethod.GET)
	public ModelAndView msg(ModelAndView mav) {
		mav.setViewName("showMsgData_32");
		mav.addObject("title","Sample");
		mav.addObject("msg", "MsgData의 예제입니다.");
		MsgData_6_1 msgdata = new MsgData_6_1();
		mav.addObject("formModel",msgdata);
		List <MsgData_6_1> list = (List<MsgData_6_1>)dao.getAll();
		mav.addObject("datalist",list);
		return mav;
		
	}
	@RequestMapping(value = "/msg", method = RequestMethod.POST)
	public ModelAndView msgform(@Valid @ModelAttribute MsgData_6_1 msgdata, Errors result, ModelAndView mav) {
		if(result.hasErrors()) {
			mav.setViewName("showMsgData_32");
			mav.addObject("title","Sample [ERROR]");
			mav.addObject("msg", "값을 다시 확인해주세요~");
			return mav;
		}else {
			repository.save(msgdata);
			return new ModelAndView("redirect:/msg");
		}
		
	}
	
@PostConstruct
public void init() {
	System.out.println("ok");
	dao = new MsgDataDaoImpl_6_1(entityManager);
}
	
}
