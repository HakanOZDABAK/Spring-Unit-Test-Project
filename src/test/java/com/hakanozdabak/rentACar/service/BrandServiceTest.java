package com.hakanozdabak.rentACar.service;


import com.hakanozdabak.rentACar.business.abstracts.BrandService;
import com.hakanozdabak.rentACar.business.concretes.BrandManager;
import com.hakanozdabak.rentACar.dataAccess.abstracts.BrandRepository;
import com.hakanozdabak.rentACar.entities.concretes.Brand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.*;

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
        assertAll(()->brandManager.delete(brand.getBrandId()));
    }

    @Test
    @DisplayName("Should Update Brand")
    public void shouldUpdateBrand() {


        Brand brandToUpdate = new Brand();
        when(brandRepository.save(brandToUpdate)).thenReturn(brandToUpdate);


        Brand updatedBrand = brandManager.update(brandToUpdate);


        verify(brandRepository).save(brandToUpdate);
        assertEquals(brandToUpdate, updatedBrand);
    }

    @Test
    @DisplayName("Should Get Brands List")
    public void shouldGetBrandsList() {


        List<Brand> mockBrandList = Arrays.asList(
                new Brand(1, "Mercedes"),
                new Brand(2, "BMW")
        );
        when(brandRepository.findAll()).thenReturn(mockBrandList);


        List<Brand> resultBrandList = brandManager.getAll();
        System.out.println(resultBrandList);


        verify(brandRepository).findAll();
        assertEquals(mockBrandList, resultBrandList);
    }

}
