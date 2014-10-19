package ca.ulaval.glo4003.projet_de_session.persistence.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Xml<T> {
	
	private Class<T> type;
	
	public Xml(Class<T> type) {
	      this.type = type;
	    }
	
	public void enregistrer(List<T> listes, String path){
		try {
		    XStream xstream = new XStream(new DomDriver("UTF-8"));
		    File file = new File(path+".xml");
		    FileOutputStream fos = new FileOutputStream(file);
		    try {
				xstream.alias(type.getSimpleName(), type);
			   	xstream.toXML(listes, fos);
		    } finally {
			fos.close();
		    }
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException ioe) {
		    ioe.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<T> charger(String path){
		List<T> listes  = new ArrayList<T>();
		 try {
	         XStream xstream = new XStream(new DomDriver("UTF-8"));
	         FileInputStream fis = new FileInputStream(new File(path+".xml"));
	
	         try {
	        	 xstream.alias(type.getSimpleName(), type);
	        	 listes = (List<T>) xstream.fromXML(fis);
	         } finally {
	             fis.close();
	         }
	     } catch (FileNotFoundException e) {
	         e.printStackTrace();
	     } catch (IOException ioe) {
	         ioe.printStackTrace();
	     }
	 
		 return listes;
	}
}

