package md3.bai2.advice;

import md3.bai2.exception.CustomException;
import md3.bai2.model.dto.DataResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ApplicationHandler {
    /**
     * @param ex MethodArgumentNotValidException
     * @return ResponseEntity<errors>
     * @apiNote handle validation form request
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValid(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        /**
         * {
         *    "email":"email is not valid",
         *    "password":"password must be not null"
         * }
         * */
        ex.getFieldErrors().forEach(err -> errors.put(err.getField(), err.getDefaultMessage()));
        return ResponseEntity.badRequest().body(
                new DataResponse(errors, HttpStatus.BAD_REQUEST)
        );
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleCustomException(CustomException ex)
    {
        return new ResponseEntity<>(
                new DataResponse(ex.getMessage(), ex.getHttpStatus()),
                ex.getHttpStatus()
        );
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<?> handleNoSuchException(NoSuchElementException ex)
    {
        return new ResponseEntity<>(
                new DataResponse(ex.getMessage(),HttpStatus.BAD_REQUEST),
                HttpStatus.BAD_REQUEST
        );
    }

}
