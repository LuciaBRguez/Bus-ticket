package impl.miw.presentation.cancelarReserva;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.miw.business.ReservaManagerService;
import com.miw.model.ReservaCancelada;

@Controller
@RequestMapping ("cancelarReserva")
public class CancelarReservaController {
	
	@Autowired
	private ReservaManagerService reservaManagerService;
	
	public void setReservaManagerService(ReservaManagerService reservaManagerService) {
		this.reservaManagerService = reservaManagerService;
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String cancelReserva(Model model)
	{
		return "cancelarReserva";
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@ModelAttribute("cancelarReserva") ReservaCancelada reservaCancelada, Model model) {
	
		try {
			if(!this.reservaManagerService.existeReserva(reservaCancelada.getEmail(), reservaCancelada.getId())) {
				return "reservaNoEncontrada";
			}	
			else {
				this.reservaManagerService.eliminarReserva(reservaCancelada.getEmail(), reservaCancelada.getId());
				return "reservaEliminada";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
	}
	
	
	@ModelAttribute("cancelarReserva")
	public ReservaCancelada prepareModel() {
		System.out.println("Invoking prepareModel()");
		return new ReservaCancelada();
	}

}
