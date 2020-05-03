package com.example.demo.vo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TogetherVo {
	private int t_num;
	private String t_title;
	private String t_intro;
	private String t_detail;
	private Date t_open_date;
	private String t_thumbnail;
	private String t_place;
	private String t_date;
	private int t_size;
	private int t_attendee_cnt;
	private String t_comment;
	private String t_comment_step;
	private String t_fname;
	private String user_id;
	private int t_hit;
	
	private MultipartFile uploadFile;
	private MultipartFile thumbnailFile;
	
}

/*
t_num
t_title
t_intro
t_detail
t_open_date
t_img
t_place
t_date
t_size
t_attendee_cnt
t_comment
t_comment_step
t_fname
user_id
t_hit
*/