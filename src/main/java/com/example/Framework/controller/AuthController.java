package com.example.Framework.controller;

import com.example.Framework.entity.Token;
import com.example.Framework.entity.Usuarios;
import com.example.Framework.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/auth")
public class AuthController {

    @Autowired
    private UsuariosService usuariosService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Optional<Usuarios> user = usuariosService.authenticateUser(loginRequest.getEmail(), loginRequest.getPassword());
        if (user.isPresent()) {
            Token token = usuariosService.findTokenByUser(user.get());  // Obtener el token del usuario desde el servicio
            if (token != null) {
                Long roleId = user.get().getRol().getId_rol();  // Obtener el ID del rol
                return ResponseEntity.ok(new LoginResponse(token.getToken(), roleId));
            }
        }
        return new ResponseEntity<>("Credenciales inválidas", HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestBody LogoutRequest logoutRequest) {
        usuariosService.logoutUser(logoutRequest.getToken());
        return new ResponseEntity<>("Logout exitoso", HttpStatus.OK);
    }

    // Clases internas para la solicitud y respuesta de login
    public static class LoginRequest {
        private String email;
        private String password;

        // Getters y setters
        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    public static class LoginResponse {
        private String token;
        private Long roleId;

        public LoginResponse(String token, Long roleId) {
            this.token = token;
            this.roleId = roleId;
        }

        // Getters y setters
        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public Long getRoleId() {
            return roleId;
        }

        public void setRoleId(Long roleId) {
            this.roleId = roleId;
        }
    }

    // Clase interna para la solicitud de logout
    public static class LogoutRequest {
        private String token;
        public String getToken() {
            return token; }
        public void setToken(String token) {
            this.token = token; }
    }
}
