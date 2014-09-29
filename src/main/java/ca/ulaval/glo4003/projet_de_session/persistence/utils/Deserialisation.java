package ca.ulaval.glo4003.projet_de_session.persistence.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ca.ulaval.glo4003.projet_de_session.core.domain.Employe;
import ca.ulaval.glo4003.projet_de_session.core.domain.Projet;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Deserialisation {

	/**
	 * Get the list of employees from a XML file 
	 * @return Returns a list of employees
	 */
	public static List<Employe> chargerEmployeXML(String path){
		List<Employe> UtilisateursToDeserialize  = new ArrayList<Employe>();
		 try {
	         XStream xstream = new XStream(new DomDriver());
	         FileInputStream fis = new FileInputStream(new File(path+".xml"));
	         try {
	        	 
	        	 xstream.alias("Employe", Employe.class);
	        	 UtilisateursToDeserialize =  (List<Employe>) xstream.fromXML(fis);
	         } finally {
	             fis.close();
	         }
	     } catch (FileNotFoundException e) {
	         e.printStackTrace();
	     } catch (IOException ioe) {
	         ioe.printStackTrace();
	     }
	 
	return UtilisateursToDeserialize;
	}
	
	
	/**
	 * Get the list of projects from a XML file
	 * @return Returns a list of projects
	 */
	public static List<Projet> chargerProjetsXML(String path){
		List<Projet> ProjetsToDeserialize  = new ArrayList<Projet>();
		 try {
	         XStream xstream = new XStream(new DomDriver());
	         FileInputStream fis = new FileInputStream(new File(path+".xml"));
	
	         try {
	        	 ProjetsToDeserialize = (List<Projet>) xstream.fromXML(fis);
	         } finally {
	             fis.close();
	         }
	     } catch (FileNotFoundException e) {
	         e.printStackTrace();
	     } catch (IOException ioe) {
	         ioe.printStackTrace();
	     }
	 
	return ProjetsToDeserialize;
	}
	
	 
}
