package com.app.presentacion;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.app.integracion.model.Curso;
import com.app.integracion.model.Tema;
import com.app.negocio.tema.TemaServicio;
import com.app.negocio.tema.imp.TemaServicioImp;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;


@ManagedBean
@SessionScoped
public class BeanTema implements Serializable{

	private static final long serialVersionUID = 1L;

	@ManagedProperty("#{temaServicio}")
	private TemaServicioImp temaServicio;

	private List<Tema> listadoTemas;
	
	private Curso cursoSeleccionado;
	
	@PostConstruct
	public void init(){
		listadoTemas=new ArrayList<Tema>();
		setCursoSeleccionado(new Curso());
	}
	public TemaServicio getTemaServicio() {
		return temaServicio;
	}

	public void setTemaServicio(TemaServicioImp temaServicio) {
		this.temaServicio = temaServicio;
	}

	public List<Tema> getListadoTemas() {
		return listadoTemas;
	}

	public void setListadoTemas(List<Tema> listadoTemas) {
		this.listadoTemas = listadoTemas;
	}
	
	public List<Tema> consultarTemasCurso(int idCurso){
		return temaServicio.consultarTemasCurso(idCurso);
	}   

    public void createPDF() {
        try { 
            FacesContext context = FacesContext.getCurrentInstance();
            Document document = new Document();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PdfWriter.getInstance(document, baos);

            if (!document.isOpen()) {
                document.open();
            }
            
        	BaseFont base = BaseFont.createFont("c:/windows/fonts/arial.ttf", BaseFont.WINANSI, false);
        	Font font = new Font(base, 11f, Font.BOLD);

            document.add(new Phrase("Titulo: ", font));
            document.add(new Phrase(cursoSeleccionado.getTitulo()+"\n"));
            
            document.add(new Phrase("Nivel: ", font));
            document.add(new Phrase(cursoSeleccionado.getNivel()+"\n"));
      
            document.add(new Phrase("Horas: ",font));
            document.add(new Phrase(cursoSeleccionado.getHoras()+"\n"));
            
           
            PdfPTable pdfTable = exportPDFTable();
            document.add(pdfTable);

            document.close();
            String fileName = cursoSeleccionado.getTitulo();

            writePDFToResponse(context.getExternalContext(), baos, fileName);

            context.responseComplete();

        } catch (Exception e) {
            //e.printStackTrace();          
        }
    }
    
    private PdfPTable exportPDFTable() throws DocumentException, IOException {
		List<Tema> temario = consultarTemasCurso(cursoSeleccionado.getId());
		 
    	PdfPTable pdfTable = new PdfPTable(2);
    	BaseFont base = BaseFont.createFont("c:/windows/fonts/arial.ttf", BaseFont.WINANSI, false);
    	Font font = new Font(base, 11f, Font.BOLD);
		pdfTable.addCell(new Paragraph("N�", font));
		pdfTable.addCell(new Paragraph("Temario", font));
		
		
    	for(int i=0; i < temario.size(); i++){    		

    		pdfTable.addCell(i+1+"");
    		pdfTable.addCell(temario.get(i).getNombre()+"");
    	}

		pdfTable.setWidthPercentage(40f);
		pdfTable.setHorizontalAlignment(0);
        return pdfTable;
    }
    
    private void writePDFToResponse(ExternalContext externalContext, ByteArrayOutputStream baos, String fileName) {
        try {
            externalContext.responseReset();
            externalContext.setResponseContentType("application/pdf");
            externalContext.setResponseHeader("Expires", "0");
            externalContext.setResponseHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
            externalContext.setResponseHeader("Pragma", "public");
            externalContext.setResponseHeader("Content-disposition", "attachment;filename=" + fileName + ".pdf");
            externalContext.setResponseContentLength(baos.size());
            OutputStream out = externalContext.getResponseOutputStream();
            baos.writeTo(out);
            externalContext.responseFlushBuffer();
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
	public Curso getCursoSeleccionado() {
		return cursoSeleccionado;
	}
	public void setCursoSeleccionado(Curso cursoSeleccionado) {
		this.cursoSeleccionado = cursoSeleccionado;
	}




}
