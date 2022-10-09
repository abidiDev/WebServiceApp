package entities;

import javax.xml.bind.annotation.XmlElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "entité enregistré dans swagger")

public class Etudiant{

	private String nom;
	private String prenom;
	private String cin;
	private String classe;
	private String branche;
	public Etudiant() {};
	public Etudiant(String nom, String prenom, String cin, String classe, String branche) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.classe = classe;
		this.branche = branche;
	}
	@XmlElement(name="nom")
	@ApiModelProperty(value ="get nom")
	public String getNom() {
		return nom;
	}
	@Override
	public String toString() {
		return "Etudiant [nom=" + nom + ", prenom=" + prenom + ", cin=" + cin + ", classe=" + classe + ", branche="
				+ branche + "]";
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@XmlElement(name="prenom")
	@ApiModelProperty(value ="get prenom")
	public String getprenom() {
		return prenom;
	}
	public void setprenom(String prenom) {
		this.prenom = prenom;
	}
	@ApiModelProperty(value ="unique cin")

	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	@XmlElement(name="classe")
	@ApiModelProperty(value ="get classe")
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	@XmlElement(name="branche")
	@ApiModelProperty(value ="get branche")
	public String getBranche() {
		return branche;
	}
	public void setBranche(String branche) {
		this.branche = branche;
	}
}
