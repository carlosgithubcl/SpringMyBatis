package com.app.presentacion;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.faces.bean.SessionScoped;

import com.app.integracion.model.Curso;
import com.app.negocio.curso.CursoServicio;

import javax.annotation.PostConstruct;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;


import javax.faces.event.ActionEvent;


@ManagedBean
@SessionScoped
public class BeanCurso implements Serializable{
	private static final long serialVersionUID = 920074389311801987L;

	@ManagedProperty("#{cursoServicio}")
	private CursoServicio cursoServicio;

	private Curso addCurso;
	private List<Curso> listadoCursos;

    private static Curso selectedCurso;
    public Curso getSelectedCurso() {
        return selectedCurso;
    }
    public void setSelectedCurso(Curso selectedCurso) {
        this.selectedCurso = selectedCurso;
    }

    private List<Curso> selectedCursos;

    public List<Curso> getSelectedCursos() {
        return selectedCursos;
    }

    public void setSelectedCursos(List<Curso> selectedCursos) {
        this.selectedCursos = selectedCursos;
    }

    private Curso curso;

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    private List<Curso> filteredCursos;

    public List<Curso> getFilteredCursos() {
        return filteredCursos;
    }

    public void setFilteredCursos(List<Curso> filteredCursos) {
        this.filteredCursos = filteredCursos;
    }

    @PostConstruct
	public void init(){
		listadoCursos=cursoServicio.consultarTodos();
        addCurso= new Curso();
        selectedCursos = listadoCursos;
        //cursoServicio.update4();
	}

    public void update(ActionEvent actionEvent){
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Se ha actualizado información en",  "Curso: " + selectedCurso.getTitulo()) );
        cursoServicio.update(selectedCurso);
        init();
    }

    public void delete(ActionEvent actionEvent){
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Se ha eliminado",  "Curso: " + selectedCurso.getTitulo()) );
        cursoServicio.delete(selectedCurso);
        init();

    }

    public void buttonAction(ActionEvent actionEvent) {
        //action even actualiza el form
        addMessage("Welcome to Primefaces!!");
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	public void setCursoServicio(CursoServicio cursoServicio) {
		this.cursoServicio = cursoServicio;
	}

	public void setListadoCursos(List<Curso> listadoCursos) {
		this.listadoCursos = listadoCursos;
	}

	public void setAddCurso(Curso addCurso) {
		this.addCurso = addCurso;
	}

	public CursoServicio getCursoServicio() {
		return cursoServicio;
	}

	public Curso getAddCurso() {
		return addCurso;
	}

	public List<Curso> getListadoCursos() {
		return listadoCursos;
	}

	public void insertarCurso(){
		FacesContext context = FacesContext.getCurrentInstance();
		//context.addMessage(null, new FacesMessage("Se ha agregado exitosamente: (" + addCurso.getTitulo()+")"));
        context.addMessage(null, new FacesMessage("Agregado exitosamente",  "Curso: " + addCurso.getTitulo()) );
        cursoServicio.insert(addCurso);
        init();
	}

    public void onRowEdit(RowEditEvent event){
        FacesMessage msg = new FacesMessage("Car Edited");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public void onRowCancel(RowEditEvent event){
        FacesMessage msg = new FacesMessage("Edit Cancelled");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
}
