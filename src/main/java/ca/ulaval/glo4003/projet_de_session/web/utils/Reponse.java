package ca.ulaval.glo4003.projet_de_session.web.utils;

public class Reponse {
	public String url;
	public String message;
	public boolean statut;
	
	public Reponse(boolean _statut, String _message, String _url)
	{
		url = _url;
		message = _message;
		statut = _statut;
	}
}
