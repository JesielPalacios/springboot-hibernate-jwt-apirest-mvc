package com.jesielvirtual.curso.controllers;

import com.jesielvirtual.curso.dao.UsuarioDao;
import com.jesielvirtual.curso.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "api/usuario/{usuarioId}")
    public Usuario obtenerUnUsuario(@PathVariable Long usuarioId) {
        Usuario usuario = new Usuario();

        usuario.setId(usuarioId);
        usuario.setNombre("Pepito");
        usuario.setApellido("Perez");
        usuario.setEmail("pepito.perez@gmail.com");
        usuario.setTelefono("1234567890");
        usuario.setPassword("asdasdasd");

        return usuario;
    }

    @RequestMapping(value = "api/usuarios")
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioDao.getUsuarios();
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void agregarUnSoloUsuario(@RequestBody Usuario usuario) {

        Argon2 argon2Encrypt = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2Encrypt.hash(10, 1024, 1, usuario.getPassword());
        usuario.setPassword(hash);

        usuarioDao.registrar(usuario);
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

    @RequestMapping(value = "api/usuario/{usuarioId}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long usuarioId) {
        usuarioDao.eliminar(usuarioId);
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
