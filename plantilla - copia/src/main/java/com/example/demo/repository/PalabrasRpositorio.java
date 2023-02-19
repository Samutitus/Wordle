package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Letra;



@Profile("facil")
@Repository
public class PalabrasRpositorio implements IRepositoryPalabras{
	
    private List<Letra> word = List.of(
		new Letra(true, 'i', 0, 0),
		new Letra(true, 'i', 1, 1),
		new Letra(true, 'i', 2, 2));

	private List<String> historial = new ArrayList<>();
	private List<List<Letra>> historialIndex = new ArrayList<>();
	private int intentos = 20;
	
	private int letras= 3;

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
		this.intentos=20;
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
