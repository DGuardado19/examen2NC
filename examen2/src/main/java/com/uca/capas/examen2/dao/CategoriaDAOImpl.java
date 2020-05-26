package com.uca.capas.examen2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.examen2.domain.Categoria;

@Repository
public class CategoriaDAOImpl implements CategoriaDAO {
	
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;

	@Override
	public List<Categoria> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.cat_categoria");
		Query query = entityManager.createNativeQuery(sb.toString(),Categoria.class);
		List<Categoria> resulset = query.getResultList();
		
		return resulset;
	}

	@Override
	@Transactional
	public void insertCategoria(Categoria categoria) throws DataAccessException {
		// TODO Auto-generated method stub
		entityManager.persist(categoria);
	}
	
	
}
