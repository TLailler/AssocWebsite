/*
 * Created on 3 nov. 2017 ( Time 10:21:00 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package org.demo.bean.jpa;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.List;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "UTILISATEUR"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="UTILISATEUR", schema="ROOT" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="UtilisateurEntity.countAll", query="SELECT COUNT(x) FROM UtilisateurEntity x" ),
  @NamedQuery ( name="UtilisateurEntity.login", query="SELECT u FROM UtilisateurEntity u WHERE u.login=:login AND u.pwd=:pwd"),
  @NamedQuery ( name="UtilisateurEntity.checkLogin", query="SELECT u FROM UtilisateurEntity u WHERE u.login=:login")
} )
public class UtilisateurEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", nullable=false)
    private Integer    id           ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="LOGIN", length=20)
    private String     login        ;

    @Column(name="PWD", length=20)
    private String     pwd          ;

    @Column(name="NOM", length=20)
    private String     nom          ;

    @Column(name="PRENOM", length=20)
    private String     prenom       ;

    @Column(name="ADRESSE", length=256)
    private String     adresse      ;

    @Column(name="CODEPOSTAL")
    private Integer    codepostal   ;

    @Column(name="VILLE", length=30)
    private String     ville        ;

    @Column(name="PAYS", length=30)
    private String     pays         ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @OneToMany(mappedBy="utilisateur", targetEntity=PanieritemEntity.class)
    private List<PanieritemEntity> listOfPanieritem;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public UtilisateurEntity() {
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
    //--- DATABASE MAPPING : LOGIN ( VARCHAR ) 
    public void setLogin( String login ) {
        this.login = login;
    }
    public String getLogin() {
        return this.login;
    }

    //--- DATABASE MAPPING : PWD ( VARCHAR ) 
    public void setPwd( String pwd ) {
        this.pwd = pwd;
    }
    public String getPwd() {
        return this.pwd;
    }

    //--- DATABASE MAPPING : NOM ( VARCHAR ) 
    public void setNom( String nom ) {
        this.nom = nom;
    }
    public String getNom() {
        return this.nom;
    }

    //--- DATABASE MAPPING : PRENOM ( VARCHAR ) 
    public void setPrenom( String prenom ) {
        this.prenom = prenom;
    }
    public String getPrenom() {
        return this.prenom;
    }

    //--- DATABASE MAPPING : ADRESSE ( VARCHAR ) 
    public void setAdresse( String adresse ) {
        this.adresse = adresse;
    }
    public String getAdresse() {
        return this.adresse;
    }

    //--- DATABASE MAPPING : CODEPOSTAL ( INTEGER ) 
    public void setCodepostal( Integer codepostal ) {
        this.codepostal = codepostal;
    }
    public Integer getCodepostal() {
        return this.codepostal;
    }

    //--- DATABASE MAPPING : VILLE ( VARCHAR ) 
    public void setVille( String ville ) {
        this.ville = ville;
    }
    public String getVille() {
        return this.ville;
    }

    //--- DATABASE MAPPING : PAYS ( VARCHAR ) 
    public void setPays( String pays ) {
        this.pays = pays;
    }
    public String getPays() {
        return this.pays;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setListOfPanieritem( List<PanieritemEntity> listOfPanieritem ) {
        this.listOfPanieritem = listOfPanieritem;
    }
    public List<PanieritemEntity> getListOfPanieritem() {
        return this.listOfPanieritem;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
        sb.append(login);
        sb.append("|");
        sb.append(pwd);
        sb.append("|");
        sb.append(nom);
        sb.append("|");
        sb.append(prenom);
        sb.append("|");
        sb.append(adresse);
        sb.append("|");
        sb.append(codepostal);
        sb.append("|");
        sb.append(ville);
        sb.append("|");
        sb.append(pays);
        return sb.toString(); 
    } 

}
