/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto4.Repositorio;


import Reto4.Entidades.Gamas;
import Reto4.Interface.InterfaceGama;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alex Mosquera
 */
@Repository
public class RepositorioGama {
    @Autowired
    private InterfaceGama crud2;
    
    public List<Gamas> getAll(){
        return(List<Gamas>) crud2.findAll();  
    }
    
    public Optional <Gamas> getGama(int id){
        return crud2.findById(id);
    }
    
    public Gamas save(Gamas gama){
        return crud2.save(gama);
    }
    public void delete(Gamas gama){
        crud2.delete(gama);
    }
    
}
