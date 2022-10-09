package dao;

import java.util.List;

import entities.Etudiant;

public interface IEtudiantDao {
	public List<Etudiant> get();
	public List<Etudiant> filter(String f);
	public List<Etudiant> add( Etudiant E);
	public List<Etudiant> update(Etudiant E);
	public List<Etudiant> delete(String cin);

}
