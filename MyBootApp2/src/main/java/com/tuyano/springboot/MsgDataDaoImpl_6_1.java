package com.tuyano.springboot;

import java.util.List;
import javax.persistence.EntityManager;

public class MsgDataDaoImpl_6_1 implements MsgDataDao_6_1<MsgData_6_1> {
	
	private EntityManager entityManager;
	
	public MsgDataDaoImpl_6_1() {
		super();
	}
	
	public MsgDataDaoImpl_6_1(EntityManager manager) {
		entityManager = manager;
	}
	
	@Override
	public List<MsgData_6_1> getAll() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("from MsgData_6_1").getResultList();
	}

	@Override
	public MsgData_6_1 findById(long id) {
		// TODO Auto-generated method stub
		return (MsgData_6_1)entityManager.createQuery("from MsgData_6_1 where id = " + id).getSingleResult();
	}

}
