package impl.miw.presentation.elegirviajes;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.miw.model.ViajeElegido;


public class ElegirViajesValidator implements Validator {
	
	public boolean supports(Class<?> clazz) {
		// Clase a validar
		return ViajeElegido.class.equals(clazz);
	}
	

	public void validate (Object target, Errors errors) {
		ViajeElegido viajeElegido = (ViajeElegido) target;
		if(viajeElegido.getFecha_vuelta().equals("")) {
			try {
				SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
				formatoFecha.setLenient(false);
				formatoFecha.parse(viajeElegido.getFecha_ida());
			} catch (ParseException e) {
				errors.rejectValue("fecha_ida", "", "formato de fecha incorrecto");
			}
		}
		else {
			try {
				SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
				formatoFecha.setLenient(false);
				formatoFecha.parse(viajeElegido.getFecha_ida());
			} catch (ParseException e) {
				errors.rejectValue("fecha_ida", "", "formato de fecha incorrecto");
			}
			try {
				SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
				formatoFecha.setLenient(false);
				formatoFecha.parse(viajeElegido.getFecha_vuelta());
			} catch (ParseException e) {
				errors.rejectValue("fecha_vuelta", "", "formato de fecha incorrecto");
			}
		}
	}

}
