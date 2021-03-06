
/*
 * Created on 3 nov. 2017 ( Time 10:21:00 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.mock;

import java.util.LinkedList;
import java.util.List;

import org.demo.bean.jpa.UtilisateurEntity;
import org.demo.mock.tool.MockValues;

public class UtilisateurEntityMock {

	private MockValues mockValues = new MockValues();
	
	/**
	 * Creates an instance with random Primary Key
	 * @return
	 */
	public UtilisateurEntity createInstance() {
		// Primary Key values

		return createInstance( mockValues.nextInteger() );
	}
	
	/**
	 * Creates an instance with a specific Primary Key
	 * @param id1
	 * @return
	 */
	public UtilisateurEntity createInstance( Integer id ) {
		UtilisateurEntity entity = new UtilisateurEntity();
		// Init Primary Key fields
		entity.setId( id) ;
		// Init Data fields
		entity.setLogin( mockValues.nextString(20) ) ; // java.lang.String 
		entity.setPwd( mockValues.nextString(20) ) ; // java.lang.String 
		entity.setNom( mockValues.nextString(20) ) ; // java.lang.String 
		entity.setPrenom( mockValues.nextString(20) ) ; // java.lang.String 
		entity.setAdresse( mockValues.nextString(256) ) ; // java.lang.String 
		entity.setCodepostal( mockValues.nextInteger() ) ; // java.lang.Integer 
		entity.setVille( mockValues.nextString(30) ) ; // java.lang.String 
		entity.setPays( mockValues.nextString(30) ) ; // java.lang.String 
		// Init Link fields (if any)
		// setListOfPanieritem( TODO ) ; // List<Panieritem> 
		return entity ;
	}
	
	/**
	 * Creates a list of instances
	 * @param count number of instances to be created
	 * @return
	 */
	public List<UtilisateurEntity> createList(int count) {
		List<UtilisateurEntity> list = new LinkedList<UtilisateurEntity>();		
		for ( int i = 1 ; i <= count ; i++ ) {
			list.add( createInstance() );
		}
		return list;
	}
}
