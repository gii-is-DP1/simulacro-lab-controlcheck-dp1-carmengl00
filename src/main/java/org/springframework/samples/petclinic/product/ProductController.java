package org.springframework.samples.petclinic.product;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping(value = "/product/create")
	public String initCreationForm(Map<String, Object> model) {

		Product product = new Product();
		model.put("product", product);
		model.put("productType", productService.findAllProductTypes());
		return "products/createOrUpdateProductForm";

	}
	
	
	@PostMapping(value="/product/create")
	public String processCreationForm(@Valid Product product, BindingResult result, Map<String, Object> model) {
		
		if(result.hasErrors()) {
			model.put("product", product);
			model.put("productType", productService.findAllProductTypes());
			return "products/createOrUpdateProductForm"; 
		}else {
			this.productService.save(product);
			return "welcome";
		}
	}
	
	
}
