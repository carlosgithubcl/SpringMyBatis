package com.app.integracion.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.integracion.model.Tema;

@Repository
public interface DaoTema {
	@Transactional
	public List<Tema> consultarTemasCurso(int id_curso);
}
