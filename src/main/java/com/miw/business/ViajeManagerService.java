package com.miw.business;

import java.util.Vector;

import com.miw.model.Viaje;


public interface ViajeManagerService {
	
	public Vector<Viaje> getViajes() throws Exception;
	public Vector<String> getOrigenes() throws Exception;
	public Vector<String> getDestinos() throws Exception;
	public Vector<Viaje> getViajes (String origen, String destino, String fecha_ida, Integer num_viajeros) throws Exception;
	public void updateIda(Integer id_ida, Integer num_plazas, Boolean sumarOrestar)throws Exception;
	public void updateIdaVuelta(Integer id_ida, Integer id_vuelta, Integer num_plazas, Boolean sumarOrestar)throws Exception;
	public Viaje getViaje (int id) throws Exception;
	
}
