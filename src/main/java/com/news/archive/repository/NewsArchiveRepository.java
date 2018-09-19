package com.news.archive.repository;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.news.archive.model.News;

@Repository
public class NewsArchiveRepository {

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private News news;

	public News uploadNews(News uploadNews) {

		Session session  = sessionFactory.openSession();

		news=uploadNews;

		session.persist(news);
		session.flush();
		session.close();
		return news;


	}

	public List<News> getAllNews() {

		Session session  = sessionFactory.openSession();
		session.beginTransaction();

		String query = "FROM News";
		Query hql = session.createQuery(query);
		List<News> newsList= hql.list();

		return newsList;
	}



	public News getNews(int id) {

		Session session  = sessionFactory.openSession();
		session.beginTransaction();

		String query = "FROM News where id ="+id;
		Query hql = session.createQuery(query);
		List<News> newsList= hql.list();

		return newsList.get(0);
	}

}
