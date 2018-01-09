package org.superklamer.javabrains.rest;

import java.util.Calendar;
import java.util.Date;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("test4")
@Singleton
public class MyResource4 {

	@GET
	@Produces(value = {MediaType.TEXT_PLAIN, "text/shortdate"})
	public Date testMethod() {
		return Calendar.getInstance().getTime();
	}
}
