package com.supinfo.restfulexample.dao;

import java.util.List;

import com.supinfo.restfulexample.entity.Mark;

public interface MarkDao {
	
	Mark addMark(Long idBooster, Mark mark);
	Mark findMarkByKey(String key);
	void removeMark(String key);
	List<Mark> findAllMarksByIdBooster(Long idBooster);

}
