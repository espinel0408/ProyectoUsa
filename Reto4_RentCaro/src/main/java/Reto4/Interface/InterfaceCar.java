/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reto4.Interface;

import Reto4.Entidades.Cars;
import org.springframework.data.repository.CrudRepository;


/**
 *
 * @author Alex Mosquera
 */
public interface InterfaceCar extends CrudRepository<Cars, Integer>{
    
}
