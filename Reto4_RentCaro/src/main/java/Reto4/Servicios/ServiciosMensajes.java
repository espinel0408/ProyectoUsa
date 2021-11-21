/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto4.Servicios;

import Reto4.Entidades.Mensajes;
import Reto4.Repositorio.RepositorioMensajes;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alex Mosquera
 */
@Service
public class ServiciosMensajes {

    @Autowired
    private RepositorioMensajes metodosCrud;

    public List<Mensajes> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Mensajes> getMensajes(int IdMessage) {
        return metodosCrud.getMensajes(IdMessage);
    }

    public Mensajes save(Mensajes message) {
        if (message.getIdMessage() == null) {
            return metodosCrud.save(message);
        } else {
            Optional<Mensajes> evt = metodosCrud.getMensajes(message.getIdMessage());
            if (evt.isEmpty()) {
                return metodosCrud.save(message);
            } else {
                return message;
            }
        }
    }

    public Mensajes update(Mensajes message) {
        if (message.getIdMessage() != null) {
            Optional<Mensajes> e = metodosCrud.getMensajes(message.getIdMessage());
            if (!e.isEmpty()) {
                if (message.getMessageText() != null) {
                    e.get().setMessageText(message.getMessageText());
                }
                metodosCrud.save(e.get());
                return e.get();
            } else {
                return message;
            }
        } else {
            return message;
        }
    }

    public boolean deleteMessage(int messageidMessage) {
        Boolean aBoolean = getMensajes(messageidMessage).map(message -> {
            metodosCrud.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
