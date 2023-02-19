package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import com.example.demo.model.Letra;
import com.example.demo.service.IServiceLetra;

@Controller
public class IndexController {

    @Autowired
	IServiceLetra service;


    @GetMapping("/")
	public ModelAndView checkword() {
		ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("Attempts", service.getIntentos());
        modelAndView.addObject("numLetras", service.getLetras());
        return modelAndView;
	}
    @PostMapping("/comprobar")
	public ModelAndView comprobarPalabra(String word) {
		List<Letra> list = service.comprobar(word);
		List<List<Letra>> history = service.getHistoryIndex();
		
        boolean fin = false;
        if (list != null) {
            for (Letra leter : list) {
                if(leter.getCorrecto() && leter.getPosicion() == leter.getPosicionCorrecta()){
                    fin = true;
                }else{
                    fin = false;
                    break;
                }
            }
        }
        ModelAndView modelAndView;
        if (fin) {
            modelAndView = new ModelAndView("fin");
        }else{
            modelAndView = new ModelAndView("index");
        }
        modelAndView.addObject("word", list);
        modelAndView.addObject("historial", history);
        modelAndView.addObject("Attempts", service.getIntentos());
        modelAndView.addObject("numLetras", service.getLetras());
        return modelAndView;
	}
    @PostMapping("/limpiarHistorial")
   	public ModelAndView clean() {
    	List<Letra> list = new ArrayList<Letra>();
   		ModelAndView modelAndView = new ModelAndView("index");
   		service.clean();
        modelAndView.addObject("Attempts", service.getIntentos());
        modelAndView.addObject("numLetras", service.getLetras());
        modelAndView.addObject("word", list );
        return modelAndView;
   	} 
    @PostMapping("/search")
	public ModelAndView searchword(int number) {
		String resultado = service.getWordByPos(number);
        if (resultado == null) {
        	resultado = "No existe";
        }
		ModelAndView modelAndView = new ModelAndView("fin");
        modelAndView.addObject("posicion", number);
        modelAndView.addObject("resultado", resultado);
        modelAndView.addObject("Attempts", service.getIntentos());
        return modelAndView;
	}
}
