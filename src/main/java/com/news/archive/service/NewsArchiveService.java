package com.news.archive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.news.archive.model.News;
import com.news.archive.repository.NewsArchiveRepository;

@Service
public class NewsArchiveService {
	@Autowired
	private NewsArchiveRepository newsArchiveRepository;
	@Autowired
	News news;
	
	public News uploadNews(News uploadNews) {
		 news = new News();
		 news= newsArchiveRepository.uploadNews(uploadNews);
		 return news; 
	}
	
	public List<News> getAllNews(){
		List<News> allNews;
		allNews=newsArchiveRepository.getAllNews();
		return allNews;
	}
	
	public News getNews(int id){
		News requestedNews;
		requestedNews=newsArchiveRepository.getNews(id);
		return requestedNews;
	}

}
