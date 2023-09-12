package com.example.employeeservice.exceptionHandling;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorDetails {
	private Date timestamp;
	private String message;
	private String path;
	private String errorCode;

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String path() {
		return path;
	}

	public String errorCode() {
		return errorCode;
	}
}
