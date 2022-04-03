package com.tuyano.springboot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;
//@Null,NotNull - 값이 null인지 null이 아닌지를 체크한다, String 에다가 공백으로 전송시 값이 null이 아닌 것에 주의
//@Min,Max - 정수에 대한 최솟값과 최댓값을 지정한다.
//@DecimalMin,@DecimalMax - BigDecimal,BigInteger과 String값의 숫자에도 설정가능한 최소 최대값
//@Digits - 숫자를 검증하는 것, 정수부분과 소소부분의 자릿수 제한을 검증하는 것,>>@Digits(integer=5, fraction=10) 이런식으로 자릿수를 체킹
//@Future,@Past - 시간과날짜 관련 객체에 사용한다. 구체적으로는 Data,Calendar및 해당 서버클래스등을 위해 사용된ㄷ. 
//@Size - 문자열 외에 배열, 컬렉션등 값을 모아서 저장하는 객체에 사용, 객체에 저장되는 요소 수를 검증하는 것, 요소수라고하면 String을 예로 들시 문자 수 >@Size(min=1, max=10)
//@Pattern - 이것은 String값의 항목에 사용하는 것이다. 정규표현식의 패턴을 지정해서 유효성을 검증한다.

//Hibernamte Validator를 이용한 애너테이션 -- 이는 javax.validation과 비슷한 org.hibernate.validator 패키지를 사용하는 것. >>@NotEmpty - Stirng 항목에서 값이 공백인지,Null 인지 확인한다.
//@Length - String 값에서 문자열 길이를 지정한다 >> @Length(min=5, max=10), @Range - 숫자항목에서 일정범위를 지정해서 사용하게할때 사용 >> @Range(min=5,max=10)
//@Email - 이메일 주소인지 확인하는것,, @CreditCardNumber - 숫자 및 String형식의 숫자 값에 사용된다. 입력된 값이 신용 카드 번호형식과 일치하는지를 확인한다.
//@EAN - String값의 항목에 사용된다. 바코드 식별번호 규격에 맞는지 확인한다.

@Entity //@Entity  - 엔티티클래스에서 반드시 선언해야하는 애너테이션
@Table(name="mydata") //@Table(~~) - 엔터티 클래스에 할당되는 테이블을 지정한다. 생략해도 상관없으며 그때는 클래스명이 테이블명으로 사용된다.
@NamedQueries(
{@NamedQuery(name="findWithName",query="from MyData_5_3 where name like :fname"),		// @NamedQuery(name=이름, query=쿼리문) 다수의 쿼리문을 사용할때는 @NamedQueries를 사용하면 된다. MyDataDaoImpl_6_5랑 연동된다.
@NamedQuery(name="findByAge", query="from MyData_5_3 where age > :min and age< :max")}
)
public class MyData_5_3 {
	
	@OneToMany(cascade=CascadeType.ALL)
	@Column(nullable = true)
	private List<MsgData_6_1> msgdatas;
	
	public List<MsgData_6_1> getMsgdatas(){
		return msgdatas;
	}
	public void setMsgdatas(List<MsgData_6_1> msgdatas) {
		this.msgdatas = msgdatas;
	}
	
	@Id //@Id - 메인 키를 지정한다 - 엔터티 클래스정의시 반드시 필요
	@GeneratedValue(strategy = GenerationType.AUTO) //@GeneratedValue - 메인 키의 필드에 설정돼 있다. 이것은 값을 자동 생성하는 역할을 한다.strategy에 생성방법을 지정한다. GenerationType이라는 열거형 값을 설정하며 여기선 AUTO를 사용하고 있다. - 자동할당 값 방식
	@Column //@Column - 해당필드에 할당한 칼럼을 지정하며 생략할 수 있다. 생략한 겨웅에는 필드명이 그대로 칼럼명으로 사용된다./ Column(name - 칼럼명 지정,length - 최대 길이 지정,nullabe - 널 허용여부)
	@NotNull //--
	private long id;
	
	
	@Column(length = 50, nullable = false)
	@NotEmpty //-- >> @NotEmpty(message="공백 불가")
	private String name;
	
	@Column(length = 200, nullable = true)
	@Email //-- >> @Email(message= "메일 주소만 ")
	private String mail;
	
	@Column(nullable = true)
	@Min(0) //-- >>@Min(value=0, message="0이상")
	@Max(200) //-- >> @Max(value=200, message="200이하 ")
	private Integer age;
	
	@Column(nullable = true)
	//@Phone_5_6 // 내가만든 유효성 검사기
	@Phone_5_6_2(onlyNumber=true)
	private String memo;
	
	// --를 붙인 것들은 값의 유효성 검증을 위한 설정값이다.

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
