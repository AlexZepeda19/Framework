package com.example.Framework.config;

import com.example.Framework.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class SchedulingConfig {

    @Autowired
    private UsuariosService usuariosService;

    // Ejecuta esta tarea cada minuto para limpiar tokens expirados
    @Scheduled(fixedRate = 60000)
    public void cleanUpExpiredTokens() {
        usuariosService.clearExpiredTokens();
    }
}
