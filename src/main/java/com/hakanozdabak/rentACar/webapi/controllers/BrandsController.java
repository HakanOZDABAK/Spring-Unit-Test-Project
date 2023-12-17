package com.hakanozdabak.rentACar.webapi.controllers;

import com.hakanozdabak.rentACar.business.abstracts.BrandService;
import com.hakanozdabak.rentACar.entities.concretes.Brand;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/brands")
@AllArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class BrandsController {
     private BrandService brandService;

    @GetMapping("/getall")
    public ResponseEntity<List<Brand>> getAll(){
        return ResponseEntity.ok(this.brandService.getAll());


    }
    @PostMapping("/add")
    public void add(@RequestBody Brand brand){
        this.brandService.add(brand);

    }
    @PutMapping("/update")
    public void update(@RequestBody Brand brand){
        ResponseEntity.ok();
        this.brandService.update(brand);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        this.brandService.delete(id);

    }

}
