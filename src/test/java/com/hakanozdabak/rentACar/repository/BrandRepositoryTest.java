package com.hakanozdabak.rentACar.repository;

import com.hakanozdabak.rentACar.dataAccess.abstracts.BrandRepository;
import com.hakanozdabak.rentACar.entities.concretes.Brand;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class BrandRepositoryTest {

    @Autowired
    private BrandRepository brandRepository;

    @Test
    @DisplayName("Save Brand")
    public void BrandRepository_SaveAll_ReturnSavedBrand(){

        Brand brand = Brand.builder()
                .brandId(5)
                .brandName("Mercedes")
                .build();

        Brand savedBrand = this.brandRepository.save(brand);
        System.out.println(savedBrand);
        Assertions.assertThat(savedBrand).isNotNull();
        Assertions.assertThat(savedBrand.getBrandId()).isGreaterThan(0);
        Assertions.assertThat(savedBrand.getBrandName()).isEqualTo(brand.getBrandName());

    }

    @Test
    @DisplayName("Delete Brand By Id")
    public void BrandRepository_DeleteById_ReturnEmpty(){

        Brand brand = Brand.builder()
                .brandId(5)
                .brandName("Mercedes")
                .build();

        Brand savedBrand = this.brandRepository.save(brand);
        this.brandRepository.deleteById(savedBrand.getBrandId());
        Optional<Brand> deletedBrand = this.brandRepository.findById(savedBrand.getBrandId());
        Assertions.assertThat(deletedBrand).isEmpty();

    }
    @Test
    @DisplayName("Show All Brand")
    public void BrandRepository_DeleteById_ReturnBrandsList(){

        Brand brand1 = Brand.builder()
                .brandId(6)
                .brandName("Mercedes")
                .build();
        Brand brand2 = Brand.builder()
                .brandId(7)
                .brandName("Mercedes")
                .build();

        this.brandRepository.save(brand1);
        this.brandRepository.save(brand2);
        List<Brand> brandList = this.brandRepository.findAll();
        System.out.println(brandList);
        Assertions.assertThat(brandList).isNotEmpty();
        Assertions.assertThat(brandList).size().isEqualTo(2);


    }

}
