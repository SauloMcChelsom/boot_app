package com.app.boot_app.shared.exeception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

  public NotFoundException(String message) {
    super(message);
  }
}
//throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found");