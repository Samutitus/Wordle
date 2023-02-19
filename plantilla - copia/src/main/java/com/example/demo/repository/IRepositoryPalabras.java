package com.example.demo.repository;

import java.util.List;


import com.example.demo.model.Letra;

public interface IRepositoryPalabras {
	
	 public List<String> getHistory();
	 
	 public List<List<Letra>> getHistoryIndex();
	 
	    public int getIntentos();
	    
	    public void quitarUnIntento();
	    
	    List<Letra> getLetra();
	    
	    public int getLetras();
	    
	    public void  cleanHistory();
}
