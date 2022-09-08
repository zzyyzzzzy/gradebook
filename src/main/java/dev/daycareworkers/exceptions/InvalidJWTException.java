package dev.daycareworkers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Your JWT is invalid")
public class InvalidJWTException extends RuntimeException {
}
