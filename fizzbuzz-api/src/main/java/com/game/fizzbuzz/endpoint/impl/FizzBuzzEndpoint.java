package com.game.fizzbuzz.endpoint.impl;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.fizzbuzz.endpoint.IFizzBuzzEndpoint;
import com.game.fizzbuzz.service.IFizzBuzzService;

@Service
public class FizzBuzzEndpoint implements IFizzBuzzEndpoint {

	@Autowired IFizzBuzzService fizzBuzzService;
	
   /**
   * Receives the given number which will be evaluated by the game service.
   * 
   * given - the number which will be evaluated by the game service.
   *
   * @return response which holds the output of the game.
   */
	@Override
	public Response doFizzBuzz(Long given) {
    	if (given == null || (given != null && given < 1)) {
    		return Response.status(Response.Status.EXPECTATION_FAILED).entity("Invalid given number: " + given).build();
    	}
    	
    	String gameOutput = fizzBuzzService.doFizzBuzz(given);
        return  Response.ok(gameOutput).build();
	}
	
}
