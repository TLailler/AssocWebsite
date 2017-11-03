/*
 * Created on 31 oct. 2017 ( Time 18:39:51 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.persistence.services.jpa;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.demo.bean.jpa.RessourceEntity;
import org.demo.persistence.commons.jpa.GenericJpaService;
import org.demo.persistence.commons.jpa.JpaOperation;
import org.demo.persistence.services.RessourcePersistence;

/**
 * JPA implementation for basic persistence operations ( entity "Ressource" )
 * 
 * @author Telosys Tools Generator
 *
 */
public class RessourcePersistenceJPA extends GenericJpaService<RessourceEntity, Integer> implements RessourcePersistence {

	/**
	 * Constructor
	 */
	public RessourcePersistenceJPA() {
		super(RessourceEntity.class);
	}

	@Override
	public RessourceEntity load( Integer nserie ) {
		return super.load( nserie );
	}

	@Override
	public boolean delete( Integer nserie ) {
		return super.delete( nserie );
	}

	@Override
	public boolean delete(RessourceEntity entity) {
		if ( entity != null ) {
			return super.delete( entity.getNserie() );
		}
		return false ;
	}

	@Override
	public long countAll() {
		// JPA operation definition 
		JpaOperation operation = new JpaOperation() {
			@Override
			public Object exectue(EntityManager em) throws PersistenceException {
				Query query = em.createNamedQuery("RessourceEntity.countAll");
				return query.getSingleResult() ;
			}
		} ;
		// JPA operation execution 
		return (Long) execute(operation);
	}

}
