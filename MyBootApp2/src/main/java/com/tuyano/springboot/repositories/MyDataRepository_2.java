//package com.tuyano.springboot.repositories;
//
//import com.tuyano.springboot.MyData_5_2;
//import org.springframework.data.jpa.repository.JpaRepository; // 새로운 리포지터리 생성을 하기 위한 토대임
//import org.springframework.stereotype.Repository;
//
//
//@Repository
//public interface MyDataRepository_2 extends JpaRepository<MyData_5_2, Long> {
//	public MyData_5_2 findById(long name); //이 메서드는 MyData_5_1 에 구현하지 않았는데 실행된다. 이는 리포지터리의 장점이며 리포지터리는 메스더명을 기준으로 엔터티 검색 처리를 자동 생성하게 돼 있다. 즉 리포지터리는 메서드 선언만 작성하고 구체적인 처리를 구현할 필요가 없다!!
//}										   //리포지터리 작성을 통해 메서드 자동생성기능을 활용할 수 있고 이를 통해 엔터티 취득이 쉬워진다.이는 JpaRepository의 기능이다.
//										   //JpaRepository에 사전을 이용한 코드 자동생성기능이 내장되어있어서이다. 여기서 예시는 findById(인수) > "find" "by id"인수 > from MyData where id = 인수 라는 쿼리를 실행하는 처리
//										   //AND 두항목의 값과 모두일치하는 요소검색, OR 두항목중 하나라도 일치시 검색, Between 두 값사이에 값 검색, LessThan 숫자항목서 인수보다 작은 값,GreaterThan 숫자인수보다 큰 값 검색
//                                           //IsNull 지정항목의 값이 null인 것 검색, IsNotNull/NotNull - 지정항목의 값이 Null이 아닌 것 검색,NotNull과IsNotNull 모두 사용할 수 있다.
//										   //Like 텍스트를 Like 검색한다. 와일드카드 지정까지는 자동으로 해주지 않으므로 필요한 경우 인수로 전달한 값에 와일드 카드를 붙여야 한다.
//										   //NotLike 지정 문자열을 포함하지 않는 것을 검색한다. 와일드카드는 명시적으로 인수에 지정해야한다. OrderBy 나열 순서를 지정한다. Asc,Desc를 붙여서 지정
//										   //Not 지정항목이 인수 값과 같은 것을 검색한다. In 지정 항목의 값이 인수의 컬렉션에 설정한 값 중 하나와 일치하면 검색하다. NotIn 지정항목의 값이 인수의 컬렉션에 설정한 값과 일치하지 않는 것을 검색한다.