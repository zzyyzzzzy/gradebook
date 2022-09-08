package dev.daycareworkers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "Password mismatch")
public class PasswordMismatchException extends RuntimeException{
}
