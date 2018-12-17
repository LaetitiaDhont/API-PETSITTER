package com.project.simplon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.simplon.model.Article;

/**
 * The Interface ArticleRepository.
 */
public interface ArticleRepository extends JpaRepository <Article, Long>{

}
