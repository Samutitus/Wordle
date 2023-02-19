package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Letra;



@Profile("medio")
@Repository
public class PalabrasRepositorioMedio implements IRepositoryPalabras{
	
    private List<Letra> word = List.of(
		new Letra(true, 'a', 0, 0),
		new Letra(true, 'g', 1, 1),
		new Letra(true, 'u', 2, 2),
		new Letra(true, 'a', 3, 3),
		new Letra(true, 's', 4, 4));
    	
	private List<String> historial = new ArrayList<>();
	private List<List<Letra>> historialIndex = new ArrayList<>();
	private int intentos = 10;
	
	private int letras= 5;

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
		this.intentos=10;
		this.historial = new ArrayList<>();	
		this.historialIndex= new ArrayList<>();
	}

	
	public int getLetras() {
		return letras;
	}

	@Override
	public List<List<Letra>> getHistoryIndex() {
		
		return historialIndex;
	}
	


}
