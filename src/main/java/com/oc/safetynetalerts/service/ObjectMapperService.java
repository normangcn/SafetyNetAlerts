/**
 * 
 */
package com.oc.safetynetalerts.service;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author NORMAN gareth
 *
 */
public class ObjectMapperService {
	  private static ObjectMapper instance = null;

	    public static ObjectMapper getInstance() {
	        if (instance == null) {
	            instance = new ObjectMapper();
	        }
	        return new ObjectMapper();
	    }

}
