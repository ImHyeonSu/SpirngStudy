package com.h2yn.springboot.todo.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.h2yn.springboot.todo.data.MyData;

@Repository
public class MyDataDaoImpl implements MyDataDao<MyData> {
	private static final long serialVersionUID = 1L;
	
	private EntityManager entityManager; //엔터티를 처리하기 위한 기능이 있다. 그래서 엔터티 처리를 위해서는 무조건 필요하다.
	
	public MyDataDaoImpl() {
		super();
	}
	
	public MyDataDaoImpl(EntityManager manager) {
		entityManager = manager;
	}
	
	@Override
	public List<MyData> getAll(){
		Query query = entityManager.createQuery("from MyData");
		List<MyData> list = query.getResultList();
		entityManager.close();
		return list;
	}
	
	@Override
	public List<MyData> find(String fstr){
		List<MyData> list = null;
		String qstr = "from MyData where id = :fid or name like :fname or mail like :fmail";
		Long fid = 0L;
		try {
			fid = Long.parseLong(fstr);
		}catch (NumberFormatException e) {
			e.printStackTrace();
		}
		Query query = entityManager.createQuery(qstr).setParameter("fid", fid).setParameter("fname", "%" + fstr + "%").setParameter("fmail",fstr + "@%");
		list = query.getResultList();
		return list;
	}

	
}
