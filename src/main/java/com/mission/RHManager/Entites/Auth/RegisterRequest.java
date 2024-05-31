package com.mission.RHManager.Entites.Auth;

import com.mission.RHManager.Entites.Enum.TypeUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String nom;
    private String prenom;
    private String email;
    private boolean status;
    private String password;
    private String poste;
    private TypeUser role;
}
