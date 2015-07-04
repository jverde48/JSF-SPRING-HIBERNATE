package mx.sintelti.spring.dao.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import mx.sintelti.spring.dao.PersonaDAO;
import mx.sintelti.spring.entity.Persona;
import mx.sintelti.spring.util.impl.GenericDAOImpl;

@Repository
public class PersonaDAOImpl extends GenericDAOImpl<Persona> 
			implements PersonaDAO, Serializable {

	private static final long serialVersionUID = 1L;
	
}
