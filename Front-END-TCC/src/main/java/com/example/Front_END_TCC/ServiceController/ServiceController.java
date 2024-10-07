package com.example.Front_END_TCC.ServiceController;

import com.example.Front_END_TCC.entity.ServiceEntity;
import com.example.Front_END_TCC.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ServiceController {

    @Autowired
    private ServiceRepository serviceRepository;

    @GetMapping("/services")
    public String listServices(Model model) {
        List<ServiceEntity> services = serviceRepository.findAll();
        model.addAttribute("services", services);
        return "services"; // nome do arquivo HTML sem a extensão
    }
}
