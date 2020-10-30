package impl.miw.presentation.elegirviajes;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.miw.business.ViajeManagerService;
import com.miw.model.ViajeElegido;


@Controller
@RequestMapping("elegirViajes")
public class ElegirViajesController {

	@Autowired
	private ViajeManagerService viajeManagerService;
	
	public void setViajeManagerService(ViajeManagerService viajeManagerService) {
		this.viajeManagerService = viajeManagerService;
	}

	
	@RequestMapping(method = RequestMethod.GET)
	public String elegirViajes (Model model) {
		System.out.println("Ejecutando elegirViajes.");
		try {
			model.addAttribute("origenes", viajeManagerService.getOrigenes());
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		try {
			model.addAttribute("destinos", viajeManagerService.getDestinos());
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		Integer[] plaza = new Integer[8];
		for (int i=0; i<8; i++) {
			plaza[i] = i+1;
		}
		model.addAttribute("plazas", plaza);
		return "elegirViajes";
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String processForm (@Valid @ModelAttribute("viajeElegido") ViajeElegido viajeElegido, BindingResult result, Model model, HttpSession session) {
		
		// Validamos con Validator
		ElegirViajesValidator validator = new ElegirViajesValidator();
		validator.validate(viajeElegido, result);
		
		
		// Se comprueba y define si hay viaje de vuelta
		if(viajeElegido.getFecha_vuelta().equals("")) {
			viajeElegido.setVuelta(false);
		}
		else {
			viajeElegido.setVuelta(true);
		}
				
		if (result.hasErrors()) {
			try {
				model.addAttribute("origenes", viajeManagerService.getOrigenes());
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				model.addAttribute("destinos", viajeManagerService.getDestinos());
			} catch (Exception e) {
				e.printStackTrace();
			}
			Integer[] plaza = new Integer[8];
			for (int i=0; i<8; i++) {
				plaza[i] = i+1;
			}
			model.addAttribute("plazas", plaza);
			return "elegirViajes";
		}
		
		session.setAttribute("viajeElegido", viajeElegido);
		if(viajeElegido.getFecha_vuelta().equals("")) {
			return "redirect:buscarViajesIda";
		}
		return "redirect:buscarViajesIdaVuelta";
	}
	
	
	@ModelAttribute("viajeElegido")
	public ViajeElegido prepareModel() {
		System.out.println("Invocando prepareModel()");
		return new ViajeElegido();
	}
}
