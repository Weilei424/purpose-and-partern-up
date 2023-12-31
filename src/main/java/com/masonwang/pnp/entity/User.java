package com.masonwang.pnp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.masonwang.pnp.validation.Password;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "username cannot be blank")
    @NonNull
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @NotBlank(message = "password cannot be blank")
    @Password(message = "invalid password, please follow password rules")
    @NonNull
    @Column(name = "password", nullable = false)
    private String password;

    @NotBlank(message = "contact info cannot be blank")
    @NonNull
    @Column(name = "Contact")
    private String contact;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Proposal> proposals;


    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "users")
    private Set<Team> teams;
}
