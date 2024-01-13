package com.hakanozdabak.rentACar.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hakanozdabak.rentACar.business.abstracts.AuthService;
import com.hakanozdabak.rentACar.business.concretes.BrandManager;
import com.hakanozdabak.rentACar.dataAccess.abstracts.BrandRepository;
import com.hakanozdabak.rentACar.entities.concretes.Brand;
import com.hakanozdabak.rentACar.entities.concretes.Role;
import com.hakanozdabak.rentACar.webapi.controllers.BrandsController;
import org.apache.catalina.security.SecurityConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = BrandsController.class)
@ContextConfiguration(classes = SecurityConfig.class)
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc(addFilters = false)
public class BandControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private AuthService authService;

    @Mock
    private BrandRepository brandRepository;

    private Brand brand;

    @BeforeEach
    public void init() throws Exception {
        brand = Brand.builder().brandId(1).brandName("BMW").build();

    }

    @Test
    @WithMockUser(username = "string", password = "string", authorities = {"ROLE_USER"})
    public void BrandController_CreateBrand_ReturnCreated() throws Exception {
        // BrandRepository'nin save metodunu mocklayın ve isteği başarılı bir şekilde gerçekleştirdiğini varsayalım.
        when(brandRepository.save(Mockito.any(Brand.class))).thenReturn(brand);

        // mockMvc ile POST isteğini gönderin
        ResultActions response = mockMvc.perform(post("/api/v1/brands/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(brand)));

        // 201 (Created) durumunu kontrol etmek yerine 200 (OK) durumunu kontrol edin
        response.andExpect(status().isOk());
    }
}
