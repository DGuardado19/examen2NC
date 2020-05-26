package com.uca.capas.examen2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.examen2.dao.LibroDAO;
import com.uca.capas.examen2.domain.Libro;


@Service
public class LibroServiceImpl implements LibroService{
	
	@Autowired
	private LibroDAO libroDAO;
	
	@Override
	public List<Libro> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return libroDAO.findAll();
	}

	@Override
	public void insertLibro(Libro libro) throws DataAccessException {
		// TODO Auto-generated method stub
		libroDAO.insertLibro(libro);
	}

	@Override
	public void deleteLibro(Integer c_libro) throws DataAccessException {
		// TODO Auto-generated method stub
		libroDAO.deleteLibro(c_libro);
	}

	@Override
	public Libro findOne(Integer c_libro) throws DataAccessException {
		// TODO Auto-generated method stub
		return libroDAO.findOne(c_libro);
	}

	@Override
	public void actualizarlibro(Libro c_libro) throws DataAccessException {
		// TODO Auto-generated method stub
		libroDAO.actualizarlibro(c_libro);
	}
	
	
}
