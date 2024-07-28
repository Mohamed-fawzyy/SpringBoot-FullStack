package com.fawzy.springboot_fullstack.Service;

public record CustomerRegistrationRequest(
        String email,
        String name,
        Integer age
) {
}
