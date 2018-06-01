package com.app.negocio.tema.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.integracion.mapper.DaoTema;
import com.app.integracion.model.Tema;
import com.app.negocio.tema.TemaServicio;

@Service("temaServicio")
public class TemaServicioImp implements TemaServicio {
	
	@Autowired
	private DaoTema daoTema;
	
	public List<Tema> consultarTemasCurso(int id_curso) {
		// TODO Auto-generated method stub
		return daoTema.consultarTemasCurso(id_curso);
	}
}
