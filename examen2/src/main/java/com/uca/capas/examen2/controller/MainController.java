package com.uca.capas.examen2.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.examen2.domain.Categoria;
import com.uca.capas.examen2.domain.Libro;
import com.uca.capas.examen2.service.CategoriaService;
import com.uca.capas.examen2.service.LibroService;



@Controller
public class MainController {
	
	
	@Autowired
	private LibroService libroservice;
	
	@Autowired
	private CategoriaService categoriaservice;
	
	@RequestMapping("/index")
	public ModelAndView init() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("mensaje", "");
		mav.setViewName("index1");
		return mav;
	}
	
	@RequestMapping("/ingresarcategoria")
	public ModelAndView initcategoria() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("categoria", new Categoria());
		mav.setViewName("icategoria");
		return mav;
	}
	@RequestMapping("/savecategory")
	public ModelAndView savecategory(@Valid @ModelAttribute Categoria categoria, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(!result.hasErrors()) {
			categoriaservice.insertCategoria(categoria);
			mav.addObject("mensaje", "Se guardo la categoria con exito");
			mav.setViewName("index1");
		}else {
			mav.setViewName("icategoria");	
		}
		return mav;
	}	
	
	
	@RequestMapping("/ingresarlibro")
	public ModelAndView initlibro() {
		ModelAndView mav = new ModelAndView();
		List<Categoria> categorialist = null;
		try {
			categorialist = categoriaservice.findAll();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		mav.addObject("libro", new Libro());
		mav.addObject("categorialista", categorialist);
		mav.setViewName("ilibro");
		return mav;
	}
	@RequestMapping("/savelibro")
	public ModelAndView savelibro(@Valid @ModelAttribute Libro libro, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		List<Categoria> categorialist = null;
		try {
			categorialist = categoriaservice.findAll();
		}catch (Exception e) {
			// TODO: handle exception
		}
		if(!result.hasErrors()) {
			try {
		        Date date = new Date(System.currentTimeMillis());
		        libro.setF_ingreso(date);
				libroservice.insertLibro(libro);
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			mav.addObject("mensaje", "Se guardo el libro con exito");
			mav.setViewName("index1");	
		}else {
			mav.addObject("categorialista", categorialist);
			mav.setViewName("ilibro");
		}
		return mav;
	}
	@RequestMapping("/mostrarlibro")
	public ModelAndView mostrarLibros() {
		ModelAndView mav = new ModelAndView();
		List<Libro> libro= null;
		try {
			libro = libroservice.findAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("librolist", libro);
		mav.setViewName("mostrar");
		return mav;
	}
	
}
