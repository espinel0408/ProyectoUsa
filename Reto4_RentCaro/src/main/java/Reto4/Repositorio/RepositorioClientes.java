/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto4.Repositorio;


import Reto4.Entidades.Clientes;
import Reto4.Interface.InterfaceCliente;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alex Mosquera
 */
@Repository
public class RepositorioClientes {
    @Autowired
    private InterfaceCliente crud1;

    public List<Clientes> getAll() {
        return (List<Clientes>) crud1.findAll();
    }

    public Optional<Clientes> getCliente(int id) {
        return crud1.findById(id);
    }

    public Clientes save(Clientes Client) {
        return crud1.save(Client);
    }
     public void delete(Clientes Client){
        crud1.delete(Client);
    } 
    
}
