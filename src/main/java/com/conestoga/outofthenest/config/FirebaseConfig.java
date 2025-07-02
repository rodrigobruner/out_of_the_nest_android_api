package com.conestoga.outofthenest.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Configuration
public class FirebaseConfig {

    @PostConstruct
    public void initFirebase() throws IOException {
        InputStream serviceAccount;

        String firebaseJson = System.getenv("FIREBASE_CONFIG_JSON");

        if (firebaseJson != null && !firebaseJson.isBlank()) {

            serviceAccount = new ByteArrayInputStream(firebaseJson.getBytes(StandardCharsets.UTF_8));
            System.out.println("[FirebaseConfig] Loaded credentials from ENV");
        } else {

            serviceAccount = new ClassPathResource("firebase-service-account.json").getInputStream();
            System.out.println("[FirebaseConfig] Loaded credentials from file");
        }

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        FirebaseApp.initializeApp(options);
    }
}
