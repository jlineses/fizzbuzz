package com.game.fizzbuzz.service.impl;

import org.springframework.stereotype.Service;

import com.game.fizzbuzz.service.IFizzBuzzService;

@Service
public class FizzBuzzService implements IFizzBuzzService {
	
	/**
	 * Method for decoding the game output.
	 * 
	 * @param given - used for decoding the game output.
	 * 
	 * @return output - output of the game.
	 */
	@Override
	public String doFizzBuzz(Long given) {
		StringBuffer output = new StringBuffer();

    	for (int ctr = 1; ctr <= given; ctr++) {
    		if (ctr % 3 == 0 && ctr % 5 == 0) {
    			output.append("FizzBuzz\n");
    			continue;
    		} else if (ctr % 3 == 0) {
    			output.append("Fizz\n");
    			continue;
    		} else if (ctr % 5 == 0) {
    			output.append("Buzz\n");
    			continue;
    		} else {
    			output.append(ctr + "\n");
    		}
    	}
    	
		return output.toString();
	}
}
