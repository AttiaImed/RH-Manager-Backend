package com.mission.RHManager.Services.Impl;


import com.mission.RHManager.Entites.Auth.AuthenticationRequest;
import com.mission.RHManager.Entites.Auth.AuthenticationResponse;
import com.mission.RHManager.Entites.Auth.RegisterRequest;
import com.mission.RHManager.Entites.Enum.TypeUser;
import com.mission.RHManager.Entites.Utilisateur;
import com.mission.RHManager.Repositories.UtilisateurRepository;
import com.mission.RHManager.config.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UtilisateurRepository utilisateurRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest registerRequest) {
        var user = Utilisateur.builder()
                .email(registerRequest.getEmail())
                .nom(registerRequest.getNom())
                .prenom(registerRequest.getPrenom())
                .status(true)
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .type(TypeUser.EMPLOYE)
                .build();
        Utilisateur userResponse =  utilisateurRepository.save(user);
        var jwt = jwtService.generateToken(userResponse);
        return AuthenticationResponse.builder().token(jwt).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getPassword())
        );
        var user = utilisateurRepository.findByEmail(authenticationRequest.getEmail()).orElse(null);
        var jwt = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwt).build();
    }
}