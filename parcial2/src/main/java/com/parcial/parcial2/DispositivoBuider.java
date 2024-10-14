package com.parcial.parcial2;

public class DispositivoBuider {
    //configuracion de los dispositivos usando el patron builder
    private Dispositivo dispositivo;

    public DispositivoBuider(String tipo){
        this.dispositivo =  FactorySingleton.getInstance().getDispositivoFactory().crearDispositivo(tipo);
    }

    public DispositivoBuider setCPU(String cpu){
        this.dispositivo.setCpu(cpu);
        return this;
    }

    public DispositivoBuider setRAM(String ram){
        this.dispositivo.setRam(ram);
        return this;
    }

    public DispositivoBuider setALMACENAMIENTO(String almacenamiento){
        this.dispositivo.setAlmacenamiento(almacenamiento);
        return this;
    }

    public DispositivoBuider setOS(String os){
        this.dispositivo.setOs(os);
            return this;
    }

    public DispositivoBuider setTipo(String tipo) {
        this.dispositivo.setTipo(tipo);
        return this;
    }

    public Dispositivo build() {
        return this.dispositivo;
    }



}
