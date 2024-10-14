package com.parcial.parcial2;

import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RequestMapping("/dispositivo")
@RestController
public class DispositivoControlador {
    private Map<String, Dispositivo> dispositivos = new HashMap<>();

    @PostMapping
    public ResponseEntity<Dispositivo> createDispositivo(@RequestBody Map<String, String> body) {
        DispositivoBuider buider = new DispositivoBuider(body.get("tipo"))
                .setTipo(body.get("tipo"))
                .setCPU(body.get("cpu"))
                .setRAM(body.get("ram"))
                .setALMACENAMIENTO(body.get("almacenamiento"))
                .setOS(body.get("os"));
        Dispositivo dispositivo = buider.build();
        dispositivo.setId(UUID.randomUUID().toString());
        dispositivos.put(dispositivo.getId(), dispositivo);
        return ResponseEntity.ok(dispositivo);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Dispositivo> getDispositivo(@PathVariable String id) {
        Dispositivo dispositivo = dispositivos.get(id);
        if (dispositivo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dispositivo);
    }

    @GetMapping
    public ResponseEntity<List<Dispositivo>> getDispositivos() {
        return ResponseEntity.ok(new ArrayList<>(dispositivos.values()));
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<Dispositivo>> getDispositivosByTipo(@PathVariable String tipo) {

        // Filtrar los dispositivos por tipo
        List<Dispositivo> dispositivosFiltrados = dispositivos.values().stream()
                .filter(dispositivo -> dispositivo.getTipo().equalsIgnoreCase(tipo)) // Filtro por tipo (ignorando mayúsculas)
                .collect(Collectors.toList());

        // Retornar los dispositivos filtrados
        return ResponseEntity.ok(dispositivosFiltrados);
    }
}
