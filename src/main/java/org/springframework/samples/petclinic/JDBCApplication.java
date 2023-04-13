package org.springframework.samples.petclinic;


import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class JDBCApplication {

	public static void main(String[] args) {
		System.out.println("-------- Test de conexión con MySQL ------------");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("No encuentro el driver en el Classpath");
			e.printStackTrace();
			return;
		}

		System.out.println("Driver instalado y funcionando");
		Connection connection = null;
		Statement statement = null;
		
		
		
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/petclinic?serverTimezone=UTC&useSSL=false","desarrollo", "123");
			if (connection != null)
				System.out.println("Conexión establecida");
			
// Primer ejercicio del taller
/*   Borrar para comentar ejercicio =====> */
		System.out.println("\nPrimer ejercicio de Bootcamp Java NTT Data\n  ******************* ******************\n");
		Statement query = null;
		ResultSet result = null;
		try {
			query = connection.createStatement();
			String SQL = "SELECT * FROM petclinic.owners";
			result = query.executeQuery(SQL);	
		}
		catch (SQLException e) {
		   System.out.print("Error al ejecutar la consulta "+ e);
		}
		finally {
		   	   
		   if(result != null) {
			   String nombre;
			   String apellido;
			   String ciudad;
			   String direccion;
			   String telefono;
			   while (result.next()) {
				  nombre = result.getString("first_name");
				  apellido = result.getString("last_name");
				  ciudad = result.getString("city");
				  direccion = result.getString("address");
				  telefono = result.getString("telephone");
				  System.out.println(nombre+" "+apellido+" => "+" Teléfono: "+telefono+" // "+ciudad+" - "+direccion);
			   }
			   result.close();
		   }
		   
		   query.close();
		}
//	Final del primer ejercicio del taller */
			
			
			
			
			
		
			
			} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		} finally {
			try {
				if(statement != null)
					connection.close();
			} catch (SQLException se) {
		    	  
		    }
		    try {
		        if(connection != null)
		            connection.close();
		    } catch (SQLException se) {
		         	se.printStackTrace();
		    }
		}
		
		
		
		
		
		
	}

}
