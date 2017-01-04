package au.com.optus.handlers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hsenpaws
 * @since 3/1/17
 */
@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends Exception {

	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public GlobalExceptionHandler(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public GlobalExceptionHandler() {
		super();
	}
}
