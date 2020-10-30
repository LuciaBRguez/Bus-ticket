package impl.miw.persistence.viaje;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import com.miw.model.Viaje;
import com.miw.persistence.ViajeDataService;


/** 
 *  Clase que implementa las operaciones de acceso a la base de datos para la entidad Viaje
 *  @author Lucía Blanco Rodríguez
 *  @since 07/11/18
 *  @version 1.0
*/
public class ViajeDAO implements ViajeDataService {
	
	/**
	 * Método que accede a la base de datos para recuerar la lista de viajes
	 * presentes en la base de datos.
	*/
	public Vector<Viaje> getViajes() throws Exception {
		
		//Inicializamos el Vector de retorno.
		Vector<Viaje> resultado = new Vector<Viaje>();

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
 
		try {
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/amazin";

			//Obtenemos la conexión a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "DFLANVIN", "AMAZIN");

			ps = con.prepareStatement("select * from viajes");
			rs = ps.executeQuery();

			while (rs.next()) {
				//Completamos los datos del Viaje en la entidad
				Viaje viaje = new Viaje();
				viaje.setId(rs.getInt("ID"));
				viaje.setOrigen(rs.getString("ORIGEN"));
				viaje.setFecha_salida(rs.getDate("FECHA_SALIDA"));
				viaje.setHora_salida(rs.getTime("HORA_SALIDA"));
				viaje.setDestino(rs.getString("DESTINO"));
				viaje.setPlazas_libres(rs.getInt("PLAZAS_LIBRES"));
				//La añadimos al Vector de resultado
				resultado.add(viaje);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		} finally {
			try {
				ps.close();
				con.close();
			} catch (Exception e) {
			}
		}
		//Retornamos el vector de resultado.
		return resultado;
	}

	
	public Viaje getViaje(int id) throws Exception {
		//Inicializamos el Vector de retorno.
		Viaje viaje = null;

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
 
		try {
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/amazin";

			//Obtenemos la conexión a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "DFLANVIN", "AMAZIN");

			ps = con.prepareStatement("select * from viajes where id = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			

			if (rs.next()) {
				//Completamos los datos del Viaje en la entidad
				viaje=new Viaje();
				viaje.setId(rs.getInt("ID"));
				viaje.setOrigen(rs.getString("ORIGEN"));
				viaje.setFecha_salida(rs.getDate("FECHA_SALIDA"));
				viaje.setHora_salida(rs.getTime("HORA_SALIDA"));
				viaje.setDestino(rs.getString("DESTINO"));
				viaje.setPlazas_libres(rs.getInt("PLAZAS_LIBRES"));
				//La añadimos al Vector de resultado
				return viaje;
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		} finally {
			try {
				ps.close();
				con.close();
			} catch (Exception e) {
			}
		}
		//Retornamos el vector de resultado.
		return viaje;
	}

	
	public void update(int id, int plazas) throws Exception {

		PreparedStatement ps = null;
		Connection con = null;
		
		try {
			
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/amazin";
	
			//Obtenemos la conexión a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "DFLANVIN", "AMAZIN");
	
			ps = con.prepareStatement("update viajes " + "set plazas_libres = ?" + "where id = ?");
			
			ps.setInt(1, plazas);
			ps.setInt(2, id);
			
			ps.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		} finally {
			try {
				ps.close();
				con.close();
			} catch (Exception e) {
			}
		}
	
	}

}
