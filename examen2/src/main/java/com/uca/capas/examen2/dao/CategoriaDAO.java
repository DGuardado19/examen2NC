package com.uca.capas.examen2.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.examen2.domain.Categoria;
import com.uca.capas.examen2.domain.Libro;


public interface CategoriaDAO {
	public List<Categoria>findAll() throws DataAccessException;
	public void insertCategoria(Categoria categoria) throws DataAccessException;
}
