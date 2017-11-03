/*
 * Created on 3 nov. 2017 ( Time 10:20:59 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.persistence.services.jpa;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.demo.bean.jpa.StockEntity;
import org.demo.persistence.commons.jpa.GenericJpaService;
import org.demo.persistence.commons.jpa.JpaOperation;
import org.demo.persistence.services.StockPersistence;

/**
 * JPA implementation for basic persistence operations ( entity "Stock" )
 * 
 * @author Telosys Tools Generator
 *
 */
public class StockPersistenceJPA extends GenericJpaService<StockEntity, Integer> implements StockPersistence {
	
	public static final StockPersistenceJPA instance = new StockPersistenceJPA();

	/**
	 * Constructor
	 */
	public StockPersistenceJPA() {
		super(StockEntity.class);
	}

	@Override
	public StockEntity load( Integer articleref ) {
		return super.load( articleref );
	}

	@Override
	public boolean delete( Integer articleref ) {
		return super.delete( articleref );
	}

	@Override
	public boolean delete(StockEntity entity) {
		if ( entity != null ) {
			return super.delete( entity.getArticleref() );
		}
		return false ;
	}

	@Override
	public long countAll() {
		// JPA operation definition 
		JpaOperation operation = new JpaOperation() {
			@Override
			public Object exectue(EntityManager em) throws PersistenceException {
				Query query = em.createNamedQuery("StockEntity.countAll");
				return query.getSingleResult() ;
			}
		} ;
		// JPA operation execution 
		return (Long) execute(operation);
	}

}
