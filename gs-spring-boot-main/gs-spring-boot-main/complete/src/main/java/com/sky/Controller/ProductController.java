package com.sky.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sky.domain.Product;
import com.sky.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	
		@Autowired
		private ProductService productService;
		
		
		@RequestMapping(value  ="/product" , method=RequestMethod.GET,
				produces="application/json")
	    public @ResponseBody List<Product> getProduct(){
			return productService.getProduct();
		}
		
		@RequestMapping(value="/product" , 
				method = RequestMethod.POST,
				consumes="application/json",
				produces="application/json")
		public @ResponseBody Product addProduct(@RequestBody Product product) {
			System.out.println(product);
			productService.addProduct(product);
			return product;
		}
		
		@RequestMapping(value="/product" , 
				method = RequestMethod.DELETE,
				consumes="application/json",
				produces="application/json")
		public @ResponseBody Product deleteProduct(@RequestBody Product product) {
			System.out.println(product);
			productService.deleteProduct(product);
			return product;
		}
		
		@RequestMapping(value="/product/{id}" , 
				method = RequestMethod.GET,
				//consumes="application/json",
				produces="application/json")
		public @ResponseBody Product getProductById(
				@PathVariable("id") String productID) {
			//System.out.println(product);
			//productService.deleteProduct(product);
			//return product;
			return productService.getProductById(productID);
		}
		
		@RequestMapping(value="/product" , 
				method = RequestMethod.PUT,
				consumes="application/json",
				produces="application/json")
		public @ResponseBody Product updateProduct(@RequestBody Product product) {
			System.out.println(product);
			productService.updateProduct(product);
			return product;
		}

	}


