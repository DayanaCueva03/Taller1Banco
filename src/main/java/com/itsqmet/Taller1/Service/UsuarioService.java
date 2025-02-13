/*package com.itsqmet.Taller1.Service;

import com.itsqmet.Taller1.Entidad.Usuario;
import com.itsqmet.Taller1.Repositorio.userRepository;
import com.itsqmet.Taller1.Rol.Rol;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UsuarioService {
    @Autowired
    private userRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    //Registrar Usuario
    @Transactional
    public void registrarUsuario(Long id, String username, String password, Long clienteID, Rol rol) {
        Usuario usuario;

        if (id != null) {
            usuario = usuarioRepository.findById(id).orElse(new Usuario());
        } else {
            usuario = new Usuario();
        }
        usuario.setUsername(username);
        usuario.setPassword(passwordEncoder.encode(password));
        usuario.setClienteID(clienteID);

        if (rol == null) {
            usuario.setRol(Rol.CLIENTE);
        } else {
            usuario.setRol(rol);
        }

        usuarioRepository.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username);

    }








}*/
