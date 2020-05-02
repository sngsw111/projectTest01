package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.TogetherDao;
import com.example.demo.vo.TogetherVo;

@Controller
public class TogetherController {
	
	@Autowired
	private TogetherDao dao;

	public void setDao(TogetherDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value="/listTogether.do")
	public ModelAndView listTogether() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list",dao.listTogetherAll());
		return mav;
	}
	
	@RequestMapping(value="/insertTogether.do",method = RequestMethod.GET)
	public void insertTogetherForm() {
		
	}
	
	@RequestMapping(value="/insertTogether.do",method = RequestMethod.POST)
	public ModelAndView insertTogetherSubmit(TogetherVo t) {
		ModelAndView mav = new ModelAndView("redirect:/listTogether.do");
		String msg = "게시물 등록되었습니다.";
		
		int re = dao.insertTogether(t);
		if(re <= 0) {
			msg = "게시물 등록에 실패하였습니다.";
		}
		return mav;
	}
	
	 @RequestMapping(value="/main")
	    public String main() {
	        return "main";
	    }
	
	
	
	
}
