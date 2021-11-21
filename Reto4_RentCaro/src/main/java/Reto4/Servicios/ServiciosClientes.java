/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto4.Servicios;


import Reto4.Entidades.Clientes;
import Reto4.Repositorio.RepositorioClientes;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alex Mosquera
 */
@Service
public class ServiciosClientes {

    @Autowired
    private RepositorioClientes metodosCrud;

    public List<Clientes> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Clientes> getCliente(int clientId) {
        return metodosCrud.getCliente(clientId);
    }

    public Clientes save(Clientes client) {
        if (client.getIdClient() == null) {
            return metodosCrud.save(client);
        } else {
            Optional<Clientes> evt = metodosCrud.getCliente(client.getIdClient());
            if (evt.isEmpty()) {
                return metodosCrud.save(client);
            } else {
                return client;
            }
        }
    }

    public Clientes update(Clientes client) {
        if (client.getIdClient() != null) {
            Optional<Clientes> e = metodosCrud.getCliente(client.getIdClient());
            if (!e.isEmpty()) {
                if (client.getName() != null) {
                    e.get().setName(client.getName());
                }
                if (client.getAge() != null) {
                    e.get().setAge(client.getAge());
                }
                if (client.getPassword() != null) {
                    e.get().setPassword(client.getPassword());
                }
                metodosCrud.save(e.get());
                return e.get();
            } else {
                return client;
            }
        } else {
            return client;
        }
    }

    public boolean deleteClient(int clientId) {
        Boolean aBoolean = getCliente(clientId).map(client -> {
            metodosCrud.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
