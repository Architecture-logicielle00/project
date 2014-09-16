package ca.ulaval.glo4003.projet_de_session.model;


import java.io.Serializable;
import java.util.Observable;


public abstract class User extends Observable implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	private Integer id;

	@SuppressWarnings("unused")
	private String name;
}