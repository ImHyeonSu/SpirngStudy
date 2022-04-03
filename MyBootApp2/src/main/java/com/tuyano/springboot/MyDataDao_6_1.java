package com.tuyano.springboot;

import java.io.Serializable;
import java.util.List;

public interface MyDataDao_6_1 <T> extends Serializable {

	public List<T> getAll();
}
