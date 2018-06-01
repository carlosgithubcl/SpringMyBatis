package com.app.negocio.curso;

import java.util.List;

import com.app.integracion.model.Curso;


public interface CursoServicio {
    public List<Curso> consultarTodos();
    public void insert(Curso nuevo);
    public void update(Curso actualizarCurso);
    public void delete(Curso deleteCurso);
}
