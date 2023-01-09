package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.x500.X500Principal;

import entities.Employee;
import entities.Etudiant;

public class EtudiantDao  implements  IEntityDao<Etudiant> {
	private static  Connection connection;
	public static PreparedStatement ps;
	public static ResultSet rs;
	String query;
	
	public EtudiantDao() {

		EtudiantDao.connection= SingletonDbConnection.getConnection();

	}

        
  
    
  
		 public  List<Etudiant> get(){
			List<Etudiant> etuduantList=new ArrayList<Etudiant>();

			
				  try {
					ps=connection.prepareStatement("SELECT * from etudiant");
					  rs=ps.executeQuery();
					  while(rs.next()) {
						   Etudiant e = new Etudiant();      
						   e.setNom(rs.getString("nom"));
						   e.setPrenom(rs.getString("prenom"));
						   e.setprenom(rs.getString("prenom"));
						   e.setCin(rs.getString("cin"));
						   e.setClasse(rs.getString("classe"));
						   e.setBranche(rs.getString("branche"));
						  etuduantList.add(e);
						} 

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				  return etuduantList;
				
		
		 }
		 public  List<Etudiant> filter(String f){
				List<Etudiant> etuduantList=new ArrayList<Etudiant>();

				
					  try {
						ps=connection.prepareStatement("SELECT * from etudiant WHERE nom LIKE  ? OR prenom LIKE ? OR cin LIKE ? OR classe LIKE ? OR branche LIKE ?  ");
						ps.setString(1, '%'+f+'%');
						ps.setString(2, '%'+f+'%');
						ps.setString(3, '%'+f+'%');
						ps.setString(4, '%'+f+'%');
						ps.setString(5, '%'+f+'%');
						  rs=ps.executeQuery();
						  while(rs.next()) {
							   Etudiant e = new Etudiant();      
							   e.setNom(rs.getString("nom"));
							   e.setPrenom(rs.getString("prenom"));
							   e.setprenom(rs.getString("prenom"));
							   e.setCin(rs.getString("cin"));
							   e.setClasse(rs.getString("classe"));
							   e.setBranche(rs.getString("branche"));
							  etuduantList.add(e);
							} 

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					  return etuduantList;
					
			
			 }

		    public List<Etudiant> add( Etudiant E) {

				
				  try {
					ps=connection.prepareStatement("INSERT INTO etudiant (nom, prenom, cin, classe, branche, id) VALUES (?,?,?,?,?, NULL)");
					ps.setString(1,E.getNom());
					ps.setString(2,E.getPrenom());
					ps.setString(2,E.getprenom());

					ps.setString(3,E.getCin());
					ps.setString(4,E.getClasse());
					ps.setString(5,E.getBranche());
					int add=ps.executeUpdate();
					

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				  return get();
				
		
		    }

		    public List<Etudiant> delete( String cin) {
		    	try {
					ps=connection.prepareStatement("DELETE from etudiant WHERE cin=?");
					ps.setString(1, cin);
				
					int add=ps.executeUpdate();
					

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				  return get();
		    	
		    }
		    public List<Etudiant> update( Etudiant E) {
		    	try {
					ps=connection.prepareStatement("UPDATE etudiant SET nom=?,prenom=?,classe=?,branche=? WHERE cin=?");
					ps.setString(1, E.getNom());
					ps.setString(2, E.getPrenom());
					ps.setString(2, E.getprenom());
					ps.setString(3, E.getClasse());
					ps.setString(4, E.getBranche());
					ps.setString(5, E.getCin());
				
					int add=ps.executeUpdate();
					

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				  return get();
		    	
		    }





		

}
