package org.example.rozetkacom.Controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.rozetkacom.DTO.Admin.AdminRequest;
import org.example.rozetkacom.Entity.Admin;
import org.example.rozetkacom.Service.AdminService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/login")
    public Admin loginCustomer(@RequestBody AdminRequest adminRequest) {
        return adminService.loginAdmin(adminRequest);
    }

}
