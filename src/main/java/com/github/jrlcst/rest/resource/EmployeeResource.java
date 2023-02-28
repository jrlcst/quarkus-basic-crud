package com.github.jrlcst.rest.resource;

import com.github.jrlcst.rest.dto.request.EmployeeRequest;
import com.github.jrlcst.rest.dto.response.EmployeeResponse;
import com.github.jrlcst.domain.model.Employee;
import com.github.jrlcst.domain.repository.EmployeeRepository;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/employee")
public class EmployeeResource {

    @Inject
    EmployeeRepository repository;

    @GET
    public Response findAll() {
        return Response.ok(repository.findAll().stream().map(EmployeeResponse::createByEntity).toList()).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") UUID id) {
        return Response.ok(EmployeeResponse.createByEntity(repository.findByUUID(id))).build();
    }

    @POST
    @Transactional
    public Response create(@RequestBody EmployeeRequest request) {
        var entity = Employee.createByRequest(request);
        repository.persist(entity);
        return Response.ok(EmployeeResponse.createByEntity(entity)).build();
    }

    @PUT
    @Transactional
    public Response update(@RequestBody EmployeeRequest request) {
        var entity = Employee.updateByRequest(repository.findByUUID(request.getId()), request);
        repository.persist(entity);
        return Response.ok(EmployeeResponse.createByEntity(entity)).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") UUID id) {
        repository.delete(repository.findByUUID(id));
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
