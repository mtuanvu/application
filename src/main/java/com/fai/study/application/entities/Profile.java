package com.fai.study.application.entities;

import com.fai.study.application.utils.DateTime;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "profiles")
public class Profile extends DateTime {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "fullname", nullable = false)
    private String fullName;

    @Column(name = "dob", nullable = false)
    private String dob;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "url_avatar")
    private String avatar;

    @Column(name = "bio")
    private String bio;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private User user;
}
