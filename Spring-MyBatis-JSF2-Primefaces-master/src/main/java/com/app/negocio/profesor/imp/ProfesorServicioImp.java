package com.app.negocio.profesor.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.integracion.mapper.DaoProfesor;
import com.app.integracion.model.Profesor;
import com.app.negocio.profesor.ProfesorServicio;

@Service("profesorServicio")
public class ProfesorServicioImp implements ProfesorServicio {
	
	@Autowired
	private DaoProfesor daoProfesor;
 
	public List<Profesor> consultarTodos() {
		// TODO Auto-generated method stub
		return daoProfesor.consultarTodos();
	}

    public Profesor getProfe(Profesor p){
        return daoProfesor.getProfe(p);
    }
}
