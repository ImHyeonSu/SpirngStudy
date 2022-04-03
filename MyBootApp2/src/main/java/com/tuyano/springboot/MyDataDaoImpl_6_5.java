package com.tuyano.springboot;
//package com.tuyano.springboot;
//
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.Query;
//import org.springframework.stereotype.Repository;
//
//
//
//@Repository
//public class MyDataDaoImpl_6_5 implements MyDataDao_6_2<MyData_5_3> {
//	private static final long serialVersionUID = 1L;
//	
//	private EntityManager entityManager; //엔터티를 처리하기 위한 기능이 있다. 그래서 엔터티 처리를 위해서는 무조건 필요하다.
//	
//	public MyDataDaoImpl_6_5() {
//		super();
//	}
//	
//	public MyDataDaoImpl_6_5(EntityManager manager) {
//		entityManager = manager;
//	}
//	
//	//.. 기본적으로 JPQL의 사용법 EntityManager 설정, Query 작성, 결과가져오기
//	
//	@Override
//	public List<MyData_5_3> getAll(){
//	Query query = entityManager.createQuery("from MyData_5_3"); // 엔터티를 가져오는 방법에는 몇 가지가 있다. 그 중 Query 클래스를 이용한다. 쿼리클래스는 말그대로 DB와 연동해 쿼리기능을 사용하기 위한 클래스이다.
//	List<MyData_5_3> list = query.getResultList();				//JPA에는 JPQL이라는 쿼리언어가 탑재돼있으며, SQL쿼리문을 사용해 데이터베이스 처리를 좀 더 쉽게 하기 위한 쿼리가 되는것이 Query인스턴스이다.
//	entityManager.close();									//EntityManager의 createQuery는 인수에 JPQL쿼리문을 지정해 호출한다. >> from Mydata 는 select *from my data라는 뜻이다
//	return list;											////list는 쿼리실행 결과를 List 인스턴스로 가져오는 것이다. 이후 retunr 시켜 값을 추출
//}
//	@Override
//	public MyData_5_3 findById(long id) {
//		return (MyData_5_3)entityManager.createQuery("from MyData_5_3 weher id = + id").getSingleResult(); //JPQL의 쿼리문 또한 getSingleresult는 하나의 엔터티를 반환하는 것이다.
//	}
//	@Override
//	public List<MyData_5_3> findByName(String name){
//		return (List<MyData_5_3>)entityManager.createQuery("from MyData_5_3 where name = + name").getResultList(); // JPQL의 쿼리문 리스트를반환한다.
//	}
//	@Override
//	public List<MyData_5_3> find(String fstr){
//		List<MyData_5_3> list = null;
//		Long fid = 0L;
//		try {
//			fid = Long.parseLong(fstr);
//		}catch(NumberFormatException e) {
//			e.printStackTrace();
//		}
//		Query query = entityManager.createQuery("findWithName").setParameter("fname", "%" + fstr + "%");//Mydata_5_3에서 미리 이름을 정해놓은 쿼리를 불러와서 그대로 사용한다.
//		list = query.getResultList();
//		return list;
//		
//	}
//}