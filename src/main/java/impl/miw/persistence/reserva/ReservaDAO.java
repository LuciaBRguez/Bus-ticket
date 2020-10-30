package impl.miw.persistence.reserva;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.miw.model.Reserva;
import com.miw.persistence.ReservaDataService;

/** 
 *  Clase que implementa las operaciones de acceso a la base de datos para la entidad Reserva
 *  @author Lucía Blanco Rodríguez
 *  @since 07/11/18
 *  @version 1.0
*/
public class ReservaDAO implements ReservaDataService {

	/**
	 * Método que accede a la base de datos para crear reservas
	*/
	public void creaReserva(Reserva reserva) throws Exception {
		PreparedStatement ps = null;
		Connection con = null;
		
		try {

			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/amazin";
	
			// Obtenemos la conexión a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "DFLANVIN", "AMAZIN");
			ps = con.prepareStatement(
					"insert into reservas(ID_IDA, VUELTA, NUM_VIAJEROS, BICICLETA, MASCOTA, TABLA_SURF, ESQUIES, SEGURO, NOMBRE, APELLIDOS, TIPO_IDENTIFICACION, IDENTIFICACION, EMAIL) " +
					"values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			System.out.println(reserva.getId_ida());
			
			ps.setInt(1, reserva.getId_ida());
			ps.setBoolean(2, reserva.isVuelta());
			ps.setInt(3, reserva.getNum_viajeros());
			ps.setBoolean(4, reserva.isBicicleta());
			ps.setBoolean(5, reserva.isMascota());
			ps.setBoolean(6, reserva.isTabla_surf());
			ps.setBoolean(7, reserva.isEsquies());
			ps.setBoolean(8, reserva.isSeguro());
			ps.setString(9, reserva.getNombre());
			ps.setString(10, reserva.getApellidos());
			ps.setString(11, reserva.getTipo_identificacion());
			ps.setString(12, reserva.getIdentificacion());
			ps.setString(13, reserva.getEmail());
			
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
	
	
	public void creaReservaIdaVuelta(Reserva reserva) throws Exception {
		PreparedStatement ps = null;
		Connection con = null;
		
		try {

			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/amazin";
	
			// Obtenemos la conexión a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "DFLANVIN", "AMAZIN");
			ps = con.prepareStatement(
					"insert into reservas(ID_IDA, VUELTA, ID_VUELTA, NUM_VIAJEROS, BICICLETA, MASCOTA, TABLA_SURF, ESQUIES, SEGURO, NOMBRE, APELLIDOS, TIPO_IDENTIFICACION, IDENTIFICACION, EMAIL) " +
					"values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			System.out.println(reserva.getId_ida());
			System.out.println(reserva.isVuelta());
	
			ps.setInt(1, reserva.getId_ida());
			ps.setBoolean(2, reserva.isVuelta());
			ps.setInt(3, reserva.getId_vuelta());
			ps.setInt(4, reserva.getNum_viajeros());
			ps.setBoolean(5, reserva.isBicicleta());
			ps.setBoolean(6, reserva.isMascota());
			ps.setBoolean(7, reserva.isTabla_surf());
			ps.setBoolean(8, reserva.isEsquies());
			ps.setBoolean(9, reserva.isSeguro());
			ps.setString(10, reserva.getNombre());
			ps.setString(11, reserva.getApellidos());
			ps.setString(12, reserva.getTipo_identificacion());
			ps.setString(13, reserva.getIdentificacion());
			ps.setString(14, reserva.getEmail());
			
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


	// Obtenemos el id de la reserva que se acaba de hacer
	public Integer getId() throws Exception {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		 
		try {
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/amazin";

			//Obtenemos la conexión a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "DFLANVIN", "AMAZIN");

			ps = con.prepareStatement("SELECT(MAX(ID)) AS VALOR FROM RESERVAS");
			rs = ps.executeQuery();

			if (rs.next()) {
				Integer id = rs.getInt("VALOR");	
				return id;
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
		return null;
	}
	
	
	public void eliminarReserva(String email, Integer id) throws Exception {
		
		PreparedStatement ps = null;
		Connection con = null;
		
		try {
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/amazin";

			//Obtenemos la conexión a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "DFLANVIN", "AMAZIN");
			ps = con.prepareStatement("delete from reservas where id = ? and email= ?");
			
			ps.setInt(1, id);
			ps.setString(2, email);
			
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
	
	
	public boolean existeReserva(String email, Integer id) throws Exception {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		
		
		try {
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/amazin";

			//Obtenemos la conexión a la base de datos.
			Class.forName(SQL_DRV);
			
			con = DriverManager.getConnection(SQL_URL, "DFLANVIN", "AMAZIN");
			ps = con.prepareStatement("select * from reservas where id = ? and email = ?");
			
			ps.setInt(1, id);
			ps.setString(2, email);
			
			rs = ps.executeQuery();
			if (rs.next()) {
				return true;
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
		
		return false;
	}
	
	
	public Reserva getReserva(String email, Integer id) throws Exception {
		
		Reserva reserva = null;
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		
		
		try {
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/amazin";

			//Obtenemos la conexión a la base de datos.
			Class.forName(SQL_DRV);
			
			con = DriverManager.getConnection(SQL_URL, "DFLANVIN", "AMAZIN");
			ps = con.prepareStatement("select * from reservas where id = ? and email = ?");
			
			ps.setInt(1, id);
			ps.setString(2, email);
			
			rs = ps.executeQuery();
			if (rs.next()) {
				reserva = new Reserva();
				reserva.setId(rs.getInt("ID"));
				reserva.setId_ida(rs.getInt("ID_IDA"));
				reserva.setNum_viajeros(rs.getInt("NUM_VIAJEROS"));
				reserva.setVuelta(rs.getBoolean("VUELTA"));
				if (reserva.isVuelta()) {
					reserva.setId_vuelta(rs.getInt("ID_VUELTA"));
				}
				return reserva;
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
		
		return null;
	}

}
