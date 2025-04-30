/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Mantenimiento.Controller;

import javax.swing.JOptionPane;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author henry.catillo
 */
@Controller
public class ProyectoController {

    //Controlador para cargar la pagina
    @GetMapping("/saludo")
    public String cargarPagSaludo() {
        return "saludo"; //no es necesario colocar .html
    }

    // controlador para leer los daots y enviarlo a otra pagina
    @PostMapping("/saludare")
    public String leeryEnviar(@RequestParam(name = "txtNombre") String name, Model model) {
        model.addAttribute("mensaje", name);
        System.out.println(name);
        return "saludo";
    }
}
