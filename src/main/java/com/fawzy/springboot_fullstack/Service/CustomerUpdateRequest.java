package com.fawzy.springboot_fullstack.Service;

public record CustomerUpdateRequest(
        String email,
        String name,
        Integer age
) {
}
