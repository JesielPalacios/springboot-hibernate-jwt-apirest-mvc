package com.jesielvirtual.curso.controllers;

import com.jesielvirtual.curso.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

    @RequestMapping(value = "usuarios")
    public List<Usuario> getUsers() {
        List <Usuario> usuarios = new ArrayList<>();
        Usuario usuario = new Usuario();

        usuario.setId(1234567890L);
        usuario.setNombre("Pepito");
        usuario.setApellido("Perez");
        usuario.setEmail("pepito.perez@gmail.com");
        usuario.setTelefono("1234567890");
        usuario.setPassword("asdasdasd");

        Usuario usuario2 = new Usuario();

        usuario2.setId(1234567891L);
        usuario2.setNombre("Lucas");
        usuario2.setApellido("Moy");
        usuario2.setEmail("lucas.moy@gmail.com");
        usuario2.setTelefono("1234567890");
        usuario2.setPassword("asdasdasd");

        Usuario usuario3 = new Usuario();

        usuario3.setId(1234567892L);
        usuario3.setNombre("Maria");
        usuario3.setApellido("Gonzales");
        usuario3.setEmail("eva.cifuentes@gmail.com");
        usuario3.setTelefono("1234567890");
        usuario3.setPassword("asdasdasd");

        usuarios.add(usuario);
        usuarios.add(usuario2);
        usuarios.add(usuario3);

        return usuarios;
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
