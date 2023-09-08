package com.jesielvirtual.curso.controllers;

import com.jesielvirtual.curso.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {

    @RequestMapping(value = "usuario/{usuarioId}")
    public Usuario getUser(@PathVariable Long usuarioId) {
        Usuario usuario = new Usuario();

        usuario.setId(usuarioId);
        usuario.setNombre("Pepito");
        usuario.setApellido("Perez");
        usuario.setEmail("pepito.perez@gmail.com");
        usuario.setTelefono("1234567890");
        usuario.setPassword("asdasdasd");

        return usuario;
    }

    @RequestMapping(value = "usuario1")
    public Usuario modificar() {
        Usuario usuario = new Usuario();

        usuario.setNombre("Pepito");
        usuario.setApellido("Perez");
        usuario.setEmail("pepito.perez@gmail.com");
        usuario.setTelefono("1234567890");
        usuario.setPassword("asdasdasd");

        return usuario;
    }

    @RequestMapping(value = "usuario2")
    public Usuario eliminar() {
        Usuario usuario = new Usuario();

        usuario.setNombre("Pepito");
        usuario.setApellido("Perez");
        usuario.setEmail("pepito.perez@gmail.com");
        usuario.setTelefono("1234567890");
        usuario.setPassword("asdasdasd");

        return usuario;
    }

    @RequestMapping(value = "usuario3")
    public Usuario buscar() {
        Usuario usuario = new Usuario();

        usuario.setNombre("Pepito");
        usuario.setApellido("Perez");
        usuario.setEmail("pepito.perez@gmail.com");
        usuario.setTelefono("1234567890");
        usuario.setPassword("asdasdasd");

        return usuario;
    }
}
