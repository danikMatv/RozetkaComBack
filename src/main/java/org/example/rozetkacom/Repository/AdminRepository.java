package org.example.rozetkacom.Repository;

import org.example.rozetkacom.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
    Admin getAdminByNameAndPassword(String name,String password);
}
