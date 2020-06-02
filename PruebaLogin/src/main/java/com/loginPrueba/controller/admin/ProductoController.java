package com.loginPrueba.controller.admin;



import java.util.List;

import javax.validation.Valid;
import org.springframework.data.domain.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.loginPrueba.modelo.Categoria;
import com.loginPrueba.modelo.Producto;
import com.loginPrueba.modelo.Usuario;
import com.loginPrueba.servicios.CategoriaService;
import com.loginPrueba.servicios.EdificioService;
import com.loginPrueba.servicios.ProductoService;
import com.loginPrueba.servicios.TecnicoService;
import com.loginPrueba.servicios.UsuarioService;

@Controller
@RequestMapping("/admin/producto")
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private EdificioService edificioService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private TecnicoService tecnicoService;

	@GetMapping("/")
	public String index(Model model, Pageable pageable) {
		model.addAttribute("productos", productoService.findAllPaginated(pageable));
		return "admin/list-producto";
	}

	@GetMapping("/nuevo")
	public String nuevaProducto(Model model) {
		model.addAttribute("producto", new Producto());
		model.addAttribute("categorias", categoriaService.findAll());
		model.addAttribute("edificios", edificioService.findAll());
		return "admin/form-producto";
	}

	@PostMapping("/nuevo/submit")
	public String submitNuevoProducto(@Valid Producto producto, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("categorias", categoriaService.findAll());
			model.addAttribute("edificios", edificioService.findAll());
			return "admin/form-producto";
		} else {
			producto.setStock(producto.getStock()+producto.getCantidad());
			producto.setCantidad(0);
			productoService.save(producto);
			return "redirect:/admin/producto/";

		}

	}
	
	@GetMapping("/editar/{id}")
	public String editarProducto(@PathVariable("id") String id, Model model) {

		Producto producto = productoService.findById(id);
		

		if (producto != null) {
			producto.setCantidad(0);
			model.addAttribute("producto", producto);
			model.addAttribute("categorias", categoriaService.findAll());
			model.addAttribute("edificios", edificioService.findAll());
			return "admin/form-producto";
		} else {
			return "redirect:/admin/producto/";
		}
	}
	
	
	@GetMapping("/borrar/{id}")
	public String borrarProducto(@PathVariable("id") String id, Model model) {

		Producto producto = productoService.findById(id);

		if (producto != null) {
			
			if(tecnicoService.numeroTecnicoProducto(producto)==0&usuarioService.numeroUsuarioProducto(producto)==0) {
				productoService.delete(producto);
			}else {
				return "redirect:/admin/producto/";
			}				
		}
		return "redirect:/admin/producto/";
	}
	
	
	@GetMapping("/product/{id}")
	public String showDetails(@PathVariable("id") String id, Model model) {
		Producto p = productoService.findById(id);
		if (p != null) {
			model.addAttribute("producto", p);
			model.addAttribute("usuarios", usuarioService.findAllByProducto(id));
			model.addAttribute("tecnicos", tecnicoService.findAllByProducto(id));
			return "admin/one-producto";
		}
		
		return "redirect:/";
		
	}

	
	

}
