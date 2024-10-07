package org.example.rozetkacom.Service;

import lombok.RequiredArgsConstructor;
import org.example.rozetkacom.DTO.Admin.AdminRequest;
import org.example.rozetkacom.Entity.Admin;
import org.example.rozetkacom.Exeptions.NotFoundException;
import org.example.rozetkacom.Repository.AdminRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;

    public Admin loginAdmin(AdminRequest adminRequest){
        Admin admin = adminRepository.getAdminByNameAndPassword(adminRequest.getName(),adminRequest.getPassword());
        if(admin != null){
            return admin;
        }
        else throw new NotFoundException(adminRequest.getName() + " not found ");
    }
}
