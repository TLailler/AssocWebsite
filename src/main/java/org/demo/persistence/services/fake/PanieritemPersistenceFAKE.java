/*
 * Created on 3 nov. 2017 ( Time 10:20:59 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.persistence.services.fake;

import java.util.List;
import java.util.Map;

import org.demo.bean.jpa.PanieritemEntity;
import org.demo.persistence.commons.fake.GenericFakeService;
import org.demo.persistence.services.PanieritemPersistence;

/**
 * Fake persistence service implementation ( entity "Panieritem" )
 *
 * @author Telosys Tools Generator
 */
public class PanieritemPersistenceFAKE extends GenericFakeService<PanieritemEntity> implements PanieritemPersistence {

	public PanieritemPersistenceFAKE () {
		super(PanieritemEntity.class);
	}
	
	protected PanieritemEntity buildEntity(int index) {
		PanieritemEntity entity = new PanieritemEntity();
		// Init fields with mock values
		entity.setId( nextInteger() ) ;
		entity.setQte( nextInteger() ) ;
		return entity ;
	}
	
	
	public boolean delete(PanieritemEntity entity) {
		log("delete ( PanieritemEntity : " + entity + ")" ) ;
		return true;
	}

	public boolean delete( Integer id ) {
		log("delete ( PK )") ;
		return true;
	}

	public void insert(PanieritemEntity entity) {
		log("insert ( PanieritemEntity : " + entity + ")" ) ;
	}

	public PanieritemEntity load( Integer id ) {
		log("load ( PK )") ;
		return buildEntity(1) ; 
	}

	public List<PanieritemEntity> loadAll() {
		log("loadAll()") ;
		return buildList(40) ;
	}

	public List<PanieritemEntity> loadByNamedQuery(String queryName) {
		log("loadByNamedQuery ( '" + queryName + "' )") ;
		return buildList(20) ;
	}

	public List<PanieritemEntity> loadByNamedQuery(String queryName, Map<String, Object> queryParameters) {
		log("loadByNamedQuery ( '" + queryName + "', parameters )") ;
		return buildList(10) ;
	}

	public PanieritemEntity save(PanieritemEntity entity) {
		log("insert ( PanieritemEntity : " + entity + ")" ) ;
		return entity;
	}

	public List<PanieritemEntity> search(Map<String, Object> criteria) {
		log("search (criteria)" ) ;
		return buildList(15) ;
	}

	@Override
	public long countAll() {
		return 0 ;
	}

}
