//package com.tuyano.springboot;
//
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.bind.annotation.PathVariable;
//import java.util.ArrayList;
//
//@RestController
//public class HeloController_each_3_16 {
//	String[] names = {"Kim", "Lee", "park", "choi", "jo"};
//	String[] mails = {"Kim@tuuyano.com", "Lee@flower", "park@yamada", "choi@happy", "jo@baseball"};
//	
//	@RequestMapping("/{num}")
//	public ModelAndView index(@PathVariable int num, ModelAndView mav) {
//		mav.setViewName("index_17");
//		mav.addObject("num",num);
//		if( num >= 0) {
//			mav.addObject("check","num >= data.size() ? 0 : num");
//		}else {
//			mav.addObject("check","num <= data.size() * -1 ? 0 : num * -1");
//		}
//		
//		ArrayList<DataObject> data = new ArrayList<DataObject>();
//		data.add(new DataObject(0, "park","park@yamada"));
//		data.add(new DataObject(1, "lee", "lee@flower"));
//		data.add(new DataObject(2, "choi","choi@happy"));
//		mav.addObject("data",data);
//		return mav;
//	}
//	
//}
//class DataObject{
//		private int id;
//		private String name;
//		private String value;
//
//		public DataObject(int id, String name, String value) {
//			super();
//			this.id = id;
//			this.name = name;
//			this.value = value;
//	
//		}
//		public int getId() {return id;}
//		public void setId(int id) {this.id = id; }
//		public String getName() {return name;}
//		public void setName(String name) {
//			this.name = name;
//		}
//		public String getValue() {
//			return value;
//		}
//		public void setValue(String value) {
//			this.value = value;
//		}
//
//	}