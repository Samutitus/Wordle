package com.example.demo.model;

public class Letra {
    private char letra;
    
    private boolean correcto;
    
    private int posicion;
    
    private int posicionCorrecta;
    
    private boolean repetido;
    
    private int numRepetido;
    
    public Letra(boolean correcto, char letra, int posicion, int posicionCorrecta, boolean repetido, int numRepetido) {
        this.letra = letra;
        
        this.posicion = posicion;
        
        this.correcto = true;
        
        this.posicionCorrecta = posicionCorrecta;
        
        this.setRepetido(true);
        
        this.setNumRepetido(numRepetido);
    }
    public Letra(boolean correcto, char letra, int posicion, int posicionCorrecta) {
        this.letra = letra;
        
        this.posicion = posicion;
        
        this.correcto = true;
        
        this.posicionCorrecta = posicionCorrecta;
    }
    
    public Letra(boolean correcto,char letra, int posicion) {
        this.correcto = false;
        
        this.letra = letra;
        
        this.posicion = posicion;
        
        this.posicionCorrecta = -1;
    }
    
    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public int getPosicionCorrecta() {
        return posicionCorrecta;
    }

    public void setPosicionCorrecta(int posicionCorrecta) {
        this.posicionCorrecta = posicionCorrecta;
    }

    public boolean getCorrecto() {
        return correcto;
    }

    public void setCorrecto(boolean correcto) {
        this.correcto = correcto;
    }
	public boolean isRepetido() {
		return repetido;
	}
	public void setRepetido(boolean repetido) {
		this.repetido = repetido;
	}

	public int getNumRepetido() {
		return numRepetido;
	}

	public void setNumRepetido(int numRepetido) {
		this.numRepetido = numRepetido;
	}
}
