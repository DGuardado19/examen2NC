package com.uca.capas.examen2.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.examen2.domain.Libro;

public interface LibroService {
	
	public List<Libro>findAll() throws DataAccessException;
	public void insertLibro(Libro libro) throws DataAccessException;
	public void deleteLibro(Integer c_libro) throws DataAccessException;
	public Libro findOne(Integer c_libro) throws DataAccessException;
	public  void actualizarlibro(Libro c_libro) throws DataAccessException;

}
