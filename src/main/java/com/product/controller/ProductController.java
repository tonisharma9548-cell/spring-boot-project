package com.product.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.product.model.Product;
import com.product.service.ProductService;
@Controller
public class ProductController 
{
	private ProductService productService;

	public ProductController(ProductService productService) {
		
		this.productService = productService;
	}
	
	@GetMapping
	public String getHomeView()
	{
		return "home";
	}
	
	@GetMapping("add")
	public String addProductView()
	
	{
		return "insertProductForm";
	}
	@PostMapping("insert.do")
	public String saveProduct(Product product)
	{
		productService.saveProduct(product);
		return "insertSuccess";
	}
	
	@GetMapping("products")
	public ModelAndView getProductList()
	
	{
		List<Product> products = productService.getProducts();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("products" ,products );
		modelAndView.setViewName("productList");
		return modelAndView;
	}
	@GetMapping("delete")
	public String getDelete()
	{
		return "delete-product-form";
	}
	
	@GetMapping("confirmDelete")
	public String confirmDelete(int pid, Model model)
	
	{
		Product product = productService.getProduct(pid);
		if(product==null)
		{
		    model.addAttribute("msg", "Product does not exist!");
		    model.addAttribute("msg" ,pid);
		    return "delete-product-form";
		}
		model.addAttribute("product" , product);
		return "confirm-delete-product";
	}
	
	@GetMapping("deleteProduct")
     public String deleteProductRecord(int pid , Model model) 
	{
		productService.deleteProduct(pid);
    	 model.addAttribute("pid", pid);
    	 return "delete-product-success";
     }
	
	@GetMapping("search")
	public String getSearch() 
	{
		return "search-product-form";
	}
	
	@GetMapping("search.do")
	public String showProduct(int pid , Model model)
	{
         Product product = productService.getProduct(pid);
		if(product==null)
		{
		    model.addAttribute("msg",  "Product with ID " + pid + " not found!");
		    model.addAttribute("msg" ,pid);
		    return "search-product-form";
        }
		model.addAttribute("product", product);
		return "show-product-details";
	}
	@GetMapping("edit")
	public String getUpdate()
	{
		return "edit-product-form";
	}
	
	@GetMapping("getProduct")
	public String getProduct(int pid, Model model)
	
	{
		Product product = productService.getProduct(pid);
		if(product==null)
		{
		    model.addAttribute("msg", "Product does not exist!");
		    model.addAttribute("msg" ,pid);
		    return "edit-product-form";
		}
		model.addAttribute("product" , product);
		return "edit-product-details";
	}
	
	@PostMapping("updateProduct")
    public String updateProductRecord(Product productUpdate) 
	{
		productService.updateRecord(productUpdate);
   	 return "edit-product-success";
    }
}
