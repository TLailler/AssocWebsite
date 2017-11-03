/*
 * Created on 31 oct. 2017 ( Time 18:39:50 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package org.demo.bean.jpa;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.Date;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "DATERESERVATION"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="DATERESERVATION", schema="ROOT" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="DatereservationEntity.countAll", query="SELECT COUNT(x) FROM DatereservationEntity x" )
} )
public class DatereservationEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name="ID", nullable=false)
    private Integer    id           ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Temporal(TemporalType.DATE)
    @Column(name="DEBUT")
    private Date       debut        ;

    @Temporal(TemporalType.DATE)
    @Column(name="FIN")
    private Date       fin          ;

	// "ressource" (column "RESSOURCE") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="RESSOURCE", referencedColumnName="NSERIE")
    private RessourceEntity ressource2  ;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public DatereservationEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setId( Integer id ) {
        this.id = id ;
    }
    public Integer getId() {
        return this.id;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : DEBUT ( DATE ) 
    public void setDebut( Date debut ) {
        this.debut = debut;
    }
    public Date getDebut() {
        return this.debut;
    }

    //--- DATABASE MAPPING : FIN ( DATE ) 
    public void setFin( Date fin ) {
        this.fin = fin;
    }
    public Date getFin() {
        return this.fin;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setRessource2( RessourceEntity ressource2 ) {
        this.ressource2 = ressource2;
    }
    public RessourceEntity getRessource2() {
        return this.ressource2;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
        sb.append(debut);
        sb.append("|");
        sb.append(fin);
        return sb.toString(); 
    } 

}