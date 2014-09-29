package ca.ulaval.glo4003.projet_de_session.persistence.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import ca.ulaval.glo4003.projet_de_session.core.domain.Employe;
import ca.ulaval.glo4003.projet_de_session.core.domain.Projet;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Serialisation {

	/**
	 * Serialize a list of user
	 * @param CollectionUtilisateur The object to be save in the XML file
	 * @param path Determine the path to save the user
	 */
	public static void enregistrerUtilisateurXML(List<Employe> CollectionUtilisateur, String path){
		
		try {
		    XStream xstream = new XStream(new DomDriver());
		    File file = new File(path+".xml");
		    FileOutputStream fos = new FileOutputStream(file);
		    try {
				xstream.alias("Employe", Employe.class);
			   	xstream.toXML(CollectionUtilisateur, fos);
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
	 * @param CollectionProjet The list of project to be save in the XML file
	 * @param path Determine the path to save the project
	 */
	public static void enregistrerProjetsXML(List<Projet> CollectionProjet, String path){
		
		try {
		    XStream xstream = new XStream(new DomDriver());
		    File file = new File(path+".xml");
		    FileOutputStream fos = new FileOutputStream(file,true);
		    try {
			   	xstream.toXML(CollectionProjet, fos);
		    } finally {
			fos.close();
		    }
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException ioe) {
		    ioe.printStackTrace();
		}
	}
}
