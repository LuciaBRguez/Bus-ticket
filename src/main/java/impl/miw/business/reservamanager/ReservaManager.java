package impl.miw.business.reservamanager;



import org.springframework.beans.factory.annotation.Autowired;

import com.miw.business.ReservaManagerService;
import com.miw.business.ViajeManagerService;
import com.miw.model.DatosPago;
import com.miw.model.Extras;
import com.miw.model.IdReserva;
import com.miw.model.Reserva;
import com.miw.model.Viaje;
import com.miw.model.ViajeElegido;
import com.miw.persistence.ReservaDataService;


public class ReservaManager implements ReservaManagerService {
	
	@Autowired
	private ReservaDataService reservaDataService = null;
	
	public void setReservaDataService(ReservaDataService reservaDataService) {
		System.out.println("Setting viajeDataService bean");
		this.reservaDataService = reservaDataService;
	}

	@Autowired
	private ViajeManagerService viajeManagerService = null;
	
	public void setViajeManagerService(ViajeManagerService viajeManagerService) {
		System.out.println("Setting viajeDataService bean");
		this.viajeManagerService = viajeManagerService;
	}


	public void creaReserva(ViajeElegido viajeElegido, ViajeElegido viajeElegidoIda, Extras extras, DatosPago datosPago) throws Exception {
		
		Reserva reserva = new Reserva();
		IdReserva idReserva = new IdReserva();

		// Viaje elegido
		reserva.setId_ida(viajeElegidoIda.getId_ida());
		reserva.setVuelta(viajeElegido.isVuelta());
		reserva.setNum_viajeros(viajeElegido.getNum_viajeros());
		// Extras
		reserva.setBicicleta(extras.isBicicleta());
		reserva.setMascota(extras.isMascota());
		reserva.setTabla_surf(extras.isTabla_surf());
		reserva.setEsquies(extras.isEsquies());
		reserva.setSeguro(extras.isSeguro());
		// Datos pago
		reserva.setNombre(datosPago.getNombre());
		reserva.setApellidos(datosPago.getApellidos());
		reserva.setTipo_identificacion(datosPago.getTipo_identificacion());
		reserva.setIdentificacion(datosPago.getIdentificacion());
		reserva.setEmail(datosPago.getEmail());
		
		this.reservaDataService.creaReserva(reserva);
		this.viajeManagerService.updateIda(viajeElegidoIda.getId_ida(), viajeElegido.getNum_viajeros(), true);
		
		//Añadimos el id de reserva a nuestro objeto reserva
		idReserva.setId(this.reservaDataService.getId());

	}


	public void creaReservaIdavuelta(ViajeElegido viajeElegido, ViajeElegido viajeElegidoIdaVuelta, Extras extras, DatosPago datosPago) throws Exception {
		
		Reserva reserva = new Reserva();
		IdReserva idReserva = new IdReserva();

		// Viaje elegido
		reserva.setId_ida(viajeElegidoIdaVuelta.getId_ida());
		reserva.setVuelta(viajeElegido.isVuelta());
		reserva.setId_vuelta(viajeElegidoIdaVuelta.getId_vuelta());
		reserva.setNum_viajeros(viajeElegido.getNum_viajeros());
		// Extras
		reserva.setBicicleta(extras.isBicicleta());
		reserva.setMascota(extras.isMascota());
		reserva.setTabla_surf(extras.isTabla_surf());
		reserva.setEsquies(extras.isEsquies());
		reserva.setSeguro(extras.isSeguro());
		// Datos pago
		reserva.setNombre(datosPago.getNombre());
		reserva.setApellidos(datosPago.getApellidos());
		reserva.setTipo_identificacion(datosPago.getTipo_identificacion());
		reserva.setIdentificacion(datosPago.getIdentificacion());
		reserva.setEmail(datosPago.getEmail());
		
		this.reservaDataService.creaReservaIdaVuelta(reserva);
		this.viajeManagerService.updateIdaVuelta(viajeElegidoIdaVuelta.getId_ida(), viajeElegidoIdaVuelta.getId_vuelta(), viajeElegido.getNum_viajeros(), true);

		//Añadimos el id de reserva a nuestro objeto reserva
		idReserva.setId(this.reservaDataService.getId());

	}


	public Integer getId() throws Exception {
		return this.reservaDataService.getId();
	}
	
	
	public boolean eliminarReserva(String email, Integer id) throws Exception {
		
		if(this.existeReserva(email, id)) {
			Reserva reserva = this.getReserva(email,id);
			Viaje viajeIda =  this.viajeManagerService.getViaje(reserva.getId_ida());
			if(reserva.isVuelta()) {
				Viaje viajeVuelta=this.viajeManagerService.getViaje(reserva.getId_vuelta());
				this.viajeManagerService.updateIdaVuelta(viajeIda.getId(), viajeVuelta.getId(), reserva.getNum_viajeros(), false);
			}
			else {
				this.viajeManagerService.updateIda(viajeIda.getId(), reserva.getNum_viajeros(), false);
			}
			this.reservaDataService.eliminarReserva(email, id);
			return true;
		}else {
			return false;
		}
	}


	public boolean existeReserva(String email, Integer id) throws Exception {
		return this.reservaDataService.existeReserva(email, id);
	}


	public Reserva getReserva(String email, Integer id) throws Exception {
		return this.reservaDataService.getReserva(email, id);
	}


}
