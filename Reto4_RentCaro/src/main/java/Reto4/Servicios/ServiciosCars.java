/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto4.Servicios;

import Reto4.Entidades.Cars;
import Reto4.Repositorio.RepositorioCars;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alex Mosquera
 */
@Service
public class ServiciosCars {

    @Autowired
    private RepositorioCars metodosCrud;

    public List<Cars> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Cars> getCars(int idCar) {
        return metodosCrud.getCars(idCar);
    }

    public Cars save(Cars car) {
        if (car.getIdCar() == null) {
            return metodosCrud.save(car);
        } else {
            Optional<Cars> evt = metodosCrud.getCars(car.getIdCar());
            if (evt.isEmpty()) {
                return metodosCrud.save(car);
            } else {
                return car;
            }
        }
    }

    public Cars update(Cars car) {
        if (car.getIdCar() != null) {
            Optional<Cars> e = metodosCrud.getCars(car.getIdCar());
            if (!e.isEmpty()) {
                if (car.getName() != null) {
                    e.get().setName(car.getName());
                }
                if (car.getBrand() != null) {
                    e.get().setBrand(car.getBrand());
                }
                if (car.getYear() != null) {
                    e.get().setYear(car.getYear());
                }
                if (car.getDescription() != null) {
                    e.get().setDescription(car.getDescription());
                }
                if (car.getGama() != null) {
                    e.get().setGama(car.getGama());
                }
                metodosCrud.save(e.get());
                return e.get();
            } else {
                return car;
            }
        } else {
            return car;
        }
    }

    public boolean deleteCar(int carroidCar) {
        Boolean aBoolean = getCars(carroidCar).map(car -> {
            metodosCrud.delete(car);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
