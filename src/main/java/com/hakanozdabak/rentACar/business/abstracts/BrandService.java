package com.hakanozdabak.rentACar.business.abstracts;

import com.hakanozdabak.rentACar.entities.concretes.Brand;

import java.util.List;

public interface BrandService {

    void add(Brand brand);

    Brand update(Brand brand);

    void delete(int id);

    List<Brand> getAll();

}
