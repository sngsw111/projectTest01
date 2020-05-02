package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.TogetherManager;
import com.example.demo.vo.TogetherVo;

@Repository
public class TogetherDao {
	
	public static int pageSize=5;
	public static int totalRecord=0;
	public static int totalPage=1;
	
	public List<TogetherVo> listTogetherAll(HashMap map){
		totalRecord = getTotalRecord();
		totalPage = (int)Math.ceil(totalRecord/(double)pageSize);
		return TogetherManager.listTogetherAll(map);
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
	
	public int getTotalRecord() {
		return TogetherManager.getTotalRecord();
	}
	
}
