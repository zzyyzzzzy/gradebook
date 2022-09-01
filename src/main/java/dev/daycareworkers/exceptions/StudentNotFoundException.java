package dev.daycareworkers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "student not found")
public class StudentNotFoundException extends RuntimeException{
}
