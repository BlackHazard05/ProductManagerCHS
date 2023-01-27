package net.codejava.ProductManager3;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class AppController {
	
	@Autowired
	private ProductoService service;
	
	@RequestMapping("/")
	public String viewHomePage(Model model, HttpServletRequest request) {
		List<Producto> listaProductos = service.listAll();
		model.addAttribute("listaProductos", listaProductos);
		return "index";
	}
	
	@RequestMapping("/new")
	public String showNewProductPage(Model model) {
		Producto producto = new Producto();
		model.addAttribute("producto", producto);
		
		return "new_product";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("producto") Producto producto) {
		service.save(producto);
		
		return "redirect:/";
	}
	
	@RequestMapping("/buscar")
	public String buscar(Model model) {
		List<Producto> productos = new ArrayList<>();
		model.addAttribute("productos", productos);
		return "find_product";
	}
	
	@RequestMapping(value = "/buscarPorMarca/{marca}", method = RequestMethod.GET)
	public String buscarProductoPorMarca(@PathVariable String marca, Model model) {
		List<Producto> productos = service.getByMarca(marca);
		model.addAttribute("productos", productos);
		
		return "find_product";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") Integer id) {
		ModelAndView mav = new ModelAndView("edit_product");
		Producto producto = service.get(id);
		mav.addObject("product", producto);
		
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") Integer id) {
		service.delete(id);
		return "redirect:/";		
	}
	
	@RequestMapping("/buscarPorPrecio")
	public String buscarPrecio(Model model) {
		List<Producto> productos = new ArrayList<>();
		model.addAttribute("productos", productos);
		return "find_product_price";
	}
	
	@RequestMapping(value = "/buscarPorPrecio/{precio}", method = RequestMethod.GET)
	public ModelAndView buscarProductoPorPrecioMayor(@PathVariable BigDecimal precio) {
		ModelAndView mav = new ModelAndView("find_product_price");
		List<Producto> productos = service.getPrecioMayorQue(precio);
		mav.addObject("productos", productos);
		
		return mav;
	}
}
