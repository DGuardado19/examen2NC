package com.uca.capas.examen2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.examen2.dao.CategoriaDAO;
import com.uca.capas.examen2.domain.Categoria;


@Service
public class CategoriaServiceImpl implements CategoriaService {
	
	@Autowired
	private CategoriaDAO categoriaDAO;
	
	@Override
	public List<Categoria> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return categoriaDAO.findAll();
	}

	@Override
	public void insertCategoria(Categoria categoria) throws DataAccessException {
		// TODO Auto-generated method stub
		categoriaDAO.insertCategoria(categoria);
	}

}
