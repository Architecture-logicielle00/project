package ca.ulaval.glo4003.projet_de_session.persistence.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ca.ulaval.glo4003.projet_de_session.core.domain.Employe;
import ca.ulaval.glo4003.projet_de_session.core.domain.FeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.core.domain.Projet;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Xml {
	/**
	 * Serialize a list of user
	 * @param employes The object to be save in the XML file
	 * @param path Determine the path to save the user
	 */
	public void enregistrerEmployes(List<Employe> employes, String path){
		
		try {
		    XStream xstream = new XStream(new DomDriver());
		    File file = new File(path+".xml");
		    FileOutputStream fos = new FileOutputStream(file);
		    try {
				xstream.alias("Employe", Employe.class);
			   	xstream.toXML(employes, fos);
		    } finally {
			fos.close();
		    }
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException ioe) {
		    ioe.printStackTrace();
		}
	}

	/**
	 * Serialize a list of project
	 * @param projets The list of project to be save in the XML file
	 * @param path Determine the path to save the project
	 */
	public void enregistrerProjets(List<Projet> projets, String path){
		
		try {
		    XStream xstream = new XStream(new DomDriver());
		    File file = new File(path+".xml");
		    FileOutputStream fos = new FileOutputStream(file,true);
		    try {
			   	xstream.toXML(projets, fos);
		    } finally {
			fos.close();
		    }
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException ioe) {
		    ioe.printStackTrace();
		}
	}
	
	/**
	 * Serialize a list of time sheet
	 * @param feuillesDeTemps The list of time sheet to be save in the XML file
	 * @param path Determine the path to save the time sheet
	 */
	public void enregistrerFeuilleDeTemps(List<FeuilleDeTemps> feuillesDeTemps, String path){
		
		try {
		    XStream xstream = new XStream(new DomDriver());
		    File file = new File(path+".xml");
		    FileOutputStream fos = new FileOutputStream(file,true);
		    try {
				xstream.alias("FeuilleDeTemps", FeuilleDeTemps.class);
			   	xstream.toXML(feuillesDeTemps, fos);
		    } finally {
			fos.close();
		    }
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException ioe) {
		    ioe.printStackTrace();
		}
	}
	
	/**
	 * Get the list of employees from a XML file 
	 * @return Returns a list of employees
	 */
	@SuppressWarnings("unchecked")
	public List<Employe> chargerEmployes(String path){
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
	@SuppressWarnings("unchecked")
	public List<Projet> chargerProjets(String path){
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
	
	/**
	 * Get the list of projects from a XML file
	 * @return Returns a list of projects
	 */
	@SuppressWarnings("unchecked")
	public List<FeuilleDeTemps> chargerFeuilleDeTemps(String path){
		List<FeuilleDeTemps> feuillesDeTemps  = new ArrayList<FeuilleDeTemps>();
		 try {
	         XStream xstream = new XStream(new DomDriver());
	         FileInputStream fis = new FileInputStream(new File(path+".xml"));
	
	         try {
	        	 xstream.alias("FeuilleDeTemps", FeuilleDeTemps.class);
	        	 feuillesDeTemps = (List<FeuilleDeTemps>) xstream.fromXML(fis);
	         } finally {
	             fis.close();
	         }
	     } catch (FileNotFoundException e) {
	         e.printStackTrace();
	     } catch (IOException ioe) {
	         ioe.printStackTrace();
	     }
	 
	return feuillesDeTemps;
	}
}

