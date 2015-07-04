package mx.sintelti.spring.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import mx.sintelti.spring.dto.PersonaDTO;
import mx.sintelti.spring.service.PersonaService;

@ViewScoped
@ManagedBean(name = "personaBean")
public class PersonaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<String> listaEstados;
	private List<String> listaPaises;
	private List<String> listaMunicipios;
	private List<PersonaDTO> listaPersonas;
	
	@PostConstruct
	public void iniciarValores() {
		if(listaPaises == null || listaPaises.isEmpty())
			listaPaises = getPaises();
		
		if(listaEstados == null || listaEstados.isEmpty())
			listaEstados = getEstados();
		
		if(listaMunicipios == null || listaMunicipios.isEmpty())
			listaMunicipios = getMunicipios();
		
		listaPersonas = personaService.listaPersonas();
		
	}
	
	@ManagedProperty(value="#{personaDTO}")
	private PersonaDTO personaDTO;
	
	@ManagedProperty(value="#{personaService}")
	private PersonaService personaService;
	
	public void guardarRegistro() {
		if (personaService.guardarRegistro(personaDTO)) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Info", "Registro guardado."));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Error", "Fallo el guardado"));
		}
	}
	
	public List<String> getListaEstados() {
		return listaEstados;
	}

	public void setListaEstados(List<String> listaEstados) {
		this.listaEstados = listaEstados;
	}

	public List<String> getListaPaises() {
		return listaPaises;
	}

	public void setListaPaises(List<String> listaPaises) {
		this.listaPaises = listaPaises;
	}

	public List<String> getListaMunicipios() {
		return listaMunicipios;
	}

	public void setListaMunicipios(List<String> listaMunicipios) {
		this.listaMunicipios = listaMunicipios;
	}

	public PersonaDTO getPersonaDTO() {
		return personaDTO;
	}

	public void setPersonaDTO(PersonaDTO personaDTO) {
		this.personaDTO = personaDTO;
	}
	
	public PersonaService getPersonaService() {
		return personaService;
	}

	public void setPersonaService(PersonaService personaService) {
		this.personaService = personaService;
	}
	
	public List<PersonaDTO> getListaPersonas() {
		return listaPersonas;
	}

	public void setListaPersonas(List<PersonaDTO> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}

	private List<String> getPaises() {
		List<String> listaPaises = new ArrayList<String>();
		listaPaises.add("Mexico");
		listaPaises.add("Panama");
		listaPaises.add("Guatemala");
		
		return listaPaises;
	}
	
	private List<String> getEstados() {
		List<String> listaEstados = new ArrayList<String>();
		listaEstados.add("Queretaro");
		listaEstados.add("Guanajuato");
		listaEstados.add("SL Potosi");
		
		return listaEstados;
	}
	
	private List<String> getMunicipios() {
		List<String> listaMunicipios = new ArrayList<String>();
		listaMunicipios.add("Corregidora");
		listaMunicipios.add("Apaseo el Alto");
		listaMunicipios.add("Tamasopo");
		
		return listaMunicipios;
	}
	
}
