package com.example.demo.controller;


import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
	
	@RequestMapping("/listTogether.do")
	public ModelAndView listTogether() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.listTogetherAll());
		return mav;
	}
	
//	@RequestMapping(value="/listTogether.do")
//	public ModelAndView listTogether(String searchColumn, String sortColumn,
//			String keyword, HttpSession session,
//			@RequestParam(value="pageNum", defaultValue="1") int pageNum) {
//		
//		System.out.println("검색어: " + keyword);
//		if(keyword==null) {
//			keyword = (String)session.getAttribute("keyword");
//			searchColumn = (String)session.getAttribute("name");
//		}
//		
//		HashMap map = new HashMap<>();
//		int start = (pageNum-1) * TogetherDao.pageSize + 1;
//		int end = start + TogetherDao.pageSize - 1;
//		map.put("keyword", keyword);
//		map.put("searchColumn", searchColumn);
//		map.put("sortColumn", sortColumn);
//		map.put("start", start);
//		map.put("end", end);
//		System.out.println("map이 가진 값" + map);
//		
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("list",dao.listTogetherAll(map));
//		System.out.println("전체 페이지 수: "+ TogetherDao.totalPage);
//		mav.addObject("totalPage", TogetherDao.totalPage);
//		
//		session.setAttribute("keyword", keyword);
//		session.setAttribute("searchColumn", searchColumn);
//		return mav;
//	}
	
	@RequestMapping("/detailTogether.do")
    public ModelAndView detail(int t_num) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("t", dao.getTogether(t_num));
        return mav;
    }
	
	@RequestMapping(value="/insertTogether.do",method = RequestMethod.GET)
	public void insertTogetherForm() {
		
	}
	
	@RequestMapping(value="/insertTogether.do",method = RequestMethod.POST)
	public ModelAndView insertTogetherSubmit(TogetherVo t, HttpSession session, HttpServletRequest request) {
		
		//첨부파일업로드
		String path = request.getRealPath("togetherupload");
		System.out.println("path : "+path);
		
		//썸네일파일업로드
		String thumbnailpath = request.getRealPath("thumbnailupload");
		System.out.println("thumbnailpath : "+ thumbnailpath);
		
		ModelAndView mav = new ModelAndView("redirect:/listTogether.do");	
		String msg = "게시물 등록되었습니다.";
		
		//첨부파일업로드
		MultipartFile uploadFile = t.getUploadFile();
		String t_fname = uploadFile.getOriginalFilename();
		t.setT_fname(t_fname);
		
		//썸네일파일업로드
		MultipartFile thumbnailFile = t.getThumbnailFile();
		String t_thumbnail = thumbnailFile.getOriginalFilename();
		t.setT_thumbnail(t_thumbnail);
		
		int re = dao.insertTogether(t);
		if(re <= 0) {
			msg = "게시물 등록에 실패하였습니다.";
		}else {
			try {
				byte[]data = uploadFile.getBytes();
				byte[]data2 = thumbnailFile.getBytes();
				FileOutputStream filefos = new FileOutputStream(path+"/"+t_fname);
				FileOutputStream thumnailfos = new FileOutputStream(thumbnailpath+"/"+t_thumbnail);
				filefos.write(data);
				thumnailfos.write(data2);
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("예외발생:"+ e.getMessage());
			}
		}
		session.setAttribute("msg", msg);
		return mav;
	}
	
	@RequestMapping(value = "/updateTogether.do", method = RequestMethod.GET)
    public ModelAndView updateTogetherForm(int t_num) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("t", dao.getTogether(t_num));
        return mav;
    }
	
	@RequestMapping(value = "/updateTogether.do", method = RequestMethod.POST)
	public ModelAndView updateTogetherSubmit(TogetherVo t, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("redirect:/listTogether.do");
		
		//첨부파일 수정
		String path = request.getRealPath("togetherupload");
		System.out.println("path : "+ path);
		String togetheroldFname = t.getT_fname();
		MultipartFile uploadFile = t.getUploadFile();
		String t_fname= null;
		if(uploadFile != null) {
			t_fname = uploadFile.getOriginalFilename();
			if(t_fname != null && !t_fname.equals("")) {
				t.setT_fname(t_fname);
				try {
					byte []data = uploadFile.getBytes();
					FileOutputStream filefos = new FileOutputStream(path+"/"+t_fname);
					filefos.write(data);
					filefos.close();
				}catch (Exception e) {
					// TODO: handle exception
					System.out.println("예외발생 : "+e.getMessage());
				}
			}
		}
		int re = dao.updateTogether(t);
		
		//수정파일이 업로드 되고 기존 파일이 삭제된다.
		if(re > 0 
				&& t_fname != null
				&& !t_fname.equals("")
				&& togetheroldFname != null
				&& !togetheroldFname.equals("")) {
			File file = new File(path+"/"+togetheroldFname);
			file.delete();
		}
		return mav;
	}
	
	@RequestMapping(value = "/deleteTogether.do")
    public ModelAndView deleteTogether(int t_num) {
        ModelAndView mav = new ModelAndView("redirect:/listTogether.do");
        int re = dao.deleteTogether(t_num);
        String str = "게시물 삭제에 실패하였습니다.";
        if(re > 0) {
        	str = "게시물 삭제에 성공하였습니다.";
        }
        return mav;
    }
	
	
	 @RequestMapping(value="/main")
	    public String main() {
	        return "main";
	    }
	
	
	
	
}