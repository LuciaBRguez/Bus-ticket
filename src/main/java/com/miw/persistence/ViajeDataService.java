package com.miw.persistence;

import java.util.Vector;
import com.miw.model.Viaje;


public interface ViajeDataService {
	
	public Vector<Viaje> getViajes() throws Exception;
	public Viaje getViaje(int id) throws Exception;
	public void update(int id,int numplazas)throws Exception;

}