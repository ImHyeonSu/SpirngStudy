//package com.tuyano.springboot;
//
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.Query;
//import org.springframework.stereotype.Repository;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;
//
//
//@Repository
//public class MyDataDaoImpl_6_7 implements MyDataDao_6_2<MyData_5_3> {
//	private static final long serialVersionUID = 1L;
//	
//	private EntityManager entityManager; //엔터티를 처리하기 위한 기능이 있다. 그래서 엔터티 처리를 위해서는 무조건 필요하다.
//	
//	public MyDataDaoImpl_6_7() {
//		super();
//	}
//	
//	public MyDataDaoImpl_6_7(EntityManager manager) {
//		entityManager = manager;
//	}
//	
//	//.. 기본적으로 JPQL의 사용법 EntityManager 설정, Query 작성, 결과가져오기
//	
//	@Override
//	public List<MyData_5_3> getAll(){
//	List<MyData_5_3> list = null;	
//	CriteriaBuilder builder = entityManager.getCriteriaBuilder();  // Criteria API를 ㅅ사용해서 쿼리 생성을 관리하는 클래스
//	CriteriaQuery<MyData_5_3> query = builder.createQuery(MyData_5_3.class); //Criteria API를 사용해 쿼리를 실행하는 클래스 -그렇지만 인수를 필요로하지않는다.
//	Root<MyData_5_3> root = query.from(MyData_5_3.class); //검색할 엔터티의 규칙을 지정하는 클래스. 필요한 엔터티를 필터하느 경우등에도 사용, 이를통해 MyData_5_형의 root를 만들고 MyData를 가져와서 root에 저장한다.
//	query.select(root);
//	list = (List<MyData_5_3>)entityManager.createQuery(query).getResultList();
//	return list;
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
//	@Override
//	public List<MyData_5_3> findByAge(int min, int max){
//		return (List<MyData_5_3>)entityManager.createNamedQuery("findByAge").setParameter("min", min).setParameter("max", max).getResultList();
//	}//@Query("from MyData_5_3 where age > :min and age< :max")public List<MyData_5_3> findByAge(@Param("min") int min, @Param("max") int max); -- 리포지터리에서 쿼리 사용법
//}