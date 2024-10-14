package com.parcial.parcial2;

//implementacion del singlento
public class FactorySingleton {
    private static FactorySingleton instance;
    private DispositivoFactory dispositivoFactory;

    private FactorySingleton() {
        dispositivoFactory = new DispositivoFactoryImple();
    }
    public static synchronized FactorySingleton getInstance() {
        if(instance == null) {
            instance = new FactorySingleton();
        }
        return instance;
    }

    public DispositivoFactory getDispositivoFactory() {
        return dispositivoFactory;
    }
}
