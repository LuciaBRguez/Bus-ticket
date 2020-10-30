package impl.miw.presentation;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class WelcomeController {
	
	@RequestMapping("/")
	public String welcome(Model model, HttpServletRequest request)
	{
		int contador_visitas = 1;
		if(request.getServletContext().getAttribute("visitas")==null) {
			request.getServletContext().setAttribute("visitas", 1);
		}
		else {
			contador_visitas = (Integer) request.getServletContext().getAttribute("visitas");
			request.getServletContext().setAttribute("visitas", contador_visitas);
			contador_visitas++;
		}
		
		model.addAttribute("visitas", contador_visitas);
		return "index";
	}
	
}
