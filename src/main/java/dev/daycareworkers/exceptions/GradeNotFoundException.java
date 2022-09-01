package dev.daycareworkers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "grade not found")
public class GradeNotFoundException extends RuntimeException{
}
