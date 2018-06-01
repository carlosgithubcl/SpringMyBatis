package com.app.negocio.tema;

import java.util.List;

import com.app.integracion.model.Tema;


public interface TemaServicio {
	public List<Tema> consultarTemasCurso(int id_curso);
}
