package com.project.simplon.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.simplon.exception.ResourceNotFoundException;
import com.project.simplon.model.Article;
import com.project.simplon.repository.ArticleRepository;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ArticleController {

	@Autowired
	ArticleRepository articleRepository;

	// Get tout les articles
	@GetMapping("/articles")
	public List<Article> getAllArticles() {
		return articleRepository.findAll();
	}

	// Get un article avec son id

	@GetMapping("/articles/{id}")
	public Article getArticleById(@PathVariable(value = "id") Long articleId) {
		return articleRepository.findById(articleId)
				.orElseThrow(() -> new ResourceNotFoundException("Article", "id", articleId));

	}
	// Post un article

	@PostMapping("/articles")
	public Article createArticle(@Valid @RequestBody Article article) {
		return articleRepository.save(article);

	}

	// Update un article avec son id
	@PutMapping("/articles/{id}")
	public Article updateArticle(@PathVariable(value = "id") Long articleId,
			@Valid @RequestBody Article articleDetails) {

		Article article = articleRepository.findById(articleId)
				.orElseThrow(() -> new ResourceNotFoundException("Article", "id", articleId));

		article.setTitle(articleDetails.getTitle());
		article.setDate(articleDetails.getDate());
		article.setDescription(articleDetails.getDescription());
		article.setNumero(articleDetails.getNumero());

		Article updatedArticle = articleRepository.save(article);
		return updatedArticle;
	}

	// Delete un article avec son id

	@DeleteMapping("/articles/{id}")
	public ResponseEntity<?> deleteArticle(@PathVariable(value = "id") Long articleId) {

		Article article = articleRepository.findById(articleId)
				.orElseThrow(() -> new ResourceNotFoundException("Article", "id", articleId));

		articleRepository.delete(article);

		return ResponseEntity.ok().build();

	}

}
