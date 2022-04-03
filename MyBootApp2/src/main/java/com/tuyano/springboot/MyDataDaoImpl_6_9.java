package com.tuyano.springboot;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


//값을 비교하는 CriteriaBuilder 메서드
//<CriteriaBuilder>.Equal(path,object) - path에 저장된 엔터티의 프로퍼티와 object 비교 <CriteriaBuilder>.notEqual(path,object) - 두 개의 인수가 다른지 비교
//<CriteriaBuilder>.gt(greaterThan)(path,object) - ptah가 object보다 큰지를 확인한다.
//<CriteriaBuilder>.ge(greaterThanOrEqualTo)(path,object) - path가 object값과 같거나 큰지를 확인한다.
//<CriteriaBuilder>.lt(lessThan)(path,object) - path가 object보다 작은지를확인
//<CriteriaBuilder>.le(lessThanOrEqualTo)(path,object) -path가 objcet보다 작거나 같은지 확인
//<CriteriaBuilder>.between(path,object1,object2) - path가 object1~2의 값인지 확인한다.
//<CriteriaBuilder>.isNull(path) - path가 null인지 확인 <CriteriaBuilder>.isNotNull(path) - path가 null이 아닌지 확인
//<CriteriaBuilder>.isEmpty(path) - path가 빈값(공백문자포함)인지 확인 <CriteriaBuilder>.isNotEmpty(path) - path가 채워져있는지 확인
//<CriteriaBuilder>.like(path,string) - path가 2번째의 문자열을 포함하고 있는지 확인한다. SQLdml like같으며 값의 앞뒤에 %기호를 붙여서 와일드카드 자열을 비교할 수 있다.
//<CriteriaBuilder>.and(predicate1, predicate2) - 두개의 식을 나타내는 객체가 모두 성립하는지를 확인한다. 인수수는 가변적임 2개든 3개든 상관없다.
//<CriteriaBuilder>.or(predicate1, predicate2) - 두개의 식을 나타내는 객체 중 하나가 성립하는지를 확인한다. 인수수 가변
//<CriteriaBuilder>.not(predicate1, predicate2) - 인수로 지정한 식이 성립하지 않는 것을 확인한다.
//<CriteriaBuilder>.orderBy(or asc,desc)(order) - 출력순서

@Repository
public class MyDataDaoImpl_6_9 implements MyDataDao_6_2<MyData_5_3> {
	private static final long serialVersionUID = 1L;
	
	private EntityManager entityManager; //엔터티를 처리하기 위한 기능이 있다. 그래서 엔터티 처리를 위해서는 무조건 필요하다.
	
	public MyDataDaoImpl_6_9() {
		super();
	}
	
	public MyDataDaoImpl_6_9(EntityManager manager) {
		entityManager = manager;
	}
	
	//.. 기본적으로 JPQL의 사용법 EntityManager 설정, Query 작성, 결과가져오기
	
	@Override
	public List<MyData_5_3> getAll(){
		int offset = 1;
		int limit = 2;		
	List<MyData_5_3> list = null;	
	CriteriaBuilder builder = entityManager.getCriteriaBuilder();  // Criteria API를 ㅅ사용해서 쿼리 생성을 관리하는 클래스
	CriteriaQuery<MyData_5_3> query = builder.createQuery(MyData_5_3.class); //Criteria API를 사용해 쿼리를 실행하는 클래스 -그렇지만 인수를 필요로하지않는다.
	Root<MyData_5_3> root = query.from(MyData_5_3.class); //검색할 엔터티의 규칙을 지정하는 클래스. 필요한 엔터티를 필터하느 경우등에도 사용, 이를통해 MyData_5_형의 root를 만들고 MyData를 가져와서 root에 저장한다.
	query.select(root); // >> 내림차순으로 정리하고 싶을때 query.select(root).orderBy(builder.asc(root.get("name"))); 
	list = (List<MyData_5_3>)entityManager.createQuery(query).setFirstResult(offset).setMaxResults(limit).getResultList(); //setFirstResult는 지정위치로부터 엔터티값을 가져오는것, setMaxResults는 가져올 최대갯수를 정하는 것.
	return list;
}
	@Override
	public MyData_5_3 findById(long id) {
		return (MyData_5_3)entityManager.createQuery("from MyData_5_3 weher id = + id").getSingleResult(); //JPQL의 쿼리문 또한 getSingleresult는 하나의 엔터티를 반환하는 것이다.
	}
	@Override
	public List<MyData_5_3> findByName(String name){
		return (List<MyData_5_3>)entityManager.createQuery("from MyData_5_3 where name = + name").getResultList(); // JPQL의 쿼리문 리스트를반환한다.
	}
	@Override
	public List<MyData_5_3> find(String fstr){
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<MyData_5_3> query = builder.createQuery(MyData_5_3.class);
		Root<MyData_5_3> root = query.from(MyData_5_3.class);
		query.select(root).where(builder.equal(root.get("name"), fstr)); //인수의 텍스트와 name값이 일치하는 엔터티만 검색하고 있다. Root d인스턴스를 가져온 후 엔터티를 선별하기 위한 메서드이다. 또한 메서드 체인을 통해 where,bulider.equal를 사용해 rootㅅ항의 name과 fstr을 비교해서 그 값을 반환한다.
		List<MyData_5_3> list = null;									//where 을 통해서 쿼리문등을 텍스트로 전달하는 것이아닌 객체를 비교평가하는 식으로 Criteria는 쿼리를 한다.
		list = (List<MyData_5_3>)entityManager.createQuery(query).getResultList();
		return list;
	}
	@Override
	public List<MyData_5_3> findByAge(int min, int max){
		return (List<MyData_5_3>)entityManager.createNamedQuery("findByAge").setParameter("min", min).setParameter("max", max).getResultList();
	}//@Query("from MyData_5_3 where age > :min and age< :max")public List<MyData_5_3> findByAge(@Param("min") int min, @Param("max") int max); -- 리포지터리에서 쿼리 사용법
}