/*
 * Created on 31 oct. 2017 ( Time 18:39:50 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.persistence.services.fake;

import java.util.List;
import java.util.Map;

import org.demo.bean.jpa.DatereservationEntity;
import org.demo.persistence.commons.fake.GenericFakeService;
import org.demo.persistence.services.DatereservationPersistence;

/**
 * Fake persistence service implementation ( entity "Datereservation" )
 *
 * @author Telosys Tools Generator
 */
public class DatereservationPersistenceFAKE extends GenericFakeService<DatereservationEntity> implements DatereservationPersistence {

	public DatereservationPersistenceFAKE () {
		super(DatereservationEntity.class);
	}
	
	protected DatereservationEntity buildEntity(int index) {
		DatereservationEntity entity = new DatereservationEntity();
		// Init fields with mock values
		entity.setId( nextInteger() ) ;
		entity.setDebut( nextDate() ) ;
		entity.setFin( nextDate() ) ;
		return entity ;
	}
	
	
	public boolean delete(DatereservationEntity entity) {
		log("delete ( DatereservationEntity : " + entity + ")" ) ;
		return true;
	}

	public boolean delete( Integer id ) {
		log("delete ( PK )") ;
		return true;
	}

	public void insert(DatereservationEntity entity) {
		log("insert ( DatereservationEntity : " + entity + ")" ) ;
	}

	public DatereservationEntity load( Integer id ) {
		log("load ( PK )") ;
		return buildEntity(1) ; 
	}

	public List<DatereservationEntity> loadAll() {
		log("loadAll()") ;
		return buildList(40) ;
	}

	public List<DatereservationEntity> loadByNamedQuery(String queryName) {
		log("loadByNamedQuery ( '" + queryName + "' )") ;
		return buildList(20) ;
	}

	public List<DatereservationEntity> loadByNamedQuery(String queryName, Map<String, Object> queryParameters) {
		log("loadByNamedQuery ( '" + queryName + "', parameters )") ;
		return buildList(10) ;
	}

	public DatereservationEntity save(DatereservationEntity entity) {
		log("insert ( DatereservationEntity : " + entity + ")" ) ;
		return entity;
	}

	public List<DatereservationEntity> search(Map<String, Object> criteria) {
		log("search (criteria)" ) ;
		return buildList(15) ;
	}

	@Override
	public long countAll() {
		return 0 ;
	}

}