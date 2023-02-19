package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Letra;



@Profile("dificil")
@Repository
public class PalabrasRepositorioDificil implements IRepositoryPalabras{
	
    private List<Letra> word = List.of(
		new Letra(true, 'a', 0, 0),
		new Letra(true, 'c', 1, 1),
		new Letra(true, 'u', 2, 2),
		new Letra(true, 'n', 3, 3),
		new Letra(true, 'a', 4, 4),
		new Letra(true, 'r', 5, 5),
		new Letra(true, 'a', 6, 6),
		new Letra(true, 'n', 7, 7));
    
    	
	private List<String> historial = new ArrayList<>();
	private List<List<Letra>> historialIndex = new ArrayList<>();
	private int intentos = 6;
	
	private int letras= 8;

	public int getIntentos() {
		return intentos;
	}

	public void quitarUnIntento() {
		this.intentos = this. intentos - 1;
	}

	public List<String> getHistory() {
		return historial;
	}

	public List<Letra> getLetra(){
		return word;
	}

	
	public void cleanHistory() {
		this.intentos=6;
		this.historial = new ArrayList<>();	
		this.historialIndex= new ArrayList<>();
	}

	
	public int getLetras() {
		return letras;
	}

	
	public List<List<Letra>> getHistoryIndex() {
		
		return historialIndex;
	}
	


}
