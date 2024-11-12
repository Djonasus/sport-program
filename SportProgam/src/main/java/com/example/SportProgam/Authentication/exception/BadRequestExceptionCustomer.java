package com.example.SportProgam.Authentication.exception;


import java.util.List;


public record BadRequestExceptionCustomer(
        List<Validate> errors)  {
}
