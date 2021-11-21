/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto4.Repositorio;


import Reto4.Entidades.Cars;
import Reto4.Interface.InterfaceCar;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alex Mosquera
 */
@Repository
public class RepositorioCars {
    @Autowired
    private InterfaceCar crud;
    
    public List<Cars> getAll(){
        return(List<Cars>) crud.findAll();  
    }
    
    public Optional <Cars> getCars(int id){
        return crud.findById(id);
    }
    
    public Cars save(Cars car){
        return crud.save(car);
    }
     public void delete(Cars car){
        crud.delete(car);
    }
    
}
