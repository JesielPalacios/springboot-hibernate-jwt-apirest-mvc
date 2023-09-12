package com.jesielvirtual.curso.controllers;

import com.jesielvirtual.curso.dao.UsuarioDao;
import com.jesielvirtual.curso.models.Usuario;
import com.jesielvirtual.curso.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/inicio-sesion", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario) {

        Usuario usuarioDelLogin = usuarioDao.obtenerUsuarioPorCredenciales(usuario);
        if (usuarioDelLogin != null) {

            String tokenJwt = jwtUtil.create(String.valueOf(usuarioDelLogin.getId()), usuarioDelLogin.getEmail());
            return tokenJwt;
        }

        return "FAIL";
    }
}
