package org.example.repository;

import org.example.models.Admin;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository {
    Optional<Admin> findByAdminId(String adminId);
}
