package com.miw.business;

import com.miw.model.DatosPago;
import com.miw.model.Extras;
import com.miw.model.Reserva;
import com.miw.model.ViajeElegido;

public interface ReservaManagerService {

	public void creaReserva(ViajeElegido viajeElegido, ViajeElegido viajeElegidoIda, Extras extras, DatosPago datosPago) throws Exception;
	public void creaReservaIdavuelta(ViajeElegido viajeElegido, ViajeElegido viajeElegidoIdaVuelta, Extras extras, DatosPago datosPago) throws Exception;
	public Integer getId () throws Exception;
	public boolean eliminarReserva(String email, Integer id) throws Exception;
	public boolean existeReserva(String email, Integer id) throws Exception;
	public Reserva getReserva(String email, Integer id) throws Exception;
}
