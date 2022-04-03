package com.h2yn.springboot.todo.repository;

import java.util.List;
import java.util.Optional;

import com.h2yn.springboot.todo.data.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MyDataRepository extends JpaRepository<MyData, Long> {
	public MyData findById(long name);
}
