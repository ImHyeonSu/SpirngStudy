package com.h2yn.springboot.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import org.springframework.web.bind.annotation.RequestParam;
import com.h2yn.springboot.todo.data.MyData;
import com.h2yn.springboot.todo.repository.MyDataRepository;
import com.h2yn.springboot.todo.dao.MyDataDaoImpl;


@Controller
//@tran
public class TodoController {
	
	@Autowired
	MyDataRepository repository;
	
	@PersistenceContext
	EntityManager entityManager;
	
	MyDataDaoImpl dao;
	
	@GetMapping
	public ModelAndView dataHyousi(ModelAndView mav) {
		mav.setViewName("index_1");
		Iterable<MyData> list = dao.getAll();
		mav.addObject("datalist",list);
		return mav;
	}
	
//	@PostMapping("/edit")
//	public ModelAndView dataEdit(ModelAndView mav) {
//		mav.setViewName("index_2");
//		
//		return mav;
//	}
	
	@GetMapping("/edit")
	public ModelAndView dataEdit(@ModelAttribute("formModel")MyData myadata,ModelAndView mav) {
		mav.setViewName("index_2");
		mav.addObject("msg","これはサンプルです。");
		Iterable<MyData> list = repository.findAll();
		mav.addObject("datalist", list);
		return mav;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView dataEdit_Id(@ModelAttribute("formModel")MyData myadata,@PathVariable int id,ModelAndView mav) {
		mav.setViewName("index_3");
		mav.addObject("title","編集してください。");
		MyData data = repository.findById((long)id);
		mav.addObject("formModel", data);
		return mav;
	}
	
	@PostMapping("/edit")
	@Transactional(readOnly=false)
	public ModelAndView dataEditForm(@ModelAttribute("formModel")MyData mydata,ModelAndView mav) {
		repository.saveAndFlush(mydata);
		return new ModelAndView("redirect:/");
	}
	
	
	@GetMapping("/delete/{id}")
	public ModelAndView dataDelete(@PathVariable int id, ModelAndView mav) {
		mav.setViewName("index_4");
		mav.addObject("title","削除ページです。");
		MyData data = repository.findById((long)id);
		mav.addObject("formModel", data);
		return mav;
	}
	
	@PostMapping("/delete")
	@Transactional(readOnly=false)
	public ModelAndView dataDeleteForm(@RequestParam long id, ModelAndView mav) {
		repository.delete(id);
		return new ModelAndView("redirect:/edit");
	}
	
	
	
	
	@GetMapping("/find")
	public ModelAndView dataFind(ModelAndView mav) {
		mav.setViewName("index_5");
		mav.addObject("title", "検索専用");
		mav.addObject("msg", "検索してください");
		mav.addObject("value","");
		Iterable<MyData> list = dao.getAll();
		mav.addObject("datalist",list);
		return mav;
	}
	
	@PostMapping("/find")
	public ModelAndView dataKeltuka(HttpServletRequest request ,ModelAndView mav) {
		mav.setViewName("index_5");
		String param = request.getParameter("fstr");
		if(param == "") {
			mav = new ModelAndView("redirect:/find");
		}else {
			mav.addObject("title", "検索の結果");
			mav.addObject("msg", param + "のquery結果が出ました。");
			mav.addObject("value",param);
			List<MyData> list = dao.find(param);
			mav.addObject("datalist", list);
		}
		return mav;
	}
	
	
	@PostConstruct
	public void init() {
		dao = new MyDataDaoImpl(entityManager);
		MyData d1 = new MyData();
		d1.setName("kim");
		d1.setAge(123);
		d1.setMail("kim@gilbut.co.kr");
		d1.setMemo("090999999");
		repository.saveAndFlush(d1);
		MyData d2 = new MyData();
		d2.setName("lee");
		d2.setAge(15);
		d2.setMail("lee@flower");
		d2.setMemo("080888888");
		repository.saveAndFlush(d2);
		MyData d3 = new MyData();
		d3.setName("choi");
		d3.setAge(37);
		d3.setMail("choi@happy");
		d3.setMemo("070777777");
		repository.saveAndFlush(d3);
	}

}
