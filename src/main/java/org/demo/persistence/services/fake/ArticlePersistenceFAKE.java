/*
 * Created on 3 nov. 2017 ( Time 10:20:58 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.persistence.services.fake;

import java.util.List;
import java.util.Map;

import org.demo.bean.jpa.ArticleEntity;
import org.demo.persistence.commons.fake.GenericFakeService;
import org.demo.persistence.services.ArticlePersistence;

/**
 * Fake persistence service implementation ( entity "Article" )
 *
 * @author Telosys Tools Generator
 */
public class ArticlePersistenceFAKE extends GenericFakeService<ArticleEntity> implements ArticlePersistence {

	public ArticlePersistenceFAKE () {
		super(ArticleEntity.class);
	}
	
	protected ArticleEntity buildEntity(int index) {
		ArticleEntity entity = new ArticleEntity();
		// Init fields with mock values
		entity.setRef( nextInteger() ) ;
		entity.setNom( nextString() ) ;
		entity.setPrix( nextFloat() ) ;
		return entity ;
	}
	
	
	public boolean delete(ArticleEntity entity) {
		log("delete ( ArticleEntity : " + entity + ")" ) ;
		return true;
	}

	public boolean delete( Integer ref ) {
		log("delete ( PK )") ;
		return true;
	}

	public void insert(ArticleEntity entity) {
		log("insert ( ArticleEntity : " + entity + ")" ) ;
	}

	public ArticleEntity load( Integer ref ) {
		log("load ( PK )") ;
		return buildEntity(1) ; 
	}

	public List<ArticleEntity> loadAll() {
		log("loadAll()") ;
		return buildList(40) ;
	}

	public List<ArticleEntity> loadByNamedQuery(String queryName) {
		log("loadByNamedQuery ( '" + queryName + "' )") ;
		return buildList(20) ;
	}

	public List<ArticleEntity> loadByNamedQuery(String queryName, Map<String, Object> queryParameters) {
		log("loadByNamedQuery ( '" + queryName + "', parameters )") ;
		return buildList(10) ;
	}

	public ArticleEntity save(ArticleEntity entity) {
		log("insert ( ArticleEntity : " + entity + ")" ) ;
		return entity;
	}

	public List<ArticleEntity> search(Map<String, Object> criteria) {
		log("search (criteria)" ) ;
		return buildList(15) ;
	}

	@Override
	public long countAll() {
		return 0 ;
	}

}
