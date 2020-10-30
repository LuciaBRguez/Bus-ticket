package impl.miw.presentation.buscarViajesIdaVuelta;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.miw.business.ViajeManagerService;
import com.miw.model.ViajeElegido;

@Controller
@RequestMapping("buscarViajesIdaVuelta")
public class BuscarViajesIdaVueltaController {
	
	@Autowired
	private ViajeManagerService viajeManagerService;
	
	public void setBookManagerService(ViajeManagerService viajeManagerService) {
		this.viajeManagerService = viajeManagerService;
	}

	
	@RequestMapping(method = RequestMethod.GET)
	public String buscarViajesIdaVuelta (Model model, HttpSession session) {
		System.out.println("Ejecutando buscarViajesIdaVuelta.");
		ViajeElegido viajeElegido = (ViajeElegido)session.getAttribute("viajeElegido");

		model.addAttribute("viajeElegido", session.getAttribute("viajeElegido"));
		
		// Almacenamos la lista de viaje elegido en el modelo
		try {
			model.addAttribute("viajeidalist", viajeManagerService.getViajes(viajeElegido.getOrigen(), viajeElegido.getDestino(), viajeElegido.getFecha_ida(), viajeElegido.getNum_viajeros()));
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		try {
			model.addAttribute("viajevueltalist", viajeManagerService.getViajes(viajeElegido.getDestino(), viajeElegido.getOrigen(), viajeElegido.getFecha_vuelta(), viajeElegido.getNum_viajeros()));
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		// Retornamos el nombre de la vista buscarViajesIdaVuelta
		return "buscarViajesIdaVuelta";
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@ModelAttribute("buscarViajesIdaVuelta") ViajeElegido viajeElegido, Model model, HttpSession session) {

		session.setAttribute("buscarViajesIdaVuelta", viajeElegido);
		
		if(viajeElegido.getId_ida()==null) {
			return "redirect:elegirViajes";
		}
		else {
			return "redirect:elegirExtras";
		}	
	}
	
	
	@ModelAttribute("buscarViajesIdaVuelta")
	public ViajeElegido prepareModel() {
		System.out.println("Invoking prepareModel()");
		return new ViajeElegido();
	}
}
