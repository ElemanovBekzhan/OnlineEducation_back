package org.education.onlneeducation;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.crypto.SecretKey;
import java.util.Base64;

@SpringBootApplication
public class OnlneEducationApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlneEducationApplication.class, args);
    }

}