package impl.miw.presentation.pataformaPago;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;

import com.miw.model.DatosPago;

public class PlataformaPagoValidator {
	public boolean supports(Class<?> clazz) {
		// clase a validar
		return DatosPago.class.equals(clazz);
	}
	

	public void validate(Object target, Errors errors) {
		DatosPago datosPago = (DatosPago) target;
		
		if (!datosPago.getIdentificacion().equals("")) {
			// Validación NIF
			if (datosPago.getTipo_identificacion().equals("NIF")) {
				
			    Pattern pattern = Pattern.compile("(\\d{1,8})([TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke])");
			    Matcher matcher = pattern.matcher(datosPago.getIdentificacion());
			   
			    if (matcher.matches()) {
			        String letra = matcher.group(2);
			        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
			        int index = Integer.parseInt(matcher.group(1));
			        index = index % 23;
			        String reference = letras.substring(index, index + 1);

			        if (!reference.equalsIgnoreCase(letra)) {
			        	errors.rejectValue("identificacion", "", "el formato de identificación no es válido");
			        } 
			    } 
			    
			    else {
			    	errors.rejectValue("identificacion", "", "el formato del DNI no es válido");
			    }
			}
			
			// Validación NIE
			else if (datosPago.getTipo_identificacion().equals("NIE")) {
				
				Pattern niePattern = Pattern.compile("[XYZ][0-9]{7}[a-zA-Z]");
				
				if (!niePattern.matcher(datosPago.getIdentificacion()).matches()) {
						errors.rejectValue("identificacion", "", "el formato de NIE no es válido");
				}
			}
			
			// Validación Pasaporte 3let 6num
			else if (datosPago.getTipo_identificacion().equals("Pasaporte")) {
				
				Pattern niePattern = Pattern.compile("[a-zA-Z]{3}[0-9]{6}");
				
				if (!niePattern.matcher(datosPago.getIdentificacion()).matches()) {
						errors.rejectValue("identificacion", "", "el formato de pasaporte no es válido");
				}
			}
		}
		
	}

}
