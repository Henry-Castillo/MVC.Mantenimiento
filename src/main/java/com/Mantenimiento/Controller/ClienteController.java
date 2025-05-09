/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Mantenimiento.Controller;

import com.Mantenimiento.model.Cliente;
import com.Mantenimiento.servicio.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author henry.catillo
 */
@RestController
@RequestMapping("/api")
public class ClienteController {

    //obj de repositorio
    @Autowired
    private ClienteService serCli;

    //Controlador para cargar la pag y enviar los datos a guardar
    /* @GetMapping("/cargar")
    public String cargaryEnviarDatos(Model model, @RequestParam(required = false) Long id) {
        model.addAttribute("clientes", serCli.listar());
        model.addAttribute("cliente", id != null ? serCli.obtener(id) : new Cliente());
        return "crudclientes";
    }
     */
    public ClienteController(ClienteService s) {
        this.serCli = s;
    }

    @GetMapping("/clientes")
    public List<Cliente> getAll() {
        return serCli.listar();    // serializa a JSON
    }

    @GetMapping("/clientes/{id}")
    public Cliente obtenerCliente(@PathVariable Long id){
        return serCli.obtener(id);
    }
    
    @PostMapping("/cargar")
    public Cliente guardarCliente(@RequestBody Cliente c) {
        System.out.println("Recibido cliente: " + c.getNombre());
        return serCli.guardar(c);

    }
    
    @PutMapping("/clientes")
    public Cliente actualizarCliente(@RequestBody Cliente c) {
        System.out.println("Actualizando Cliente: " + c.getNombre());
        return serCli.guardar(c);
    }

    //Controlador para leer los datos ingresados
    /*@PostMapping("/cargar")
    public String leerDatosCrud(@ModelAttribute Cliente cliente, Model model) {
        serCli.guardar(cliente);
        return "redirect:/cargar";
    }*/
    @DeleteMapping("/clientes/{id}")
    public void eliminarCliente(@PathVariable Long id) {
        serCli.eliminar(id);
    }

}
