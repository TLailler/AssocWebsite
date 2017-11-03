/*
 * Created on 31 oct. 2017 ( Time 18:39:51 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.persistence.services;

import java.util.List;
import java.util.Map;

import org.demo.bean.jpa.TypeRessourceEntity;

/**
 * Basic persistence operations for entity "TypeRessource"
 * 
 * This Bean has a basic Primary Key : String
 *
 * @author Telosys Tools Generator
 *
 */
public interface TypeRessourcePersistence {

	/**
	 * Deletes the given entity <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param typeRessource
	 * @return true if found and deleted, false if not found
	 */
	public boolean delete(TypeRessourceEntity typeRessource) ;

	/**
	 * Deletes the entity by its Primary Key <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param type
	 * @return true if found and deleted, false if not found
	 */
	public boolean delete(String type) ;

	/**
	 * Inserts the given entity and commit <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param typeRessource
	 */
	public void insert(TypeRessourceEntity typeRessource) ;

	/**
	 * Loads the entity for the given Primary Key <br>
	 * @param type
	 * @return the entity loaded (or null if not found)
	 */
	public TypeRessourceEntity load(String type) ;

	/**
	 * Loads ALL the entities (use with caution)
	 * @return
	 */
	public List<TypeRessourceEntity> loadAll() ;

	/**
	 * Loads a list of entities using the given "named query" without parameter 
	 * @param queryName
	 * @return
	 */
	public List<TypeRessourceEntity> loadByNamedQuery(String queryName) ;

	/**
	 * Loads a list of entities using the given "named query" with parameters 
	 * @param queryName
	 * @param queryParameters
	 * @return
	 */
	public List<TypeRessourceEntity> loadByNamedQuery(String queryName, Map<String, Object> queryParameters) ;

	/**
	 * Saves (create or update) the given entity <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param typeRessource
	 * @return
	 */
	public TypeRessourceEntity save(TypeRessourceEntity typeRessource) ;

	/**
	 * Search the entities matching the given search criteria
	 * @param criteria
	 * @return
	 */
	public List<TypeRessourceEntity> search( Map<String, Object> criteria ) ;

	/**
	 * Count all the occurrences
	 * @return
	 */
	public long countAll();
	
}
