package com.custom.marketPlace.controllers;

import com.custom.marketPlace.constants.Api;
import com.custom.marketPlace.model.*;
import com.custom.marketPlace.repo.impl.*;
import com.custom.marketPlace.security.controllers.ClientController;
import com.custom.marketPlace.security.model.ManagerClient;
import com.custom.marketPlace.services.IService;
import com.custom.marketPlace.security.services.ManagerClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class TestController {
    @Autowired
    BucketRepository bucketRepository;
    @Autowired
    ProfileRepository profileRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    IService<User> userIService;
    @Autowired
    IService<ManagerClient> managerClientIService;

    @GetMapping("/test")
    public void test(){
        List<Product> products = new ArrayList<>();
        Product product = Product.builder().name("test").build();
        products.add(product);
        Bucket bucket = Bucket.builder().build();
        Profile profile = Profile.builder().build();
        profile.setId(UUID.randomUUID());
        bucket.setProducts(products);
        bucket.setProfile(profile);
        profile.setBucket(bucket);
        bucket.setId(profile.getId());
        bucket.setSumPrice(1.0);
        bucketRepository.save(bucket);
    }

    @GetMapping("/home")
    public String home(Model model){
        return "home";
    }

    @GetMapping("/admin")
    public String admin(Model model){
        return "home";
    }


}
