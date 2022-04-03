//package com.tuyano.springboot;                                                                                                                                                          
//                                                                                                                                                                                        
//import org.springframework.web.bind.annotation.RestController;                                                                                                                          
//import org.springframework.web.bind.annotation.RequestMapping;                                                                                                                          
//import org.springframework.web.servlet.ModelAndView;                                                                                                                                                                                                                                                          
//import java.util.ArrayList;                                                                                                                                                             
//                                                                                                                                                                                        
//@RestController                                                                                                                                                                         
//public class HeloController_inline_3_17 {                                                                                                                                                 
//	String[] names = {"Kim", "Lee", "park", "choi", "jo"};                                                                                                                              
//	String[] mails = {"Kim@tuuyano.com", "Lee@flower", "park@yamada", "choi@happy", "jo@baseball"};                                                                                     
//	                                                                                                                                                                                    
//	@RequestMapping("/")                                                                                                                                                           
//	public ModelAndView index(ModelAndView mav) {                                                                                                                
//		mav.setViewName("index_18");                                                                                                                                                    
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