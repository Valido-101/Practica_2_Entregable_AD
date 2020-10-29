package ejercicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class Ejer3 {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/practica2" + "?useUnicode=true"+ "&serverTimezone=Europe/Madrid";
		
		String sql = "";
		
		try 
		{
			
			BufferedReader lector = new BufferedReader(new FileReader("datos.txt"));
			
			Connection con = DriverManager.getConnection(url, "prac2", "qwerty");
			
			Statement sentencia = con.createStatement();

			while(true) 
			{
				sql = lector.readLine();
				if(sql!=null) 
				{
					sentencia.execute(sql);
				}
				else 
				{
					break;
				}
			}
			
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
