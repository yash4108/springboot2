package com.sky.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sky.domain.Category;
import com.sky.domain.Product;

@Repository(" productRepositoryDBImpl")
public class ProductRepositoryDBImpl implements ProductRepository {

	private final static String INSERT_PRODUCT_SQL = "insert into products(productId, productName, productPrice) values(?,?,?)";
//	private final static String ALL_PRODUCT_SQL = "select productId, productName, productPrice  from products";
	private final static String PRODUCT_BY_ID_SQL = "select productId, productName, productPrice  from products where productId=?";
	private final static String UPDATE_PRODUCT_SQL = "update products set  productName=?,productPrice=? where productId=?";
	private final static String DELETE_PRODUCT_SQL = "delete from products where productId=?";
	private final static String ALL_PRODUCT_SQL = "Select productId, productName,productprice , a.catId as categoryId, catName from products a , category b where a.catId = b.catID";//adding second table column in query by joins and condition

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(INSERT_PRODUCT_SQL, product.getProductId(), product.getProductName(), product.getPrice());

	}

	@Override
	public List<Product> getProduct() {
		// TODO Auto-generated method stub

		return this.jdbcTemplate.query(ALL_PRODUCT_SQL, new ProductRowMapper());
	}

	@Override
	public void deleteProduct(Product product) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(DELETE_PRODUCT_SQL, product.getProductId());
	}

	@Override
	public Product getProductById(String productID) {
		// TODO Auto-generated method stub
		return this.jdbcTemplate.queryForObject(PRODUCT_BY_ID_SQL, new Object[] { productID }, new ProductRowMapper());
	}

	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update(UPDATE_PRODUCT_SQL, product.getProductName(), product.getPrice(),
				product.getProductId());
		return product;
	}

	private static final class ProductRowMapper implements RowMapper<Product> {
		public Product mapRow(ResultSet rs, int rownum) throws SQLException {

			Product product = new Product();
			product.setProductId(rs.getString("productId"));
			product.setProductName(rs.getString("productName"));
			product.setPrice(rs.getInt("productprice"));
			Category category = new Category();
			category.setCatId(rs.getString("categoryId"));
			category.setCatName(rs.getString("catName"));
			product.setCategory(category); ///association i.e. joining two tables by inserting object of category ointo product

			return product;

		}

	}

}
