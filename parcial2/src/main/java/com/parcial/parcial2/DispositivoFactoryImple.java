package com.parcial.parcial2;

public class DispositivoFactoryImple implements DispositivoFactory {
    //implementacion del factory metodo
    @Override
    public Dispositivo crearDispositivo(String tipo){
        if (tipo.equalsIgnoreCase("laptop")){
            return new Lapto();
        } else if (tipo.equalsIgnoreCase("smartphone")) {
            return new Smarphone();
        } else if (tipo.equalsIgnoreCase("tablet")) {
            return new Table();
        }
        throw new IllegalArgumentException("Tipo de dispositivo no valido");
    }
}
