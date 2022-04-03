package com.tuyano.springboot;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "msgdata")
public class MsgData_6_1 {

	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column
	@NotNull
	private long id;
	
	@Column
	private String title;
	
	@Column(nullable = false)
	@NotEmpty
	private String message;
	
	@ManyToOne
	private MyData_5_3 mydata;
	
	public MsgData_6_1() {
		super();
		mydata = new MyData_5_3();
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public MyData_5_3 getMydata_5_3() {
		return mydata;
	}
	
	public void setMydata(MyData_5_3 mydata) {
		this.mydata = mydata;
	}
	
}
