/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto4.Web;

import Reto4.Entidades.Gamas;
import Reto4.Servicios.ServiciosGamas;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Alex Mosquera
 */
@RestController
@RequestMapping("/api/Gama")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class GamasWeb {

        @Autowired
    private ServiciosGamas servicios;

    @GetMapping("/all")
    public List<Gamas> getGama() {
        return servicios.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Gamas> getGama(@PathVariable("id") int idGama) {
        return servicios.getGama(idGama);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Gamas save(@RequestBody Gamas gamas) {
        return servicios.save(gamas);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Gamas update(@RequestBody Gamas gama) {
        return servicios.update(gama);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int gamaidGama) {
        return servicios.deleteGamas(gamaidGama);
    }
}
