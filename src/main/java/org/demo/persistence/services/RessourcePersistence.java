/*
 * Created on 31 oct. 2017 ( Time 18:39:51 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.persistence.services;

import java.util.List;
import java.util.Map;

import org.demo.bean.jpa.RessourceEntity;

/**
 * Basic persistence operations for entity "Ressource"
 * 
 * This Bean has a basic Primary Key : Integer
 *
 * @author Telosys Tools Generator
 *
 */
public interface RessourcePersistence {

	/**
	 * Deletes the given entity <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param ressource
	 * @return true if found and deleted, false if not found
	 */
	public boolean delete(RessourceEntity ressource) ;

	/**
	 * Deletes the entity by its Primary Key <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param nserie
	 * @return true if found and deleted, false if not found
	 */
	public boolean delete(Integer nserie) ;

	/**
	 * Inserts the given entity and commit <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param ressource
	 */
	public void insert(RessourceEntity ressource) ;

	/**
	 * Loads the entity for the given Primary Key <br>
	 * @param nserie
	 * @return the entity loaded (or null if not found)
	 */
	public RessourceEntity load(Integer nserie) ;

	/**
	 * Loads ALL the entities (use with caution)
	 * @return
	 */
	public List<RessourceEntity> loadAll() ;

	/**
	 * Loads a list of entities using the given "named query" without parameter 
	 * @param queryName
	 * @return
	 */
	public List<RessourceEntity> loadByNamedQuery(String queryName) ;

	/**
	 * Loads a list of entities using the given "named query" with parameters 
	 * @param queryName
	 * @param queryParameters
	 * @return
	 */
	public List<RessourceEntity> loadByNamedQuery(String queryName, Map<String, Object> queryParameters) ;

	/**
	 * Saves (create or update) the given entity <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param ressource
	 * @return
	 */
	public RessourceEntity save(RessourceEntity ressource) ;

	/**
	 * Search the entities matching the given search criteria
	 * @param criteria
	 * @return
	 */
	public List<RessourceEntity> search( Map<String, Object> criteria ) ;

	/**
	 * Count all the occurrences
	 * @return
	 */
	public long countAll();
	
}
