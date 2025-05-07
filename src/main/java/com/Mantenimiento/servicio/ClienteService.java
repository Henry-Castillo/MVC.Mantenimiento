/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Mantenimiento.servicio;

import com.Mantenimiento.model.Cliente;
import com.Mantenimiento.repository.IClientRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author henry.catillo
 */
@Service
public class ClienteService {

    @Autowired
    private IClientRepository repoCli;

    public ClienteService(IClientRepository r) {
        this.repoCli = r;
    }

    public List<Cliente> listar() {
        return repoCli.findAll();
    }

    public Cliente obtener(Long id) {
        return repoCli.findById(id).orElse(null);
    }

    public Cliente guardar(Cliente c) {
        return repoCli.save(c);
    }

    public void eliminar(Long id) {
        repoCli.deleteById(id);
    }
}
