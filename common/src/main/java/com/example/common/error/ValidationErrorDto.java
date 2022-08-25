package com.example.common.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ValidationErrorDto {
    private String object;
    private String field;
    private Object rejectedValue;
    private String message;

    public ValidationErrorDto(String object, String message) {
        this.object = object;
        this.message = message;
    }
}