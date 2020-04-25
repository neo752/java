package org.dang.dao;


import org.dang.entity.Product;

public interface CartDao {
	public Product findAllProductById(int id) throws Exception;
}
