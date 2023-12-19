package com.hakanozdabak.rentACar.service;


import com.hakanozdabak.rentACar.business.abstracts.BrandService;
import com.hakanozdabak.rentACar.business.concretes.BrandManager;
import com.hakanozdabak.rentACar.dataAccess.abstracts.BrandRepository;
import com.hakanozdabak.rentACar.entities.concretes.Brand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
public class BrandServiceTest {


    @Mock
    private BrandRepository brandRepository;

    @InjectMocks
    private BrandManager brandManager;

    @Test
    @DisplayName("Should Save Brand")
    public void shouldSaveBrand() {

        Brand brand = Brand.builder()
                .brandId(1)
                .brandName("Mercedes")
                .build();


        Mockito.when(brandRepository.save(Mockito.any(Brand.class))).thenReturn(brand);
        Brand exceptedBrand =  brandManager.add(brand);
        System.out.println(exceptedBrand);
        assertThat(exceptedBrand).isNotNull();
    }

    @Test
    @DisplayName("Should Delete By Id")
    public void shouldDeleteById() {

        // Initial brand
        Brand brand = Brand.builder()
                .brandId(1)
                .brandName("Mercedes")
                .build();
        Mockito.when(brandRepository.save(Mockito.any(Brand.class))).thenReturn(brand);
        brandManager.add(brand);
        this.brandManager.delete(brand.getBrandId());

       assertThat(brandRepository.count()).isEqualTo(0);
    }
}
