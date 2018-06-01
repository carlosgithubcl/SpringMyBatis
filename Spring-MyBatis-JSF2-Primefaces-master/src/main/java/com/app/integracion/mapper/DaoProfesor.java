package com.app.integracion.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.integracion.model.Profesor;


@Repository
public interface DaoProfesor {
	@Transactional
	public List<Profesor> consultarTodos();

    public Profesor getProfe(Profesor p);
}
