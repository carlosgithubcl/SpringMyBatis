package com.app.negocio.profesor;

import java.util.List;

import com.app.integracion.model.Profesor;

public interface ProfesorServicio {

	public List<Profesor> consultarTodos();

    public Profesor getProfe(Profesor p);
}
