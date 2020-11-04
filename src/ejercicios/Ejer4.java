package ejercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.sql.Date;

public class Ejer4 {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/practica2" + "?useUnicode=true"+ "&serverTimezone=Europe/Madrid";
		
		//Variable que indica el id del producto que se va a vender
		int id_producto = 101;
		
		try {
			
			//Instanciamos una conexión a la que pasamos por parámetro la url del schema, el usuario y la contraseña
			Connection con = DriverManager.getConnection(url, "prac2", "qwerty");
			
			//Creamos un bucle que llegue hasta diez (una venta para cada cliente)
			for(int x=1;x<=10;x++) 
			{
				//Llamamos al método que inserta la venta pasándole por parámetro la conexión, el cliente (x) y el id producto
				insertaVenta(con,x,id_producto);
				
				//Aumentamos el id de producto para que cada venta sea de un producto distinto
				id_producto++;
			}
			
			//Cerramos los recursos
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		

	}
	
	public static void insertaVenta(Connection con,int id_cliente,int id_producto) 
	{
		
		//Creamos un calendario, una Date de java.util y una date de java.sql para obtener la fecha del sistema
		Calendar cal = Calendar.getInstance(); 
		
		java.util.Date fecha = cal.getTime();
		
		Date fecha1 = new Date(fecha.getTime()); 
		
		//Inicio del try catch
		try {
			
			//Instanciamos un PreparedStatement con el insert que necesitamos y varios placeholders que rellenaremos después
			PreparedStatement stmt = con.prepareStatement("Insert into ventas(fechaventa,idcliente,idproducto,cantidad) values (?,?,?,?)");
			
			//Seteamos el valor de los distintos placeholders que serán insertados en la tabla ventas
			stmt.setDate(1, fecha1);
			stmt.setInt(2, id_cliente);
			stmt.setInt(3, id_producto);
			stmt.setInt(4, (int)(Math.random()*40+1));
			
			//Ejecutamos el PreparedStatement
			stmt.execute();
			
			//Cerramos el PreparedStatement
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
