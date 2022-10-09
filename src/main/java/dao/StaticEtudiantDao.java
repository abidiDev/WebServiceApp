package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.DELETE;

import entities.Etudiant;

 public class   StaticEtudiantDao implements IEtudiantDao {
//creating and initializing data
	 private static final List<Etudiant> etuduantList=new ArrayList<Etudiant>();
	 static{
		 etuduantList.add(new Etudiant("wael","abidi","11664697","1eme","SAE1"));
		 etuduantList.add(new Etudiant("rayen","abidi","11664698","2eme","SAE2"));
		 etuduantList.add(new Etudiant("ahmed","abidi","11664699","3eme","SAE3"));
		 etuduantList.add(new Etudiant("yassine","abidi","11664697","4eme","SAE4"));
			
		}
	
//getting all students	 
	 public List<Etudiant> get(){
		 return etuduantList;
	 }
// filtering students
	 public List<Etudiant> filter(String f){

		 List<Etudiant> filtredList=new ArrayList<Etudiant>();
		 for(int i=0;i<etuduantList.size();i++) {
			 
			 if (etuduantList.get(i).getNom().contains(f)||etuduantList.get(i).getprenom().contains(f)||etuduantList.get(i).getCin().contains(f)||etuduantList.get(i).getClasse().contains(f)||etuduantList.get(i).getBranche().contains(f)) {
				filtredList.add(etuduantList.get(i));
			}
		 }
		 return filtredList;
		 
	 }
// adding new student
    public List<Etudiant> add( Etudiant E) {
    	etuduantList.add(E);
    	return etuduantList;
    	
    }
//updating student
    public List<Etudiant> update( Etudiant E){
    	 for(int i=0;i<etuduantList.size();i++) {
    		 if (etuduantList.get(i).getCin().equals(E.getCin())) {
    			 etuduantList.set(i, E);
    			
    		}
    		 }
    	 return etuduantList;
    }
//deleting student by cin    
    public List<Etudiant> delete(String cin) {
		 for(int i=0;i<etuduantList.size();i++) {
		 if (etuduantList.get(i).getCin().equals(cin)) {
			 etuduantList.remove(i);
			
		}
		 }
		 return etuduantList;
    }
	
	
}
