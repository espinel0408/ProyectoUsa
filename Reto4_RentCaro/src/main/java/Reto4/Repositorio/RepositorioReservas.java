/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto4.Repositorio;


import Reto4.Entidades.Clientes;
import Reto4.Reportes.ContadorClientes;
import Reto4.Entidades.Reservas;
import Reto4.Interface.InterfaceReserva;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alex Mosquera
 */
@Repository
public class RepositorioReservas {
    @Autowired
    private InterfaceReserva crud4;
    
    public List<Reservas> getAll() {
        return (List<Reservas>) crud4.findAll();
    }

    public Optional<Reservas> getReservas(int id) {
        return crud4.findById(id);
    }

    public Reservas save(Reservas reservation) {
        return crud4.save(reservation);
    }
     public void delete(Reservas reservation){
        crud4.delete(reservation);
    }
     
     public List<Reservas> ReservacionStatusRepositorio (String status){
         return crud4.findAllByStatus(status);
     }
     
     public List<Reservas> ReservacionTiempoRepositorio (Date a, Date b){
         return crud4.findAllByStartDateAfterAndStartDateBefore(a, b);
     
     }
     
     public List<ContadorClientes> getClientesRepositorio(){
         List<ContadorClientes> res = new ArrayList<>();
         List<Object[]> report = crud4.countTotalReservationsByClient();
         for(int i=0; i<report.size(); i++){
             res.add(new ContadorClientes((Long)report.get(i)[1],(Clientes) report.get(i)[0]));
         }
         return res;
     }

}
