package ejercicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class Ejer3 {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/practica2" + "?useUnicode=true"+ "&serverTimezone=Europe/Madrid";
		
		//Variable que guardar� la consulta sql
		String sql = "";
		
		try 
		{
			//Instanciamos el BufferedReader que leer� el documento
			BufferedReader lector = new BufferedReader(new FileReader("datos.txt"));
			
			//Instanciamos una conexi�n a la que pasamos por par�metro la url del schema, el usuario y la contrase�a
			Connection con = DriverManager.getConnection(url, "prac2", "qwerty");
			
			//Creamos una sentencia a ra�z de la conexi�n creada
			Statement sentencia = con.createStatement();

			//Bucle while que se repite infinitamente
			while(true) 
			{
				//Leemos una l�nea del documento txt y la guardamos en la variable sql
				sql = lector.readLine();
				//Si la variable sql no es igual a null (indica que ha llegado al final del documento)
				if(sql!=null) 
				{
					//Se ejecuta lo que hay guardado en la variable sql
					sentencia.execute(sql);
				}
				//Si es igual a null, se rompe el bucle
				else 
				{
					break;
				}
			}
			
			//Cerramos los recursos
			sentencia.close();
			con.close();
			lector.close();
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
