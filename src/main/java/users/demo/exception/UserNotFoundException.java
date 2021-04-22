package users.demo.exception;


import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// using shortcut from lombok to minimize the boiler plate code
@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{
    private static final long SERIAL_VERSION_USER_ID = 1L;
    private String message;

    public UserNotFoundException(String message) {
        this.message = message;
    }
}
