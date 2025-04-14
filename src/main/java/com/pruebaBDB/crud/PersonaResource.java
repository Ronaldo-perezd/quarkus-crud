package com.pruebaBDB.crud;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/personas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonaResource {

    @GET
    public List<Persona> listar() {
        return Persona.listAll();
    }

    @GET
    @Path("/{id}")
    public Persona obtener(@PathParam("id") Long id) {
        return Persona.findById(id);
    }

    @POST
    @Transactional
    public Response crear(Persona persona) {
        System.out.println("Recibido: " + persona); 
        persona.persist();
        return Response.status(Response.Status.CREATED).entity(persona).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Persona actualizar(@PathParam("id") Long id, Persona datos) {
        Persona persona = Persona.findById(id);
        if (persona == null) {
            throw new NotFoundException("Persona no encontrada");
        }
        persona.nombre = datos.nombre;
        persona.email = datos.email;
        return persona;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response eliminar(@PathParam("id") Long id) {
        boolean eliminado = Persona.deleteById(id);
        if (!eliminado) {
            throw new NotFoundException("Persona no encontrada");
        }
        return Response.noContent().build();
    }
}