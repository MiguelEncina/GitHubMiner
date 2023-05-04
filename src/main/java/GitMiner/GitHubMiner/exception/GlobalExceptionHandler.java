package GitMiner.GitHubMiner.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<Map<String, List<String>>> handleValidationException(MethodArgumentNotValidException ex) {
        List<FieldError> fieldError = ex.getBindingResult().getFieldErrors();
        List<String> errors = fieldError.stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());
        Map<String, List<String>> res = new HashMap<>();
        res.put("errors", errors);

        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }

}