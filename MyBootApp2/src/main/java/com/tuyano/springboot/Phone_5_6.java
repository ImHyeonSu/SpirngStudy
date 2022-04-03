//package com.tuyano.springboot;
//
//import java.lang.annotation.Documented;
//import java.lang.annotation.ElementType;
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
//import java.lang.annotation.Target;
//
//import javax.validation.Constraint;
//import javax.validation.Payload;
//import javax.validation.ReportAsSingleViolation;
//
//@Documented
//@Constraint(validatedBy = PhoneValidator_5_6.class)
//@Target({ElementType.METHOD, ElementType.FIELD})
//@Retention(RetentionPolicy.RUNTIME)
//@ReportAsSingleViolation
//
//// >> 위 애너테이션 전부 유효성 검사기에서는 필수
//public @interface Phone_5_6 {
//
//		String message() default "please input a phone number."; // 오류시에 전송하는 메시지
//		Class<?>[] groups() default {};
//		Class<? extends Payload>[] payload() default {};
//}
