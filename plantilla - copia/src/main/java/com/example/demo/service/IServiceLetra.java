package com.example.demo.service;

import java.util.List;


import com.example.demo.model.Letra;




public interface IServiceLetra {
	public List<Letra> comprobar(String word);
	
    public List<String> getHistorial();
    
    public String getPallabraByPosicion(int pos);
    
    public int getIntentos();
    
    public List<Letra> clean();
    
    public int getLetras();
    
    public List<List<Letra>> getHistoryIndex();

	public String getWordByPos(int number);
    
    
}
