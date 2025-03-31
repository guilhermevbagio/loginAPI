
package guilhermevbagio.login.controller;


import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import guilhermevbagio.login.model.User;
import guilhermevbagio.login.service.AuthService;


@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")   
    public ResponseEntity<?> register(@RequestBody Map<String, String> payload) {
        User user = authService.registerUser(payload.get("username"), payload.get("password"));
        return ResponseEntity.ok(Map.of("message", "User registered", "userId", user.getId()));
    }

    @PostMapping("/login")   
    public ResponseEntity<?> login(@RequestBody Map<String, String> payload) {
        boolean authenticated = authService.authenticateUser(payload.get("username"), payload.get("password"));
        
        if(!authenticated) return ResponseEntity.badRequest().body(Map.of("error", "Invalid credentials"));

        return ResponseEntity.ok(Map.of("message", "User logged in"));
    }
}
