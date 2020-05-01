package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.TogetherManager;
import com.example.demo.vo.TogetherVo;

@Repository
public class TogetherDao {
	public List<TogetherVo> listTogetherAll(){
		return TogetherManager.listTogetherAll();
	}
	
	public int insertTogether(TogetherVo t) {
		return TogetherManager.insertTogether(t);
	}
	
	public int updateTogether(TogetherVo t) {
		return TogetherManager.updateTogether(t);
	}
	
	public int deleteTogether(TogetherVo t) {
		return TogetherManager.deleteTogether(t);
	}
}
