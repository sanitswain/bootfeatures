package practice.boot.errorhandling;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Advise class to show how to configure Error Handling for controller /
 * RestController.
 *
 */
@RestControllerAdvice(basePackageClasses = { SampleRestController.class })
public class SampleControllerAdvise extends ResponseEntityExceptionHandler {

	/**
	 * @return Customized ResponseEntity class to be returned to user/browser
	 *         when <code>IllegalArgumentException.class</code> is raised by
	 *         controller classes define inside basePackageClasses.
	 * 
	 *         For example:
	 * 
	 *         {"errorcode":500,"message":"Username 'sanit0827' is
	 *         illegal.","status":"INTERNAL_SERVER_ERROR"}
	 */
	@ExceptionHandler(IllegalArgumentException.class)
	// @ResponseBody
	public ResponseEntity<CustomErrorType> handleMyControllerException(HttpServletRequest request, Throwable error) {
		HttpStatus status = getStatus(request);
		return new ResponseEntity<CustomErrorType>(new CustomErrorType(status.value(), error.getMessage(), status),
				status);
	}

	private HttpStatus getStatus(HttpServletRequest request) {
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		if (statusCode == null) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return HttpStatus.valueOf(statusCode);
	}

	private static class CustomErrorType {
		public int errorcode;
		public String message;
		public HttpStatus status;

		public CustomErrorType(int errorcode, String message, HttpStatus status) {
			this.errorcode = errorcode;
			this.message = message;
			this.status = status;
		}

		@Override
		public String toString() {
			return "CustomErrorType [errorcode=" + errorcode + ", message=" + message + ", status=" + status + "]";
		}

	}
}
