package com.tuyano.springboot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity //@Entity  - 엔티티클래스에서 반드시 선언해야하는 애너테이션
@Table(name="mydata") //@Table(~~) - 엔터티 클래스에 할당되는 테이블을 지정한다. 생략해도 상관없으며 그때는 클래스명이 테이블명으로 사용된다.
public class MyData_5_1 {

	@Id //@Id - 메인 키를 지정한다 - 엔터티 클래스정의시 반드시 필요
	@GeneratedValue(strategy = GenerationType.AUTO) //@GeneratedValue - 메인 키의 필드에 설정돼 있다. 이것은 값을 자동 생성하는 역할을 한다.strategy에 생성방법을 지정한다. GenerationType이라는 열거형 값을 설정하며 여기선 AUTO를 사용하고 있다. - 자동할당 값 방식
	@Column //@Column - 해당필드에 할당한 칼럼을 지정하며 생략할 수 있다. 생략한 겨웅에는 필드명이 그대로 칼럼명으로 사용된다./ Column(name - 칼럼명 지정,length - 최대 길이 지정,nullabe - 널 허용여부)
	private long id;
	
	
	@Column(length = 50, nullable = false)
	private String name;
	
	@Column(length = 200, nullable = true)
	private String mail;
	
	@Column(nullable = true)
	private Integer age;
	
	@Column(nullable = true)
	private String memo;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail=mail;
	}
	
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age=age;
	}
	
	
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo=memo;
	}
}
