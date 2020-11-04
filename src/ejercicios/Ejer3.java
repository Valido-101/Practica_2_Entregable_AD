package ejercicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class Ejer3 {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/practica2" + "?useUnicode=true"+ "&serverTimezone=Europe/Madrid";
		
		//Variable que guardará la consulta sql
		String sql = "";
		
		try 
		{
			//Instanciamos el BufferedReader que leerá el documento
			BufferedReader lector = new BufferedReader(new FileReader("datos.txt"));
			
			//Instanciamos una conexión a la que pasamos por parámetro la url del schema, el usuario y la contraseña
			Connection con = DriverManager.getConnection(url, "prac2", "qwerty");
			
			//Creamos una sentencia a raíz de la conexión creada
			Statement sentencia = con.createStatement();

			//Bucle while que se repite infinitamente
			while(true) 
			{
				//Leemos una línea del documento txt y la guardamos en la variable sql
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
