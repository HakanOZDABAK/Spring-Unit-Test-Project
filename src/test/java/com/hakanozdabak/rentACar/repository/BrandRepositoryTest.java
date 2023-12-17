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
}
