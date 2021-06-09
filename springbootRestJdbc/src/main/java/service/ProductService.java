package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ProductDAO;
import util.Product;

@Service
public class ProductService {
	@Autowired
	private ProductDAO articleDAO;

	public Product getArticleById(int articleId) {
		Product obj = articleDAO.getProductById(articleId);
		return obj;
	}

	public List<Product> getAllArticles() {
		return articleDAO.getAllProducts();
	}

	public synchronized boolean addArticle(Product article) {
		if (articleDAO.productExists(article.getTitle(), article.getCategory())) {
			return false;
		} else {
			articleDAO.addProduct(article);
			return true;
		}
	}

	public void updateArticle(Product article) {
		articleDAO.updateProduct(article);
	}

	public void deleteArticle(int articleId) {
		articleDAO.deleteProduct(articleId);
	}
}