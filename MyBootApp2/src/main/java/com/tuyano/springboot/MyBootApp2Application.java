package com.tuyano.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 스프링 부트의 애플리케이션 클래스라는 것을 나타낸다
public class MyBootApp2Application {

	public static void main(String[] args) {
		SpringApplication.run(MyBootApp2Application.class, args); // 이클래스를 그대로 실행한다는 뜻이다
	}

}
