package com.danignz.login_registro.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.danignz.login_registro.modelos.Usuario;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Long>{
     Usuario findByNombreUsuario(String nombreUsuario);
     Optional<Usuario> findFirstByCorreo(String correo);
    
}
