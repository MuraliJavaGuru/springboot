package dao;


import java.util.List;

import main.Product;

public interface Dao {
	public Product getProductById(int articleId) ;
	public List<Product> getAllProducts() ;
	public Product addProduct(Product article);
	public void updateProduct(Product article);
	public boolean deleteArticle(int articleId) ;
	public boolean productExists(String title, String category);
}