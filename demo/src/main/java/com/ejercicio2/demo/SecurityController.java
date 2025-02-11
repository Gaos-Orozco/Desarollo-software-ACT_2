package com.ejercicio2.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")

public class SecurityController {

    @GetMapping ("/public/hello")
    public String PublicEndpoint(){
        return "Este es un endpoint publico";
    }

    @GetMapping ("/admin/dashboard")
    public String adminEndpoint(){
        return "Bienvenido al panel de administracion";
    }

    @GetMapping ("/cliente/functions")
    public String clienteEndpoint(){
        return "Bienvenido a las funciones de cliente";
    }
}


