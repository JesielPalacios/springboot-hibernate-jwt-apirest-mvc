package com.jesielvirtual.curso.dao;

import com.jesielvirtual.curso.models.Usuario;

import java.util.List;

public interface UsuarioDao {

    List<Usuario> getUsuarios();

    void eliminar(Long usuarioId);

    void registrar(Usuario usuario);

    boolean verificarCredenciales(Usuario usuario);
}
