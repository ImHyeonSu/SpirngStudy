package com.tuyano.springboot;

import java.io.Serializable;
import java.util.List;

public interface MyDataDao_6_2 <T> extends Serializable {

	public List<T> getAll(); //모든 엔터티를 가져오는 역할
	public T findById(long id); // id번ㅗ별로 엔터티를 검색한다.
	public List<T> findByName(String name);// 이름으로 엔터티를 검색한다.
	public List<T> find(String fstr);
	public List<T> findByAge(int ming, int max);
}
