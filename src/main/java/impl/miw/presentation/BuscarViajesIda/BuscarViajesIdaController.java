package impl.miw.presentation.BuscarViajesIda;

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
@RequestMapping("buscarViajesIda")
public class BuscarViajesIdaController {
	
	@Autowired
	private ViajeManagerService viajeManagerService;
	
	public void setBookManagerService(ViajeManagerService viajeManagerService) {
		this.viajeManagerService = viajeManagerService;
	}

	
	@RequestMapping(method = RequestMethod.GET)
	public String buscarViajesIda (Model model, HttpSession session) {
		System.out.println("Ejecutando buscarViajesIda.");
		ViajeElegido viajeElegido = (ViajeElegido)session.getAttribute("viajeElegido");

		model.addAttribute("viajeElegido", session.getAttribute("viajeElegido"));
		
		// Almacenamos en viaje elegido en el modelo
		try {
			model.addAttribute("viajelist", viajeManagerService.getViajes(viajeElegido.getOrigen(), viajeElegido.getDestino(), viajeElegido.getFecha_ida(), viajeElegido.getNum_viajeros()));
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
		// Retornamos el nombre de la vista buscarViajesIda
		return "buscarViajesIda";
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@ModelAttribute("buscarViajesIda") ViajeElegido viajeElegido, Model model, HttpSession session) {

		session.setAttribute("buscarViajesIda", viajeElegido);

		if(viajeElegido.getId_ida()==null) {
			return "redirect:elegirViajes";
		}
		else {
			return "redirect:elegirExtras";
		}	
	}
	
	
	@ModelAttribute("buscarViajesIda")
	public ViajeElegido prepareModel() {
		System.out.println("Invoking prepareModel()");
		return new ViajeElegido();
	}
}
