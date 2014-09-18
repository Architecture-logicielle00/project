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

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlCreator {

	public Enregistreur	enregistreur = null;
	
	
	
	protected XmlCreator(){
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
			
			List<Utilisateur> utilisateur = this.enregistreur.getUtilisateur();
			for(Utilisateur u : utilisateur){
				Element utilisateurElement = createUtilisateurElement(document, u);
				enregistreurElement.appendChild(utilisateurElement);
			}
			
			List<Projet> projet = this.enregistreur.getProjet();
			for(Projet p : projet){
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
	
	private Element createUtilisateurElement(Document document, Utilisateur u) {
		Element utilisateurElement = document.createElement("utilisateur");
		/*
		 // TO DO
		 * 
		 * 
		 */
		return utilisateurElement; 
	}
	private Element createProjetElement(Document document, Projet p) {
		Element projetElement = document.createElement("projet");
		/*
		 * TO DO
		 * 
		 */
		return projetElement;
		
	}
}
