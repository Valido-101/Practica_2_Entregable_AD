package ejercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejer5 {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/practica2" + "?useUnicode=true"+ "&serverTimezone=Europe/Madrid";
		
		try {
			
			//Instanciamos una conexión a la que pasamos por parámetro la url del schema, el usuario y la contraseña
			Connection con = DriverManager.getConnection(url, "prac2", "qwerty");
			
			//Creamos tres Statements, uno para cada apartado del ejercicio (mostrar los clientes de Tomares, los productos con stock crítico y las compras mayores a 10 unidades)
			Statement stmt1 = con.createStatement();
			
			Statement stmt2 = con.createStatement();
			
			Statement stmt3 = con.createStatement();
			
			//Creamos un ResultSet para cada Statement que guarde el resultado de cada consulta y ejecutamos la consulta con executeQuery
			ResultSet clientes_tomares = stmt1.executeQuery("Select ID, NOMBRE from Clientes where Poblacion='Tomares'");
			
			ResultSet stock_critico = stmt2.executeQuery("Select id, descripcion, pvp from productos where stockactual<=stockminimo");
			
			ResultSet compras_mayores_10_unidades = stmt3.executeQuery("Select DISTINCT clientes.ID, clientes.NOMBRE from Clientes,ventas where clientes.id=ventas.idcliente AND ventas.cantidad>10");
			
			//Informamos por consola de cuál es el apartado que vamos a mostrar
			System.out.println("Clientes que viven en Tomares: \n");
			
			//Recorremos el ResultSet de clientes en Tomares y mostramos el resultado (mientras el método next devuelva true hay registros)
			while(clientes_tomares.next()) 
			{
				System.out.println("ID: "+clientes_tomares.getInt(1)+", NOMBRE: "+clientes_tomares.getString(2));
			}
			
			//Informamos por consola de cuál es el apartado que vamos a mostrar
			System.out.println("\nProductos con un stock actual crítico: \n");
			
			//Recorremos el ResultSet de productos con stock crítico y mostramos el resultado (mientras el método next devuelva true hay registros)
			while(stock_critico.next()) 
			{
				System.out.println("ID: "+stock_critico.getInt(1)+", DESCRIPCIÓN: "+stock_critico.getString(2)+", PVP: "+stock_critico.getString(3));
			}
			
			//Informamos por consola de cuál es el apartado que vamos a mostrar
			System.out.println("\nClientes que han comprado más de 10 unidades de un producto: \n");
			
			//Recorremos el ResultSet de compras de más de 10 unidades y mostramos el resultado (mientras el método next devuelva true hay registros)
			while(compras_mayores_10_unidades.next()) 
			{
				System.out.println("ID: "+compras_mayores_10_unidades.getInt(1)+", NOMBRE: "+compras_mayores_10_unidades.getString(2));
			}
			
			//Cerramos los recursos utilizados
			compras_mayores_10_unidades.close();
			stock_critico.close();
			clientes_tomares.close();
			stmt3.close();
			stmt2.close();
			stmt1.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
