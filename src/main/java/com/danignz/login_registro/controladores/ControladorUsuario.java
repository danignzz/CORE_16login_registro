package com.danignz.login_registro.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.danignz.login_registro.modelos.Usuario;
import com.danignz.login_registro.servicios.ServicioUsuario;

import jakarta.validation.Valid;

@Controller
public class ControladorUsuario {
    @Autowired
    private ServicioUsuario servicioUsuario;

     @GetMapping("/")
    public String mostrarIndex(Model modelo) {
        modelo.addAttribute("usuario", new Usuario()); 
        modelo.addAttribute("login", new Usuario());   
        return "index";
    }
    @PostMapping("/procesa/registro")
    public String procesarRegistro(@Valid @ModelAttribute("usuario") Usuario usuario,
        BindingResult result,
        Model modelo) {

        if (servicioUsuario.existeUsuario(usuario.getNombreUsuario())) {
            result.rejectValue("nombreUsuario", "error.usuario", "Nombre de usuario ya existe");
        }

        if (!usuario.getContrasena().equals(usuario.getConfirmacionContrasena())) {
            result.rejectValue("confirmacionContrasena", "error.confirmacionContrasena", "Las contraseñas no coinciden");
        }

        if (result.hasErrors()) {
            modelo.addAttribute("login", new Usuario()); 
            return "index";
        }

        servicioUsuario.guardarUsuario(usuario);

        return "redirect:/inicio";
    }
    
   @PostMapping("/procesa/login")
public String procesarLogin(@ModelAttribute("login") Usuario login,
                            Model modelo) {
    Usuario usuarioBD = servicioUsuario.buscarPorCorreo(login.getCorreo());

    if (usuarioBD == null || !servicioUsuario.verificarContrasena(login.getContrasena(), usuarioBD.getContrasena())) {
        modelo.addAttribute("errorLogin", "Correo o contraseña incorrectos");
        modelo.addAttribute("usuario", new Usuario());
        return "index";
    }

    return "redirect:/inicio";
}

    @GetMapping("/inicio")
    public String mostrarInicio() {
        return "inicio";
    }
}

