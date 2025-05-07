package com.first.atfp.entities;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Medicament {
	
@Id
@GeneratedValue
private long id;
private String nom;
private int quantite;
private long prix;



//getters and setters
public long getId(){
	return id;
}
public String getNom() {
	return nom;
}
public int getQuantite() {
	return quantite;
}
public long getPrix() {
	return prix;
}

public void setId(long id) {
	this.id=id;
}
public void setNom(String nom) {
	this.nom=nom;
}
public void setQuantite(int quantite) {
	this.quantite=quantite;
}
public void setPrix(long prix) {
	this.prix=prix;
}
//constructeurs
public Medicament() {
	super();
};
public Medicament(String nom,int quantite,long prix) {
	super();
	this.nom=nom;
	this.quantite=quantite;
	this.prix=prix;
}
}
