package com.app.integracion.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



import com.app.integracion.model.Curso;

@Repository
public interface DaoCurso {
    @Transactional
    public List<Curso> consultarTodos();
    @Transactional
	public void insert(Curso nuevoCurso);
    @Transactional
    public void update(Curso actualizarCurso);
    @Transactional
    public void delete(Curso borrarCurso);
}
