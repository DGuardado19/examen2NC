package com.uca.capas.examen2.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.examen2.domain.Libro;


public interface LibroDAO {
	
	public List<Libro>findAll() throws DataAccessException;
	public void insertLibro(Libro libro) throws DataAccessException;
	public void deleteLibro(Integer c_libro) throws DataAccessException;
	public Libro findOne(Integer c_libro) throws DataAccessException;
	public  void actualizarlibro(Libro c_libro) throws DataAccessException;
}
