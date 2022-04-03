//package com.tuyano.springboot;
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//
//
////Phone이 애너테이션 클래스 String이 설정값 >> String 값을 입력받아서 Phone애너테이션을 사용해 유효성 검증을 하는 것
//public class PhoneValidator_5_6 implements ConstraintValidator<Phone_5_6, String> {
//
//	@Override
//	public void initialize(Phone_5_6 phone) {
//		
//	} // 초기화메서드 애너테이션클래스가 인수로 설정된다.
//	@Override
//	public boolean isValid(String input, ConstraintValidatorContext cxt) {
//		if (input == null) {
//			return false;
//		}
//		return input.matches("[0-9()-]*");
//	}//실제 검증처리 구현부, 입력값(String)과 ConstraintValidatorContext 인스턴스가 전달된다. 이 메소드에서 값을 확인해서 정상일시 true 아니면 false를 반환한다. 
//	 //또한 matches("[0-9()-]*"); 는 정규표현식 패턴에 일치하는지를 환하는, 즉 유효성검사기를 만들때 자주사용한다.
//	
//}
//
////애너테이션의 유호성 검증처리는 유효성 검사기(validator)라는 클래스를 통해 확인한다. 유효성 검사기를 직접만들수도 있다.
////유효성 검사기를 만들기 위해선 애너테이션 클래스(java.lang.annotation.Annotation 의 서브클래스로서 인식됨)와 밸리데이터 클래스(javax.validation.ConstraintValidator 인터페이스를 구현해서 정의한다.
////initialize,isVaild)를 사용한다가 필요하다
