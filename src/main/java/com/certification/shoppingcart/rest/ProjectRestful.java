package com.certification.shoppingcart.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.certification.shoppingcart.Dao.ProjectDao;
import com.certification.shoppingcart.model.Project;

@Path("project")
public class ProjectRestful {

	ProjectDao dao = new ProjectDao();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Project getProject(){
		return dao.busca(1L);
	}
	
}
