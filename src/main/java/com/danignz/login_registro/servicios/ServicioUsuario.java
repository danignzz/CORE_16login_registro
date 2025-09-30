package com.danignz.login_registro.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Base64;

import com.danignz.login_registro.modelos.Usuario;
import com.danignz.login_registro.repositorios.RepositorioUsuario;

@Service
public class ServicioUsuario {
    @Autowired
    private RepositorioUsuario repositorioUsuario;

    public void guardarUsuario(Usuario usuario) {
    
        String contrasenaEncriptada = Base64.getEncoder().encodeToString(usuario.getContrasena().getBytes());
        usuario.setContrasena(contrasenaEncriptada);

        repositorioUsuario.save(usuario);
    }

    public boolean existeUsuario(String nombreUsuario) {
        return repositorioUsuario.findByNombreUsuario(nombreUsuario) != null;
    }


    public Usuario buscarPorCorreo(String correo) {
    return repositorioUsuario.findFirstByCorreo(correo).orElse(null);
}

    public boolean verificarContrasena(String contrasenaSinEncriptar, String contrasenaEncriptada) {
        String contrasenaCodificada = Base64.getEncoder().encodeToString(contrasenaSinEncriptar.getBytes());
        return contrasenaCodificada.equals(contrasenaEncriptada);
    }
}
