package com.hakanozdabak.rentACar.service;


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

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
public class BrandServiceTest {

    @Mock
    private BrandRepository brandRepository;

    @InjectMocks
    private BrandManager brandManager;

    @Test
    @DisplayName("Should Find Post By Id")
    public void shouldSaveBrand() {

        Brand brand = Brand.builder()
                .brandId(1)
                .brandName("Mercedes")
                .build();


        Mockito.when(brandRepository.save(Mockito.any(Brand.class))).thenReturn(brand);
        Brand exceptedBrand =  brandRepository.save(brand);
        System.out.println(exceptedBrand);
        assertThat(exceptedBrand).isNotNull();
        assertThat(exceptedBrand.getBrandName()).isEqualTo("Mercedes");
    }
}
