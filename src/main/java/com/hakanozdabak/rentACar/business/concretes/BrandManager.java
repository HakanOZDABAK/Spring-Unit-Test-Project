package com.hakanozdabak.rentACar.business.concretes;


import com.hakanozdabak.rentACar.business.abstracts.BrandService;
import com.hakanozdabak.rentACar.dataAccess.abstracts.BrandRepository;
import com.hakanozdabak.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

    private final BrandRepository brandRepository;

    @Override
    public Brand add(Brand brand) {
      return this.brandRepository.save(brand);
    }

    @Override
    public Brand update(Brand brand) {
       return this.brandRepository.save(brand);

    }

    @Override
    public void delete(int id) {

        this.brandRepository.deleteById(id);

    }

    @Override
    public List<Brand> getAll() {
        return this.brandRepository.findAll();
    }
}
