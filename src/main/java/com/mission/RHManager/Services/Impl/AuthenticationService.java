package com.mission.RHManager.Services.Impl;


import com.mission.RHManager.Entites.Auth.AuthenticationRequest;
import com.mission.RHManager.Entites.Auth.AuthenticationResponse;
import com.mission.RHManager.Entites.Auth.RegisterRequest;
import com.mission.RHManager.Entites.Enum.TypeUser;
import com.mission.RHManager.Entites.Presence;
import com.mission.RHManager.Entites.Utilisateur;
import com.mission.RHManager.Repositories.PresenceRepository;
import com.mission.RHManager.Repositories.UtilisateurRepository;
import com.mission.RHManager.Services.EmailService;
import com.mission.RHManager.config.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UtilisateurRepository utilisateurRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PresenceRepository presenceRepository;

    private final EmailService emailService;
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
        emailService.sendEmailWithTemplate(userResponse);
        var jwt = jwtService.generateToken(userResponse);
        return AuthenticationResponse.builder().token(jwt).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()
                )
        );
        var user = utilisateurRepository.findByEmail(authenticationRequest.getEmail()).orElse(null);
        Presence p = new Presence();
        LocalDate l = LocalDate.now();
        p.setDate(l);
        p.setPresence(true);
        p.setUtilisateur(user);
        presenceRepository.save(p);
        var jwt = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwt).build();
    }
//    public AuthenticationResponse forgetPassword(ForgotPasswordRequest forgotPasswordRequest) {
//        Utilisateur user = utilisateurRepository.findByEmail(forgotPasswordRequest.getEmail())
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        String newPassword = generateRandomPassword();
//
//        user.setPassword(passwordEncoder.encode(newPassword));
//        utilisateurRepository.save(user);
//
//        emailService.sendPasswordResetEmail(user.getEmail(), newPassword);
//
//        return AuthenticationResponse.builder().message("Password reset successful. Check your email for the new password.").build();
//    }

    private String generateRandomPassword() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

}