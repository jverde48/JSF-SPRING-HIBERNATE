package mx.sintelti.spring.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.sintelti.spring.dao.PersonaDAO;
import mx.sintelti.spring.dto.DireccionDTO;
import mx.sintelti.spring.dto.PersonaDTO;
import mx.sintelti.spring.entity.Direccion;
import mx.sintelti.spring.entity.Persona;
import mx.sintelti.spring.service.PersonaService;

@Service("personaService")
public class PersonaServiceImpl implements PersonaService, Serializable {

	@Autowired
	private PersonaDAO personaDAO;
	
	//@Autowired
	//private Direccion direccion;
	
	private static final long serialVersionUID = 1L;	

	@Override
	public boolean guardarRegistro(PersonaDTO personaDTO) {
		boolean resultado = false;
		
		try {	
			if (personaDAO.guardarRegistro(mapearEntity(personaDTO)) != null) 
				resultado = true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return resultado;
	}
	
	@Override
	public List<PersonaDTO> listaPersonas() {
		List<PersonaDTO> listaPersonas = null;
		
		try {
			listaPersonas = new ArrayList<PersonaDTO>();
			for (Persona persona : personaDAO.listarRegistros()){
				System.out.println(persona.getNombre());
				DireccionDTO direccionDTO = new DireccionDTO();
				PersonaDTO personaDTO = new PersonaDTO();
				personaDTO.setContrasenia(persona.getContrasenia());
				personaDTO.setCorreoElectronico(persona.getCorreoElectronico());
				personaDTO.setEdad(persona.getEdad());
				personaDTO.setFechaNacimiento(persona.getFechaNacimiento());
				personaDTO.setNombre(persona.getNombre());
				personaDTO.setPrimerApellido(persona.getPrimerApellido());
				personaDTO.setSegundoApellido(persona.getSegundoApellido());
				personaDTO.setUsuario(persona.getUsuario());
				
				direccionDTO.setCalle(persona.getDireccion().getCalle());
				direccionDTO.setCodigoPostal(persona.getDireccion().getCodigoPostal());
				direccionDTO.setEstado(persona.getDireccion().getEstado());
				direccionDTO.setMunicipio(persona.getDireccion().getMunicipio());
				direccionDTO.setNumeroExterior(persona.getDireccion().getNumeroExterior());
				direccionDTO.setNumeroInterior(persona.getDireccion().getNumeroInterior());
				direccionDTO.setPais(persona.getDireccion().getPais());
				
				personaDTO.setDireccion(direccionDTO);
				
				listaPersonas.add(personaDTO);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaPersonas;
	}

	public PersonaDAO getPersonaDAO() {
		return personaDAO;
	}

	public void setPersonaDAO(PersonaDAO personaDAO) {
		this.personaDAO = personaDAO;
	}
	
	/*public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}*/

	private Persona mapearEntity(PersonaDTO personaDTO) {
		Direccion direccion = new Direccion();
		Persona persona = new Persona();
		
		direccion.setCalle(personaDTO.getDireccion().getCalle());
		direccion.setCodigoPostal(personaDTO.getDireccion().getCodigoPostal());
		direccion.setNumeroExterior(personaDTO.getDireccion().getNumeroExterior());
		direccion.setNumeroInterior(personaDTO.getDireccion().getNumeroInterior());
		direccion.setPais(personaDTO.getDireccion().getPais());
		direccion.setEstado(personaDTO.getDireccion().getEstado());
		direccion.setMunicipio(personaDTO.getDireccion().getMunicipio());
		
		persona.setNombre(personaDTO.getNombre());
		persona.setPrimerApellido(personaDTO.getPrimerApellido());
		persona.setSegundoApellido(personaDTO.getSegundoApellido());
		persona.setDireccion(direccion);
		persona.setFechaNacimiento(personaDTO.getFechaNacimiento());
		persona.setEdad(personaDTO.getEdad());
		persona.setUsuario(personaDTO.getUsuario());
		persona.setContrasenia(personaDTO.getContrasenia());
		persona.setCorreoElectronico(personaDTO.getCorreoElectronico());
		
		return persona;
	}
}
