/*
 * Created on 3 nov. 2017 ( Time 10:20:59 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.persistence.services;

import java.util.List;
import java.util.Map;

import org.demo.bean.jpa.PanieritemEntity;

/**
 * Basic persistence operations for entity "Panieritem"
 * 
 * This Bean has a basic Primary Key : Integer
 *
 * @author Telosys Tools Generator
 *
 */
public interface PanieritemPersistence {

	/**
	 * Deletes the given entity <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param panieritem
	 * @return true if found and deleted, false if not found
	 */
	public boolean delete(PanieritemEntity panieritem) ;

	/**
	 * Deletes the entity by its Primary Key <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param id
	 * @return true if found and deleted, false if not found
	 */
	public boolean delete(Integer id) ;

	/**
	 * Inserts the given entity and commit <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param panieritem
	 */
	public void insert(PanieritemEntity panieritem) ;

	/**
	 * Loads the entity for the given Primary Key <br>
	 * @param id
	 * @return the entity loaded (or null if not found)
	 */
	public PanieritemEntity load(Integer id) ;

	/**
	 * Loads ALL the entities (use with caution)
	 * @return
	 */
	public List<PanieritemEntity> loadAll() ;

	/**
	 * Loads a list of entities using the given "named query" without parameter 
	 * @param queryName
	 * @return
	 */
	public List<PanieritemEntity> loadByNamedQuery(String queryName) ;

	/**
	 * Loads a list of entities using the given "named query" with parameters 
	 * @param queryName
	 * @param queryParameters
	 * @return
	 */
	public List<PanieritemEntity> loadByNamedQuery(String queryName, Map<String, Object> queryParameters) ;

	/**
	 * Saves (create or update) the given entity <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param panieritem
	 * @return
	 */
	public PanieritemEntity save(PanieritemEntity panieritem) ;

	/**
	 * Search the entities matching the given search criteria
	 * @param criteria
	 * @return
	 */
	public List<PanieritemEntity> search( Map<String, Object> criteria ) ;

	/**
	 * Count all the occurrences
	 * @return
	 */
	public long countAll();
	
	/**
	 * Recupere les items du panier d'un utilisateur
	 * @param userid
	 * @return
	 */
	public List<PanieritemEntity> getPanierFromUser(int userid);
	
	/**
	 * Vide le panier d'un utilisateur
	 */
	public void cleanPanier(int userid);
	
	/**
	 * Recupere un item du panier si il est present, retourne null sinon
	 * @param userid
	 * @param articleref
	 * @return
	 */
	public PanieritemEntity searchItemInPanier(int userid, int articleref);
}
