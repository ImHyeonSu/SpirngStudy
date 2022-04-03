package com.tuyano.springboot.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;

import com.tuyano.springboot.MyData_5_3;
import org.springframework.data.jpa.repository.JpaRepository; // 새로운 리포지터리 생성을 하기 위한 토대임
import org.springframework.stereotype.Repository;

//스프링 부트에선 데이터베이스 처리에 리포지터리를 사용하는 것이 일반적이지만 리포지터리가 되는 인터페이스에 쿼리애너테이션을 설정 할 수 있다. -- 이렇게 하는 이유는 쿼리를 만들어두고 계속해서 엔터티 클래스를 수정하는 것이 좋은 방법은 아니기때문.


@Repository
public interface MyDataRepository_4 extends JpaRepository<MyData_5_3, Long> {
	
	@Query("SELECT d FROM MyData_5_3 d ORDER BY d.name")
	List<MyData_5_3> findAllOrderByName(); // 이 메서드가 @Query를 실행시키고 그 결과가 List<MyData_5_3>으로 반한된다.
}
