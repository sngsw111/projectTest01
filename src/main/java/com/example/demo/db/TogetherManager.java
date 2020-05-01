package com.example.demo.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.TogetherVo;

public class TogetherManager {
	private static SqlSessionFactory factory;
	
	static {
		try {
			Reader reader = Resources.getResourceAsReader("com/example/demo/db/sqlMapConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	public static List<TogetherVo> listTogetherAll(){
		SqlSession session = factory.openSession();
		List<TogetherVo> list = session.selectList("together.selectAll");
		session.close();
		return list;
	}
	
	public static int insertTogether(TogetherVo t) {
		SqlSession session = factory.openSession();
		int re = session.insert("together.insertTogether",t);
		session.commit();
		session.close();
		return re;
	}
	
	public static int updateTogether(TogetherVo t) {
		SqlSession session = factory.openSession();
		int re = session.insert("together.updateTogether",t);
		session.commit();
		session.close();
		return re;
	}
	
	public static int deleteTogether(TogetherVo t) {
		SqlSession session = factory.openSession();
		int re = session.insert("together.deleteTogether",t);
		session.commit();
		session.close();
		return re;
	}
	
}
