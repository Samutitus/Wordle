package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Letra;
import com.example.demo.repository.IRepositoryPalabras;

@Service
public class ServiceLetra implements IServiceLetra {

    @Autowired
	private IRepositoryPalabras repo;
	

    @Override
    public List<Letra> comprobar(String word){
        List<Letra> list = new ArrayList<Letra>();
        List<Integer> listaNumRepe= new ArrayList<Integer>();
        List<String> listarepe=new ArrayList<String>();
        List<Character> letrasRepetidas= new ArrayList<Character>();
        int placeholder;
        if(word.length() != repo.getLetra().size() || repo.getIntentos() <= 0){
            return null;	
        }   
        for (int i=0;i<word.length();i++) {
        	int repeticiones=0;
        	for (int j = 0; j < repo.getLetra().size(); j++) {
        		if(word.charAt(i)==repo.getLetra().get(j).getLetra()) {
        			repeticiones++;
        			if(repeticiones==2) {
        				if(letrasRepetidas.contains(word.charAt(i))){
        					listarepe.add("no");
        				}
        				else {
        					listarepe.add("si");
        					letrasRepetidas.add(word.charAt(i));
        				}
        			}
        		}
        	}
        	if(repeticiones<2){
        		listarepe.add("no");
            }  
        	listaNumRepe.add(repeticiones);
        }
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == repo.getLetra().get(i).getLetra()){
            	if(listarepe.get(i)=="si") {
            		placeholder=listaNumRepe.get(i);
            		list.add(new Letra(true, word.charAt(i), i, i,true, placeholder));
            		
            		continue;
            	}else {
            		list.add(new Letra(true, word.charAt(i), i, i)) ;                
            		continue;
            	}
            }
                boolean found = false;
                for (int j = 0; j < repo.getLetra().size(); j++) {
                    if (word.charAt(i) == repo.getLetra().get(j).getLetra()){
                    	if(listarepe.get(i)=="si") {
                    		placeholder=listaNumRepe.get(i);
                    		list.add(new Letra(true, word.charAt(i), i, j, true, placeholder)) ;
                    		
                            found = true;
                            break;
                    	}else{
                    		list.add(new Letra(true, word.charAt(i), i, j)) ;
                            found = true;
                            break;
                    	}
                        
                    
                    }else{
                        found = false;
                    }
                }
                if (!found){
                    list.add(new Letra(false, word.charAt(i), i)) ;
                }
            
        }
        
        repo.getHistory().add(word);
        repo.quitarUnIntento();
        repo.getHistoryIndex().add(list);
        return list;
    }


    @Override
    public String getPallabraByPosicion(int pos){
        if (pos >= repo.getHistory().size() || pos < 0 ){
            return null;
        }
        return repo.getHistory().get(pos);
    }

    @Override
    public List<String> getHistorial(){
        return repo.getHistory();
    }

    @Override
    public int getIntentos(){
        return repo.getIntentos();
    }
    @Override
    public int getLetras(){
        return repo.getLetras();
    }


	@Override
	public List<Letra> clean() {
		repo.cleanHistory();
		List<Letra> list = new ArrayList<Letra>();
		
		return list;
		
	}
	@Override
    public List<List<Letra>> getHistoryIndex(){
        return repo.getHistoryIndex();
    }


	@Override
	public String getWordByPos(int number) {
		 
		if (number >= repo.getHistory().size() || number < 0){
            return null;
        }
        return repo.getHistory().get(number);
	}


}

