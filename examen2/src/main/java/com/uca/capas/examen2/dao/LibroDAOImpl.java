package com.uca.capas.examen2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.examen2.domain.Libro;


@Repository
public class LibroDAOImpl implements LibroDAO {
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	@Override
	public List<Libro> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.cat_libro");
		Query query = entityManager.createNativeQuery(sb.toString(),Libro.class);
		List<Libro> resulset = query.getResultList();
		
		return resulset;
	}

	@Override
	@Transactional
	public void insertLibro(Libro libro) throws DataAccessException {
		// TODO Auto-generated method stub
		entityManager.persist(libro);
	}

	@Override
	@Transactional
	public void deleteLibro(Integer c_libro) throws DataAccessException {
		// TODO Auto-generated method stub
		Libro libro = entityManager.find(Libro.class, c_libro);
		entityManager.remove(libro);
	}

	@Override
	public Libro findOne(Integer c_libro) throws DataAccessException {
		// TODO Auto-generated method stub
		Libro l = entityManager.find(Libro.class, c_libro);
		return l;
	}

	@Override
	@Transactional
	public void actualizarlibro(Libro c_libro) throws DataAccessException {
		// TODO Auto-generated method stub
		entityManager.merge(c_libro);
		entityManager.flush();
	}
	
	
}
