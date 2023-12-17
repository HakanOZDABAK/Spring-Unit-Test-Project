package com.hakanozdabak.rentACar.dataAccess.abstracts;

import com.hakanozdabak.rentACar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository  extends JpaRepository<Brand,Integer> {
}
