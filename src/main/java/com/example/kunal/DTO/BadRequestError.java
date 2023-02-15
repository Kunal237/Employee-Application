package com.example.kunal.DTO;


import java.util.Map;

public class BadRequestError extends ErrorMessage {
	
private  Map<String,String> Body;

/**
 * @return the body
 */
public Map<String, String> getBody() {
	return Body;
}

/**
 * @param body the body to set
 */
public void setBody(Map<String, String> body) {
	Body = body;
}



}
