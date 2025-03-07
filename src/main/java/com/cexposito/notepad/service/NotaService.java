package com.cexposito.notepad.service;

import com.cexposito.notepad.model.Nota;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NotaService {
    private List<Nota> notas = new ArrayList<>();
    private int contadorId=1;

    public List<Nota> getNotas() {
        return notas;
    }

    public Optional<Nota> obtenerPorId(int id){
        return notas.stream().filter(n -> n.getId() == id).findFirst();
    }

    public Nota agregarNota(String titulo, String contenido){
        Nota nota = new Nota(contadorId++, titulo, contenido);
        notas.add(nota);
        return nota;
    }

    public Optional<Nota> actualizarNota(int id, String titulo, String contenido){
        Optional<Nota> nota = obtenerPorId(id);
        nota.ifPresent(n -> {
            n.setTitulo(titulo);
            n.setContenido(contenido);
        });
        return nota;
    }

    public boolean eliminarNota(int id){
        return notas.removeIf(n -> n.getId() == id);
    }
}
