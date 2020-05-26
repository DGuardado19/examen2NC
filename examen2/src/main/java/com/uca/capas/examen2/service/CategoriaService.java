package com.uca.capas.examen2.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.examen2.domain.Categoria;



public interface CategoriaService {
	public List<Categoria>findAll() throws DataAccessException;
	public void insertCategoria(Categoria categoria) throws DataAccessException;
}
