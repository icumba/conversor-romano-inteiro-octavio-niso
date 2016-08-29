package br.com.caelum.servletController;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.domain.ConvertRomanoToNatural;

@Controller
public class ConversorController {

	@RequestMapping("efectuarConversao")
	public String converte(@Valid ConvertRomanoToNatural conversor, Model result){
		
		/*if(result.hasFieldErrors()){
			return "index";
		}*/
		//String s = ;
		
		
		result.addAttribute("resultadoFinal", conversor.retornaNumeroNatural(conversor.getRomanString()));
		
		
		return "resultado";
	}
	
	@RequestMapping("converte")
	public String converte(){
		
		return "formulario";
	}
	
}
