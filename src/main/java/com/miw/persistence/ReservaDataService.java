package com.miw.persistence;

import com.miw.model.Reserva;

public interface ReservaDataService {

	public void creaReserva(Reserva reserva) throws Exception;
	public void creaReservaIdaVuelta(Reserva reserva) throws Exception;
	public Integer getId () throws Exception;
	public void eliminarReserva(String email, Integer id) throws Exception;
	public boolean existeReserva(String email, Integer id) throws Exception;
	public Reserva getReserva(String email, Integer id) throws Exception;
}
