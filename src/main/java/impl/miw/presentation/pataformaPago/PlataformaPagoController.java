package impl.miw.presentation.pataformaPago;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.miw.business.ReservaManagerService;
import com.miw.model.DatosPago;
import com.miw.model.Extras;
import com.miw.model.ViajeElegido;


@Controller
@RequestMapping("introducirDatosPago")
public class PlataformaPagoController {

	@Autowired
	private ReservaManagerService reservaManagerService;
	
	public void setReservaManagerService(ReservaManagerService reservaManagerService) {
		this.reservaManagerService = reservaManagerService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String introducirDatosPago (Model model) {
		System.out.println("Ejecutando plataformaPago.");
		return "plataformaPago";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String processForm (@Valid @ModelAttribute("datosPago") DatosPago datos_pago, BindingResult result, Model model, HttpSession session) {
		session.setAttribute("datosPago", datos_pago);
		
		// Validamos con Validator
		PlataformaPagoValidator validator = new PlataformaPagoValidator();
		validator.validate(datos_pago, result);
		
		if (result.hasErrors()) {
			return "plataformaPago";
		}
		
		ViajeElegido viajeElegido = (ViajeElegido)session.getAttribute("viajeElegido");
		ViajeElegido viajeElegidoIda = (ViajeElegido)session.getAttribute("buscarViajesIda");
		ViajeElegido viajeElegidoIdaVuelta = (ViajeElegido)session.getAttribute("buscarViajesIdaVuelta");
		Extras extras = (Extras)session.getAttribute("extraElegido");
		
		if(viajeElegido.isVuelta()) {
			try {
				this.reservaManagerService.creaReservaIdavuelta(viajeElegido, viajeElegidoIdaVuelta, extras, datos_pago);
				session.setAttribute("idReserva", this.reservaManagerService.getId());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "redirect:mostrarReservaIdaVuelta";
		}
		else {
			try {
				this.reservaManagerService.creaReserva(viajeElegido, viajeElegidoIda, extras, datos_pago);
				session.setAttribute("idReserva", this.reservaManagerService.getId());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "redirect:mostrarReservaIda";
		}
	}
	
	@ModelAttribute("datosPago")
	public DatosPago prepareModel() {
		System.out.println("Invocando prepareModel()");
		return new DatosPago();
	}
}
