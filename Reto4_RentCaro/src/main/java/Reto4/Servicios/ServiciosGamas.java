/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto4.Servicios;


import Reto4.Entidades.Gamas;
import Reto4.Repositorio.RepositorioGama;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alex Mosquera
 */
@Service
public class ServiciosGamas {

    @Autowired
    private RepositorioGama metodosCrud;

    public List<Gamas> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Gamas> getGama(int idGama) {
        return metodosCrud.getGama(idGama);
    }

    public Gamas save(Gamas gamas) {
        if (gamas.getIdGama() == null) {
            return metodosCrud.save(gamas);
        } else {
            Optional<Gamas> evt = metodosCrud.getGama(gamas.getIdGama());
            if (evt.isEmpty()) {
                return metodosCrud.save(gamas);
            } else {
                return gamas;
            }
        }
    }

    public Gamas update(Gamas gama) {
        if (gama.getIdGama() != null) {
            Optional<Gamas> g = metodosCrud.getGama(gama.getIdGama());
            if (!g.isEmpty()) {
                if (gama.getDescription() != null) {
                    g.get().setDescription(gama.getDescription());
                }
                if (gama.getName() != null) {
                    g.get().setName(gama.getName());
                }
                return metodosCrud.save(g.get());
            }
        }
        return gama;
    }

    public boolean deleteGamas(int gamaidGama) {
        Boolean d = getGama(gamaidGama).map(gama -> {
            metodosCrud.delete(gama);
            return true;
        }).orElse(false);
        return d;
    }

}
