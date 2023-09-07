package com.jesielvirtual.curso.controllers;

import com.jesielvirtual.curso.models.Usuario;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {

    @RequestMapping(value = "usuario")
    public Usuario getUser() {
        Usuario usuario = new Usuario();

        usuario.setNombre("Pepito");
        usuario.setApellido("Perez");
        usuario.setEmail("pepito.perez@gmail.com");
        usuario.setTelefono("1234567890");
        usuario.setPassword("asdasdasd");

        return usuario;
    }
}
