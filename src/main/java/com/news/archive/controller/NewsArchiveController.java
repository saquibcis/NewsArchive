package com.news.archive.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.news.archive.model.News;
import com.news.archive.service.NewsArchiveService;

@RestController
@RequestMapping(path="/news")
public class NewsArchiveController {
	
	@Autowired
	private NewsArchiveService newsArchiveService;
	@Autowired
	private News news;
	
	@RequestMapping(path="/ShowAll")
	public String getArchivedNews() {
		
		return "i am a demo Archived Version of News";
	}
	
	@PostMapping("/upload")
	public News uploadNews(@RequestBody News uploadNews) {
		news= newsArchiveService.uploadNews(uploadNews);
		return news;
	}
	
	@GetMapping("/getAllNews")
	public List<News> getAllNews() {
		List<News> allNews;
		allNews= newsArchiveService.getAllNews();
		
		return allNews;
	}
	
	@GetMapping("get/{id}")
	public News getNews(@PathVariable ("id") Integer id) {
		News allNews;
		allNews= newsArchiveService.getNews(id);
		
		return allNews;
	}
	
	
}
