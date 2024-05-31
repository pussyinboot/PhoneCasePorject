package org.example.Service;

import lombok.extern.slf4j.Slf4j;
import org.example.models.Admin;
import org.example.repository.AdminRepository;
import org.example.repository.CustomerRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class LoginService implements UserDetailsService {
    private final AdminRepository adminUserRepository;


    public LoginService(AdminRepository adminUserRepository) {
        this.adminUserRepository = adminUserRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String adminId) throws UsernameNotFoundException {

        //adminUser 정보 조회
        Optional<Admin> adminUser = adminUserRepository.findByAdminId(adminId);

        if (adminUser.isPresent()) {
            Admin admin = adminUser.get();

            Admin authAdmin = Admin.builder()
                    .id(admin.getId())
                    .adminId(admin.getAdminId())
                    .password(admin.getPassword())
                    .role(admin.getRole())
                    .adminName(admin.getAdminName())
                    .createdAt(admin.getCreatedAt())
                    .updatedAt(admin.getUpdatedAt())
                    .build();
            log.info("authAdmin : {}", authAdmin);
            return authAdmin;
        }
        return null;
    }
}
