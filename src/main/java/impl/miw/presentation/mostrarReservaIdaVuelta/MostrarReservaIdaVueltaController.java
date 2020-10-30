package impl.miw.presentation.mostrarReservaIdaVuelta;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.mail.javamail.JavaMailSender;

import com.miw.model.DatosPago;
import com.miw.model.Extras;
import com.miw.model.ViajeElegido;

@Controller
@RequestMapping("mostrarReservaIdaVuelta")
public class MostrarReservaIdaVueltaController {
	
	@Autowired
	private JavaMailSender mailSender;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String mostrarReservaIdaVuelta (Model model, HttpSession session) {
		System.out.println("Ejecutando mostrarReservaIdaVuelta.");
		
		ViajeElegido viajeElegido = (ViajeElegido)session.getAttribute("viajeElegido");
		Extras extras = (Extras)session.getAttribute("extraElegido");
		DatosPago datosPago = (DatosPago)session.getAttribute("datosPago");
		Integer idReserva = (Integer)session.getAttribute("idReserva");
		
		model.addAttribute("viajeElegido", viajeElegido);
		model.addAttribute("extraElegido", extras);
		model.addAttribute("datosPago", datosPago);
		model.addAttribute("idReserva", idReserva);
		
		return "mostrarReservaIdaVuelta";
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String mostrarReservaIda (@ModelAttribute("mostrarReservaIdaVuelta") Extras extra, Model model, HttpSession session) {
		
		ViajeElegido viajeElegido = (ViajeElegido)session.getAttribute("viajeElegido");
		Extras extras = (Extras)session.getAttribute("extraElegido");
		DatosPago datosPago = (DatosPago)session.getAttribute("datosPago");
		Integer idReserva = (Integer)session.getAttribute("idReserva");
		
		System.out.println(datosPago.getEmail());
		
		SimpleMailMessage simpleMessage = new SimpleMailMessage();
		simpleMessage.setTo(datosPago.getEmail());
		simpleMessage.setSubject("Reserva Alsia");
		
		
		simpleMessage.setText(
		
				"Número de reserva: "+idReserva+
				"\n\nIDA: "+
				"\nOrigen: "+viajeElegido.getOrigen()+
				"\nDestino: "+viajeElegido.getDestino()+
				"\nFecha de ida: "+viajeElegido.getFecha_ida()+
				"\nNúmero de viajeros: "+viajeElegido.getNum_viajeros()+
				"\nBicicleta: "+extras.isBicicleta()+
				"\nMascota: "+extras.isMascota()+
				"\nTabla de surf: "+extras.isTabla_surf()+
				"\nEsquíes: "+extras.isEsquies()+
				"\nSeguros: "+extras.isSeguro()+
				"\nNombre: "+datosPago.getNombre()+
				"\nApellidos: "+datosPago.getApellidos()+
				"\nTipo de identificación: "+datosPago.getTipo_identificacion()+
				"\nIdentificación: "+datosPago.getIdentificacion()+
				"\nCorreo electrónico: "+datosPago.getEmail()+
				
				"\n\nVUELTA: "+
				"\nOrigen: "+viajeElegido.getDestino()+
				"\nDestino: "+viajeElegido.getOrigen()+
				"\nFecha de ida: "+viajeElegido.getFecha_vuelta()+
				"\nNúmero de viajeros: "+viajeElegido.getNum_viajeros()+
				"\nBicicleta: "+extras.isBicicleta()+
				"\nMascota: "+extras.isMascota()+
				"\nTabla de surf: "+extras.isTabla_surf()+
				"\nEsquíes: "+extras.isEsquies()+
				"\nSeguros: "+extras.isSeguro()+
				"\nNombre: "+datosPago.getNombre()+
				"\nApellidos: "+datosPago.getApellidos()+
				"\nTipo de identificación: "+datosPago.getTipo_identificacion()+
				"\nIdentificación: "+datosPago.getIdentificacion()+
				"\nCorreo electrónico: "+datosPago.getEmail()
				
		);
		
		mailSender.send(simpleMessage);
		return "emailEnviado";
	}
	
	
	@ModelAttribute("mostrarReservaIdaVuelta")
	public Extras prepareModel() {
		System.out.println("Invocando prepareModel()");
		return new Extras();
	}
}
