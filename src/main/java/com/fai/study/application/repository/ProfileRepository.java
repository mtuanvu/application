package com.fai.study.application.repository;

import com.fai.study.application.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, UUID> {
    @Query(value = "SELECT * FROM profiles", nativeQuery = true)
    List<Profile> getAllProfiles();

    @Query(value = "SELECT * FROM profiles WHERE id = :id", nativeQuery = true)
    Optional<Profile> findProfileById(@Param("id") UUID id);

}
