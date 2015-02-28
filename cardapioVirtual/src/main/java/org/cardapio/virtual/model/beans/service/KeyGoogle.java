package org.cardapio.virtual.model.beans.service;

import com.google.maps.GeoApiContext;

public class KeyGoogle {
	private GeoApiContext context;
		
	public KeyGoogle(){
		context = new GeoApiContext().setApiKey("AIzaSyDqf25XIgs0wP5S6HFefteFHxVUxtQDsG0");
	}

	public GeoApiContext getContext() {
		return context;
	}
}
