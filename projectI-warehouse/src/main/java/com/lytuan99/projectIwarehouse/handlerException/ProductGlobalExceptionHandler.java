package com.lytuan99.projectIwarehouse.handlerException;

import com.lytuan99.projectIwarehouse.exceptions.productException.CannotDeleteProduct;
import com.lytuan99.projectIwarehouse.exceptions.productException.EntityNotFoundException;
import com.lytuan99.projectIwarehouse.exceptions.productException.ExistedProductException;
import com.lytuan99.projectIwarehouse.exceptions.productException.IteratedCodeException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ProductGlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> customHandleNotFound(Exception ex, WebRequest request, HttpServletResponse response) throws IOException {
        CustomErrorResponse errorResponse = new CustomErrorResponse(false,HttpStatus.NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CannotDeleteProduct.class)
    public ResponseEntity<CustomErrorResponse> cannotDelete(Exception ex, WebRequest request, HttpServletResponse response) throws IOException {
        CustomErrorResponse errorResponse = new CustomErrorResponse(false,HttpStatus.NOT_ACCEPTABLE, ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(ExistedProductException.class)
    public ResponseEntity<CustomErrorResponse> existedProductException(Exception ex, WebRequest request, HttpServletResponse response) throws IOException {
        CustomErrorResponse errorResponse = new CustomErrorResponse(false,HttpStatus.BAD_REQUEST, ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IteratedCodeException.class)
    public ResponseEntity<CustomErrorResponse> iteratedSkuCodeProductException(Exception ex, WebRequest request, HttpServletResponse response) throws IOException {
        CustomErrorResponse errorResponse = new CustomErrorResponse(false,HttpStatus.BAD_REQUEST, ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected @NotNull ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                           HttpHeaders headers,
                                                                           HttpStatus status,
                                                                           WebRequest request) {
        System.out.println("what up helo 1");
        List<String> errors = new ArrayList<String>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            System.out.println("what up helo");
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }

        for(ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }

        CustomErrorResponse errorResponse = new CustomErrorResponse(false, HttpStatus.UNPROCESSABLE_ENTITY, errors);

        return handleExceptionInternal(ex, errorResponse,headers, errorResponse.getHttpStatus(), request);
    }
}
