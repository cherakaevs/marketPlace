package com.custom.marketPlace.controllers;

import com.custom.marketPlace.model.*;
import com.custom.marketPlace.repo.impl.*;
import com.custom.marketPlace.services.IService;
import com.custom.marketPlace.services.impl.ManagerClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @GetMapping("/registration")
    public String registration(Model model){
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@RequestParam String name, @RequestParam String email, @RequestParam String password,
                               @RequestParam String confirmPassword, Model model){
        if(password.equals(confirmPassword)) {
            Profile profile = Profile.builder().firstName(name).lastName(name).build();
            profile.setId(UUID.randomUUID());
            User user = User.builder().username(name).password(password).passwordConfirm(confirmPassword).build();
            user.setProfile(profile);
            user.setId(profile.getId());
            profile.setUser(user);
            userIService.saveEntity(user);

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);


            MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
            map.add("grant_type","client_credentials");
            map.add("client_id", "users-management-client");
        //    map.add("client_secret", ((ManagerClientService)managerClientIService).getByClientId("users-management-client").getSecret());
            map.add("client_secret", "gESOM0iaoaq7gsBamUlFaEgKgMD2JLjB");
            HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);


            ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity("http://localhost:7432/realms/market-place/protocol/openid-connect/token",
                    entity, String.class);
            int a = 0;

        }
        return "redirect:/home";
    }
}
