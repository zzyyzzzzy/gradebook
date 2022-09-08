package dev.daycareworkers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "You must be a teacher to make this request")
public class UnauthorizedUserException extends RuntimeException {
}
