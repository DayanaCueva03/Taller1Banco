package com.itsqmet.Taller1.Service;

import com.itsqmet.Taller1.Repositorio.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private userRepository usuarioRepository;



}
