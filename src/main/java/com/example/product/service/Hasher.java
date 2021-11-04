package com.example.product.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Hasher
{
    public static String hash(String name) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(name);
    }

    public static boolean isMatch(String name, String hash) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return(passwordEncoder.matches(name, hash));
    }

    public static void main( String[] args ) {
        String hashedPassword = Hasher.hash("name");
        System.out.println(Hasher.isMatch("name", hashedPassword));
    }
}
