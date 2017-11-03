package org.demo.persistence.services;

import org.demo.persistence.services.jpa.ArticlePersistenceJPA;
import org.demo.persistence.services.jpa.PanieritemPersistenceJPA;
import org.demo.persistence.services.jpa.StockPersistenceJPA;
import org.demo.persistence.services.jpa.UtilisateurPersistenceJPA;

public abstract class  PersistenceManager {
	
	public static final UtilisateurPersistence Utilisateurs =
			new UtilisateurPersistenceJPA();
	
	public static final ArticlePersistence Articles =
			new ArticlePersistenceJPA();
	
	public static final StockPersistence Stock =
			new StockPersistenceJPA();
	
	public static final PanieritemPersistence PanierItems =
			new PanieritemPersistenceJPA();

}
