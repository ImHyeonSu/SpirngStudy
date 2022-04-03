package com.tuyano.springboot;

import java.io.Serializable;
import java.util.List;

public interface MsgDataDao_6_1<T> {

	public List<MsgData_6_1> getAll();
	public MsgData_6_1 findById(long id);
}
