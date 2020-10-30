package impl.miw.business.viajemanager;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;

import com.miw.business.ViajeManagerService;
import com.miw.model.Viaje;
import com.miw.persistence.ViajeDataService;

public class ViajeManager implements ViajeManagerService {
	
	@Autowired
	private ViajeDataService viajeDataService = null;
	
	
	public void setViajeDataService (ViajeDataService viajeDataService) {
		this.viajeDataService = viajeDataService;
	}
	

	public Viaje getViaje (int id) throws Exception {
		Viaje viaje = viajeDataService.getViaje(id);
		return viaje;
	}
	

	// Obtenemos un vector viajes con todos los viajes de la BD
	public Vector<Viaje> getViajes() throws Exception {
		Vector<Viaje> viajes = viajeDataService.getViajes();
		return viajes;
	}
	
	
	// Obtenemos un vector origenes con los origenes no repetidos
	public Vector<String> getOrigenes() throws Exception {
		Vector<Viaje> viajes = viajeDataService.getViajes();
		Vector<String> origenes = new Vector<String>();
		for (int i=0; i<viajes.size(); i++) {
			String origen = viajes.get(i).getOrigen();
			if (!origenes.contains(origen)) {
				origenes.add(origen);
			}
		}
		return origenes;
	}
	
	
	// Obtenemos un vector destinos con los destinos no repetidos
	public Vector<String> getDestinos() throws Exception {
		Vector<Viaje> viajes = viajeDataService.getViajes();
		Vector<String> destinos = new Vector<String>();
		for (int i=0; i<viajes.size(); i++) {
			String destino = viajes.get(i).getDestino();
			if (!destinos.contains(destino)) {
				destinos.add(destino);
			}
		}
		return destinos;
	}
	
	
	// Obtenemos un vector opciones con todas las opciones de viajes que se corresponden con la elección de viaje de ida del comprador
	public Vector<Viaje> getViajes (String origen, String destino, String fecha_ida, Integer num_viajeros) throws Exception {
		Vector<Viaje> viajes = viajeDataService.getViajes();
		Vector<Viaje> opciones = new Vector<Viaje>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date date = sdf.parse(fecha_ida);
	 	java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	 	
		for (int i=0; i<viajes.size(); i++) {
			Viaje viaje = viajes.get(i);
			String origen_bd = viajes.get(i).getOrigen();
			String destino_bd = viajes.get(i).getDestino();
			Date fecha_ida_bd = viajes.get(i).getFecha_salida();
			Integer plazas_libres_bd = viajes.get(i).getPlazas_libres();
			if(origen.equals(origen_bd) && destino.equals(destino_bd) && sqlDate.equals(fecha_ida_bd) && num_viajeros<=plazas_libres_bd) {
				opciones.add(viaje);
			}
		}
		return opciones;
	}

	
	// Restamos una plaza de asiento cada vez que se hace una reserva
	public void update (int id, int num_plazas) throws Exception {
		Viaje viaje = this.getViaje(id);
		int num_libres = viaje.getPlazas_libres()-num_plazas;
		this.viajeDataService.update(id, num_libres);
	}


	// True crea reserva. False cancela reserva.
	public void updateIda(Integer id_ida, Integer num_plazas, Boolean sumarOrestar) throws Exception {
		Viaje viaje = this.getViaje(id_ida);
		int num_libres = 0;
		if (sumarOrestar) {
			num_libres = viaje.getPlazas_libres()-num_plazas;
		}
		else {
			num_libres = viaje.getPlazas_libres()+num_plazas;
		}
		this.viajeDataService.update(id_ida, num_libres);
	}


	public void updateIdaVuelta(Integer id_ida, Integer id_vuelta, Integer num_plazas, Boolean sumarOrestar) throws Exception {
		// Ida
		Viaje viaje_ida = this.getViaje(id_ida);
		int num_libres_ida = 0;
		if (sumarOrestar) {
			num_libres_ida = viaje_ida.getPlazas_libres()-num_plazas;
		}
		else {
			num_libres_ida = viaje_ida.getPlazas_libres()+num_plazas;
		}
		this.viajeDataService.update(id_ida, num_libres_ida);
		
		// Vuelta
		Viaje viaje_vuelta = this.getViaje(id_vuelta);
		int num_libres_vuelta = 0;
		if (sumarOrestar) {
			num_libres_vuelta = viaje_vuelta.getPlazas_libres()-num_plazas;
		}
		else {
			num_libres_vuelta = viaje_vuelta.getPlazas_libres()+num_plazas;
		}
		this.viajeDataService.update(id_vuelta, num_libres_vuelta);
	}
	
}
