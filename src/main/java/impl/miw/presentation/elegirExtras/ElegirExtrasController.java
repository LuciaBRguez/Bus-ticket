package impl.miw.presentation.elegirExtras;

import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.miw.model.Extras;

@Controller
@RequestMapping("elegirExtras")
public class ElegirExtrasController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String elegirViajes (Model model) {
		System.out.println("Ejecutando elegirExtras.");
		return "elegirExtras";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String processForm (@ModelAttribute("extraElegido") Extras extra, Model model, HttpSession session) {
		session.setAttribute("extraElegido", extra);
		return "redirect:introducirDatosPago";
	}
	
	@ModelAttribute("extraElegido")
	public Extras prepareModel() {
		System.out.println("Invocando prepareModel()");
		return new Extras();
	}
}
