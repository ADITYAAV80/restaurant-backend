package org.myprojects.yummy_rest.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProductAlreadyExistsException extends RuntimeException {
    private final String msg;
}
