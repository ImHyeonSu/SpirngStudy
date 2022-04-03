package com.h2yn.springboot.todo.dao;

import java.io.Serializable; // 데이터 직렬화 라이브러리
import java.util.List;

public interface MyDataDao <T> extends Serializable {

	public List<T> getAll();
	public List<T> find(String fstr);
		
}
