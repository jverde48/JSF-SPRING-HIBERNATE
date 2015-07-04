package mx.sintelti.spring.service;

import java.util.List;

import mx.sintelti.spring.dto.PersonaDTO;

public interface PersonaService {
	boolean guardarRegistro(PersonaDTO personaDTO);
	List<PersonaDTO> listaPersonas();
}
