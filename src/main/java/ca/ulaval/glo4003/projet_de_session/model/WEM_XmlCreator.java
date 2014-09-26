package ca.ulaval.glo4003.projet_de_session.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class WEM_XmlCreator {

	public Enregistreur	enregistreur = null;
	
	
	
	protected WEM_XmlCreator(){
		this.enregistreur = new Enregistreur();
	}
	
	
	
	public Enregistreur getEnregistreur() {
		return enregistreur;
	}

	public void setEnregistreur(Enregistreur enregistreur) {
		this.enregistreur = enregistreur;
	}

	
	public void SaveNew(File file) throws FileNotFoundException{
		DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();  
			   
		try {
			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
			
			Document document = documentBuilder.newDocument();  
			
			Element rootElement = document.createElement("CalendrierTemps");  
			document.appendChild(rootElement);  
			
			Element enregistreurElement = document.createElement("utilisateur");  
			rootElement.appendChild(enregistreurElement); 
			
			List<WEM_Utilisateur> utilisateur = this.enregistreur.getUtilisateur();
			for(WEM_Utilisateur u : utilisateur){
				Element utilisateurElement = createUtilisateurElement(document, u);
				enregistreurElement.appendChild(utilisateurElement);
			}
			
			List<WEM_Projet> projet = this.enregistreur.getProjet();
			for(WEM_Projet p : projet){
				Element projetElement = createProjetElement(document, p);
				enregistreurElement.appendChild(projetElement);
			}
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();  
			Transformer transformer = transformerFactory.newTransformer();
			
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

		    DOMSource domSource = new DOMSource(document);  
			StreamResult streamResult = new StreamResult(file);  
			
			transformer.transform(domSource, streamResult);
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		} 		
	}
	
	private Element createUtilisateurElement(Document document, WEM_Utilisateur u) {
		Element utilisateurElement = document.createElement("utilisateur");
		
		Attr attribute = document.createAttribute("utilisateurType");  
	    attribute.setValue(u.getClass().getName());  
	    utilisateurElement.setAttributeNode(attribute);
	    
	    Element uidElement = document.createElement("uid");  
		uidElement.appendChild(document.createTextNode((u.getUid()).toString()));  
		utilisateurElement.appendChild(uidElement);  
	    
	    Element IdElement = document.createElement("id");
		IdElement.appendChild(document.createTextNode((u.getId()).toString()));  
		utilisateurElement.appendChild(IdElement);
		
		Element IdulElement = document.createElement("idul");
		IdulElement.appendChild(document.createTextNode((u.getIdul()).toString()));  
		utilisateurElement.appendChild(IdulElement);
		
		Element MotDePasseElement = document.createElement("motdepasse");
		MotDePasseElement.appendChild(document.createTextNode((u.getMotdepasse()).toString()));  
		utilisateurElement.appendChild(MotDePasseElement);
		
		Element prenomElement = document.createElement("prenom");  
		prenomElement.appendChild(document.createTextNode(u.getFirtname()));  
		utilisateurElement.appendChild(prenomElement); 
		
		Element nomElement = document.createElement("nom");  
		nomElement.appendChild(document.createTextNode(u.getLastname()));  
		utilisateurElement.appendChild(nomElement);
		
		Element tacheElement = document.createElement("tache");  
		tacheElement.appendChild(document.createTextNode(u.getTache()));  
		utilisateurElement.appendChild(tacheElement);
		
		Element salaireElement = document.createElement("salaire");  
		salaireElement.appendChild(document.createTextNode(Float.toString(u.getSalaire())));  
		utilisateurElement.appendChild(salaireElement);
		
		Element coutElement = document.createElement("cout");  
		coutElement.appendChild(document.createTextNode(Float.toHexString(u.getCost())));  
		utilisateurElement.appendChild(coutElement);
		
		Element millageElement = document.createElement("millage");  
		millageElement.appendChild(document.createTextNode(Float.toString(u.getMillage())));
		utilisateurElement.appendChild(millageElement);
		
		return utilisateurElement; 
	}
	private Element createProjetElement(Document document, WEM_Projet p) {
		Element projetElement = document.createElement("projet");
		
		Attr attribute = document.createAttribute("projetType");  
	    attribute.setValue(p.getClass().getName());  
	    projetElement.setAttributeNode(attribute);
	    
	    Element uidPElement = document.createElement("uidP");  
		uidPElement.appendChild(document.createTextNode((p.getUidP()).toString()));  
		projetElement.appendChild(uidPElement);  
	    
	    Element IdElement = document.createElement("id");
		IdElement.appendChild(document.createTextNode((p.getIdProjet()).toString()));  
		projetElement.appendChild(IdElement);
		
		Element IdUtilisateurElement = document.createElement("idUtilisateur");
		IdUtilisateurElement.appendChild(document.createTextNode((p.getIdUtilisateur()).toString()));  
		projetElement.appendChild(IdUtilisateurElement);
		
		Element nomProjetElement = document.createElement("nomProjet");  
		nomProjetElement.appendChild(document.createTextNode(p.getNomProjet()));  
		projetElement.appendChild(nomProjetElement); 
		
		Element dateEcheanceElement = document.createElement("dateEcheanceProjet");  
		dateEcheanceElement.appendChild(document.createTextNode((p.getDateEcheance()).toString()));  
		projetElement.appendChild(dateEcheanceElement);
		
		Element coutProjetElement = document.createElement("coutProjet");  
		coutProjetElement.appendChild(document.createTextNode(Float.toString(p.getCoutProjet())));  
		projetElement.appendChild(coutProjetElement); 
	    
		return projetElement;
		
	}
}
