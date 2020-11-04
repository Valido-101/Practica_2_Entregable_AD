package ejercicios;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Calendar;
import java.util.Map;

//Para este apartado es necesario implementar la interfaz CallableStatement
public class Ejer6 implements CallableStatement{

	public static void main(String[] args) {
		
		//Instanciamos una string con nuestro PreparedCall
		String preparedCall = "{ ? = call calcula_beneficio (?) }";
		
		String url = "jdbc:mysql://localhost:3306/practica2" + "?useUnicode=true"+ "&serverTimezone=Europe/Madrid";
		
		try {
			
			//Instanciamos una conexión pasándole por parámetro la url del Schema, el usuario y la contraseña
			Connection con = DriverManager.getConnection(url, "prac2", "qwerty");
			
			//Instanciamos un CallableStatement con un prepareCall que recibe por parámetro la string que definimos antes
			CallableStatement cs = con.prepareCall(preparedCall);
			
			//Seteamos los valores de los placeholders
			//El primero es el valor que devuelve puesto que estamos invocando una función
			cs.registerOutParameter(1, Types.VARCHAR);
			//El segundo es el id de compra necesario para hacer el cálculo
			cs.setInt(2, 83);
			
			//Instanciamos un ResultSet que recoja el resultado de la ejecución de la consulta
			ResultSet rs = cs.executeQuery();
			
			//Nos movemos al siguiente registro del ResultSet (empieza en 0 por lo que debemos movernos al siguiente)
			rs.next();
			
			//Obtenemos el string que devuelve la función y lo mostramos
			System.out.println(rs.getString(1));
			
			//Cerramos los recursos
			rs.close();
			cs.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void addBatch() throws SQLException {
	}

	@Override
	public void clearParameters() throws SQLException {
	}

	@Override
	public boolean execute() throws SQLException {
		
		return false;
	}

	@Override
	public ResultSet executeQuery() throws SQLException {
		
		return null;
	}

	@Override
	public int executeUpdate() throws SQLException {
		
		return 0;
	}

	@Override
	public ResultSetMetaData getMetaData() throws SQLException {
		
		return null;
	}

	@Override
	public ParameterMetaData getParameterMetaData() throws SQLException {
		
		return null;
	}

	@Override
	public void setArray(int arg0, Array arg1) throws SQLException {
	}

	@Override
	public void setAsciiStream(int arg0, InputStream arg1) throws SQLException {
	}

	@Override
	public void setAsciiStream(int arg0, InputStream arg1, int arg2) throws SQLException {
	}

	@Override
	public void setAsciiStream(int arg0, InputStream arg1, long arg2) throws SQLException {
	}

	@Override
	public void setBigDecimal(int arg0, BigDecimal arg1) throws SQLException {
	}

	@Override
	public void setBinaryStream(int arg0, InputStream arg1) throws SQLException {
	}

	@Override
	public void setBinaryStream(int arg0, InputStream arg1, int arg2) throws SQLException {
	}

	@Override
	public void setBinaryStream(int arg0, InputStream arg1, long arg2) throws SQLException {
	}

	@Override
	public void setBlob(int arg0, Blob arg1) throws SQLException {
	}

	@Override
	public void setBlob(int arg0, InputStream arg1) throws SQLException {
	}

	@Override
	public void setBlob(int arg0, InputStream arg1, long arg2) throws SQLException {
	}

	@Override
	public void setBoolean(int arg0, boolean arg1) throws SQLException {
	}

	@Override
	public void setByte(int arg0, byte arg1) throws SQLException {
	}

	@Override
	public void setBytes(int arg0, byte[] arg1) throws SQLException {
	}

	@Override
	public void setCharacterStream(int arg0, Reader arg1) throws SQLException {
	}

	@Override
	public void setCharacterStream(int arg0, Reader arg1, int arg2) throws SQLException {
	}

	@Override
	public void setCharacterStream(int arg0, Reader arg1, long arg2) throws SQLException {
	}

	@Override
	public void setClob(int arg0, Clob arg1) throws SQLException {
	}

	@Override
	public void setClob(int arg0, Reader arg1) throws SQLException {
	}

	@Override
	public void setClob(int arg0, Reader arg1, long arg2) throws SQLException {
	}

	@Override
	public void setDate(int arg0, Date arg1) throws SQLException {
	}

	@Override
	public void setDate(int arg0, Date arg1, Calendar arg2) throws SQLException {
	}

	@Override
	public void setDouble(int arg0, double arg1) throws SQLException {
	}

	@Override
	public void setFloat(int arg0, float arg1) throws SQLException {
	}

	@Override
	public void setInt(int arg0, int arg1) throws SQLException {
	}

	@Override
	public void setLong(int arg0, long arg1) throws SQLException {
	}

	@Override
	public void setNCharacterStream(int arg0, Reader arg1) throws SQLException {
	}

	@Override
	public void setNCharacterStream(int arg0, Reader arg1, long arg2) throws SQLException {
	}

	@Override
	public void setNClob(int arg0, NClob arg1) throws SQLException {
	}

	@Override
	public void setNClob(int arg0, Reader arg1) throws SQLException {
	}

	@Override
	public void setNClob(int arg0, Reader arg1, long arg2) throws SQLException {
	}

	@Override
	public void setNString(int arg0, String arg1) throws SQLException {
	}

	@Override
	public void setNull(int arg0, int arg1) throws SQLException {
	}

	@Override
	public void setNull(int arg0, int arg1, String arg2) throws SQLException {
	}

	@Override
	public void setObject(int arg0, Object arg1) throws SQLException {
	}

	@Override
	public void setObject(int arg0, Object arg1, int arg2) throws SQLException {
	}

	@Override
	public void setObject(int arg0, Object arg1, int arg2, int arg3) throws SQLException {
	}

	@Override
	public void setRef(int arg0, Ref arg1) throws SQLException {
	}

	@Override
	public void setRowId(int arg0, RowId arg1) throws SQLException {
	}

	@Override
	public void setSQLXML(int arg0, SQLXML arg1) throws SQLException {
	}

	@Override
	public void setShort(int arg0, short arg1) throws SQLException {
	}

	@Override
	public void setString(int arg0, String arg1) throws SQLException {
	}

	@Override
	public void setTime(int arg0, Time arg1) throws SQLException {
	}

	@Override
	public void setTime(int arg0, Time arg1, Calendar arg2) throws SQLException {
	}

	@Override
	public void setTimestamp(int arg0, Timestamp arg1) throws SQLException {
	}

	@Override
	public void setTimestamp(int arg0, Timestamp arg1, Calendar arg2) throws SQLException {
	}

	@Override
	public void setURL(int arg0, URL arg1) throws SQLException {
	}

	@Override
	public void setUnicodeStream(int arg0, InputStream arg1, int arg2) throws SQLException {
	}

	@Override
	public void addBatch(String sql) throws SQLException {
	}

	@Override
	public void cancel() throws SQLException {
	}

	@Override
	public void clearBatch() throws SQLException {
	}

	@Override
	public void clearWarnings() throws SQLException {
	}

	@Override
	public void close() throws SQLException {
	}

	@Override
	public void closeOnCompletion() throws SQLException {
	}

	@Override
	public boolean execute(String sql) throws SQLException {
		
		return false;
	}

	@Override
	public boolean execute(String sql, int autoGeneratedKeys) throws SQLException {
		
		return false;
	}

	@Override
	public boolean execute(String sql, int[] columnIndexes) throws SQLException {
		
		return false;
	}

	@Override
	public boolean execute(String sql, String[] columnNames) throws SQLException {
		
		return false;
	}

	@Override
	public int[] executeBatch() throws SQLException {
		
		return null;
	}

	@Override
	public ResultSet executeQuery(String sql) throws SQLException {
		
		return null;
	}

	@Override
	public int executeUpdate(String sql) throws SQLException {
		
		return 0;
	}

	@Override
	public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
		
		return 0;
	}

	@Override
	public int executeUpdate(String sql, int[] columnIndexes) throws SQLException {
		
		return 0;
	}

	@Override
	public int executeUpdate(String sql, String[] columnNames) throws SQLException {
		
		return 0;
	}

	@Override
	public Connection getConnection() throws SQLException {
		
		return null;
	}

	@Override
	public int getFetchDirection() throws SQLException {
		
		return 0;
	}

	@Override
	public int getFetchSize() throws SQLException {
		
		return 0;
	}

	@Override
	public ResultSet getGeneratedKeys() throws SQLException {
		
		return null;
	}

	@Override
	public int getMaxFieldSize() throws SQLException {
		
		return 0;
	}

	@Override
	public int getMaxRows() throws SQLException {
		
		return 0;
	}

	@Override
	public boolean getMoreResults() throws SQLException {
		
		return false;
	}

	@Override
	public boolean getMoreResults(int current) throws SQLException {
		
		return false;
	}

	@Override
	public int getQueryTimeout() throws SQLException {
		
		return 0;
	}

	@Override
	public ResultSet getResultSet() throws SQLException {
		
		return null;
	}

	@Override
	public int getResultSetConcurrency() throws SQLException {
		
		return 0;
	}

	@Override
	public int getResultSetHoldability() throws SQLException {
		
		return 0;
	}

	@Override
	public int getResultSetType() throws SQLException {
		
		return 0;
	}

	@Override
	public int getUpdateCount() throws SQLException {
		
		return 0;
	}

	@Override
	public SQLWarning getWarnings() throws SQLException {
		
		return null;
	}

	@Override
	public boolean isCloseOnCompletion() throws SQLException {
		
		return false;
	}

	@Override
	public boolean isClosed() throws SQLException {
		
		return false;
	}

	@Override
	public boolean isPoolable() throws SQLException {
		
		return false;
	}

	@Override
	public void setCursorName(String name) throws SQLException {
	}

	@Override
	public void setEscapeProcessing(boolean enable) throws SQLException {
	}

	@Override
	public void setFetchDirection(int direction) throws SQLException {
	}

	@Override
	public void setFetchSize(int rows) throws SQLException {
	}

	@Override
	public void setMaxFieldSize(int max) throws SQLException {
	}

	@Override
	public void setMaxRows(int max) throws SQLException {
	}

	@Override
	public void setPoolable(boolean poolable) throws SQLException {
	}

	@Override
	public void setQueryTimeout(int seconds) throws SQLException {
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		
		return null;
	}

	@Override
	public Array getArray(int arg0) throws SQLException {
		
		return null;
	}

	@Override
	public Array getArray(String arg0) throws SQLException {
		
		return null;
	}

	@Override
	public BigDecimal getBigDecimal(int arg0) throws SQLException {
		
		return null;
	}

	@Override
	public BigDecimal getBigDecimal(String arg0) throws SQLException {
		
		return null;
	}

	@Override
	public BigDecimal getBigDecimal(int arg0, int arg1) throws SQLException {
		
		return null;
	}

	@Override
	public Blob getBlob(int arg0) throws SQLException {
		
		return null;
	}

	@Override
	public Blob getBlob(String arg0) throws SQLException {
		
		return null;
	}

	@Override
	public boolean getBoolean(int arg0) throws SQLException {
		
		return false;
	}

	@Override
	public boolean getBoolean(String arg0) throws SQLException {
		
		return false;
	}

	@Override
	public byte getByte(int arg0) throws SQLException {
		
		return 0;
	}

	@Override
	public byte getByte(String arg0) throws SQLException {
		
		return 0;
	}

	@Override
	public byte[] getBytes(int arg0) throws SQLException {
		
		return null;
	}

	@Override
	public byte[] getBytes(String arg0) throws SQLException {
		
		return null;
	}

	@Override
	public Reader getCharacterStream(int arg0) throws SQLException {
		
		return null;
	}

	@Override
	public Reader getCharacterStream(String arg0) throws SQLException {
		
		return null;
	}

	@Override
	public Clob getClob(int arg0) throws SQLException {
		
		return null;
	}

	@Override
	public Clob getClob(String arg0) throws SQLException {
		
		return null;
	}

	@Override
	public Date getDate(int arg0) throws SQLException {
		
		return null;
	}

	@Override
	public Date getDate(String arg0) throws SQLException {
		
		return null;
	}

	@Override
	public Date getDate(int arg0, Calendar arg1) throws SQLException {
		
		return null;
	}

	@Override
	public Date getDate(String arg0, Calendar arg1) throws SQLException {
		
		return null;
	}

	@Override
	public double getDouble(int arg0) throws SQLException {
		
		return 0;
	}

	@Override
	public double getDouble(String arg0) throws SQLException {
		
		return 0;
	}

	@Override
	public float getFloat(int arg0) throws SQLException {
		
		return 0;
	}

	@Override
	public float getFloat(String arg0) throws SQLException {
		
		return 0;
	}

	@Override
	public int getInt(int arg0) throws SQLException {
		
		return 0;
	}

	@Override
	public int getInt(String arg0) throws SQLException {
		
		return 0;
	}

	@Override
	public long getLong(int arg0) throws SQLException {
		
		return 0;
	}

	@Override
	public long getLong(String arg0) throws SQLException {
		
		return 0;
	}

	@Override
	public Reader getNCharacterStream(int arg0) throws SQLException {
		
		return null;
	}

	@Override
	public Reader getNCharacterStream(String arg0) throws SQLException {
		
		return null;
	}

	@Override
	public NClob getNClob(int arg0) throws SQLException {
		
		return null;
	}

	@Override
	public NClob getNClob(String arg0) throws SQLException {
		
		return null;
	}

	@Override
	public String getNString(int arg0) throws SQLException {
		
		return null;
	}

	@Override
	public String getNString(String arg0) throws SQLException {
		
		return null;
	}

	@Override
	public Object getObject(int arg0) throws SQLException {
		
		return null;
	}

	@Override
	public Object getObject(String arg0) throws SQLException {
		
		return null;
	}

	@Override
	public Object getObject(int arg0, Map<String, Class<?>> arg1) throws SQLException {
		
		return null;
	}

	@Override
	public Object getObject(String arg0, Map<String, Class<?>> arg1) throws SQLException {
		
		return null;
	}

	@Override
	public <T> T getObject(int arg0, Class<T> arg1) throws SQLException {
		
		return null;
	}

	@Override
	public <T> T getObject(String arg0, Class<T> arg1) throws SQLException {
		
		return null;
	}

	@Override
	public Ref getRef(int arg0) throws SQLException {
		
		return null;
	}

	@Override
	public Ref getRef(String arg0) throws SQLException {
		
		return null;
	}

	@Override
	public RowId getRowId(int arg0) throws SQLException {
		
		return null;
	}

	@Override
	public RowId getRowId(String arg0) throws SQLException {
		
		return null;
	}

	@Override
	public SQLXML getSQLXML(int arg0) throws SQLException {
		
		return null;
	}

	@Override
	public SQLXML getSQLXML(String arg0) throws SQLException {
		
		return null;
	}

	@Override
	public short getShort(int arg0) throws SQLException {
		
		return 0;
	}

	@Override
	public short getShort(String arg0) throws SQLException {
		
		return 0;
	}

	@Override
	public String getString(int arg0) throws SQLException {
		
		return null;
	}

	@Override
	public String getString(String arg0) throws SQLException {
		
		return null;
	}

	@Override
	public Time getTime(int arg0) throws SQLException {
		
		return null;
	}

	@Override
	public Time getTime(String arg0) throws SQLException {
		
		return null;
	}

	@Override
	public Time getTime(int arg0, Calendar arg1) throws SQLException {
		
		return null;
	}

	@Override
	public Time getTime(String arg0, Calendar arg1) throws SQLException {
		
		return null;
	}

	@Override
	public Timestamp getTimestamp(int arg0) throws SQLException {
		
		return null;
	}

	@Override
	public Timestamp getTimestamp(String arg0) throws SQLException {
		
		return null;
	}

	@Override
	public Timestamp getTimestamp(int arg0, Calendar arg1) throws SQLException {
		
		return null;
	}

	@Override
	public Timestamp getTimestamp(String arg0, Calendar arg1) throws SQLException {
		
		return null;
	}

	@Override
	public URL getURL(int arg0) throws SQLException {
		
		return null;
	}

	@Override
	public URL getURL(String arg0) throws SQLException {
		
		return null;
	}

	@Override
	public void registerOutParameter(int arg0, int arg1) throws SQLException {
	}

	@Override
	public void registerOutParameter(String arg0, int arg1) throws SQLException {
	}

	@Override
	public void registerOutParameter(int arg0, int arg1, int arg2) throws SQLException {
	}

	@Override
	public void registerOutParameter(int arg0, int arg1, String arg2) throws SQLException {
	}

	@Override
	public void registerOutParameter(String arg0, int arg1, int arg2) throws SQLException {
	}

	@Override
	public void registerOutParameter(String arg0, int arg1, String arg2) throws SQLException {
	}

	@Override
	public void setAsciiStream(String arg0, InputStream arg1) throws SQLException {
	}

	@Override
	public void setAsciiStream(String arg0, InputStream arg1, int arg2) throws SQLException {
	}

	@Override
	public void setAsciiStream(String arg0, InputStream arg1, long arg2) throws SQLException {
	}

	@Override
	public void setBigDecimal(String arg0, BigDecimal arg1) throws SQLException {
	}

	@Override
	public void setBinaryStream(String arg0, InputStream arg1) throws SQLException {
	}

	@Override
	public void setBinaryStream(String arg0, InputStream arg1, int arg2) throws SQLException {
	}

	@Override
	public void setBinaryStream(String arg0, InputStream arg1, long arg2) throws SQLException {
	}

	@Override
	public void setBlob(String arg0, Blob arg1) throws SQLException {
	}

	@Override
	public void setBlob(String arg0, InputStream arg1) throws SQLException {
	}

	@Override
	public void setBlob(String arg0, InputStream arg1, long arg2) throws SQLException {
	}

	@Override
	public void setBoolean(String arg0, boolean arg1) throws SQLException {
	}

	@Override
	public void setByte(String arg0, byte arg1) throws SQLException {
	}

	@Override
	public void setBytes(String arg0, byte[] arg1) throws SQLException {
	}

	@Override
	public void setCharacterStream(String arg0, Reader arg1) throws SQLException {
	}

	@Override
	public void setCharacterStream(String arg0, Reader arg1, int arg2) throws SQLException {
	}

	@Override
	public void setCharacterStream(String arg0, Reader arg1, long arg2) throws SQLException {
	}

	@Override
	public void setClob(String arg0, Clob arg1) throws SQLException {
	}

	@Override
	public void setClob(String arg0, Reader arg1) throws SQLException {
	}

	@Override
	public void setClob(String arg0, Reader arg1, long arg2) throws SQLException {
	}

	@Override
	public void setDate(String arg0, Date arg1) throws SQLException {
	}

	@Override
	public void setDate(String arg0, Date arg1, Calendar arg2) throws SQLException {
	}

	@Override
	public void setDouble(String arg0, double arg1) throws SQLException {
	}

	@Override
	public void setFloat(String arg0, float arg1) throws SQLException {
	}

	@Override
	public void setInt(String arg0, int arg1) throws SQLException {
	}

	@Override
	public void setLong(String arg0, long arg1) throws SQLException {
	}

	@Override
	public void setNCharacterStream(String arg0, Reader arg1) throws SQLException {
	}

	@Override
	public void setNCharacterStream(String arg0, Reader arg1, long arg2) throws SQLException {
	}

	@Override
	public void setNClob(String arg0, NClob arg1) throws SQLException {
	}

	@Override
	public void setNClob(String arg0, Reader arg1) throws SQLException {
	}

	@Override
	public void setNClob(String arg0, Reader arg1, long arg2) throws SQLException {
	}

	@Override
	public void setNString(String arg0, String arg1) throws SQLException {
	}

	@Override
	public void setNull(String arg0, int arg1) throws SQLException {
	}

	@Override
	public void setNull(String arg0, int arg1, String arg2) throws SQLException {
	}

	@Override
	public void setObject(String arg0, Object arg1) throws SQLException {
	}

	@Override
	public void setObject(String arg0, Object arg1, int arg2) throws SQLException {
	}

	@Override
	public void setObject(String arg0, Object arg1, int arg2, int arg3) throws SQLException {
	}

	@Override
	public void setRowId(String arg0, RowId arg1) throws SQLException {
	}

	@Override
	public void setSQLXML(String arg0, SQLXML arg1) throws SQLException {
	}

	@Override
	public void setShort(String arg0, short arg1) throws SQLException {
	}

	@Override
	public void setString(String arg0, String arg1) throws SQLException {
	}

	@Override
	public void setTime(String arg0, Time arg1) throws SQLException {
	}

	@Override
	public void setTime(String arg0, Time arg1, Calendar arg2) throws SQLException {
	}

	@Override
	public void setTimestamp(String arg0, Timestamp arg1) throws SQLException {
	}

	@Override
	public void setTimestamp(String arg0, Timestamp arg1, Calendar arg2) throws SQLException {
	}

	@Override
	public void setURL(String arg0, URL arg1) throws SQLException {
	}

	@Override
	public boolean wasNull() throws SQLException {
		
		return false;
	}

}
