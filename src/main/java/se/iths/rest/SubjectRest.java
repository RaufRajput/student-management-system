package se.iths.rest;


import se.iths.entity.Subject;
import se.iths.service.SubjectService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("subject")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SubjectRest {

    @Inject
    SubjectService subjectService;

    @Path("getAll")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public List<Subject> getAllSubjects(){
        return subjectService.getAllSubjects();
    }

    @Path("create")
    @POST
    public Response createSubject(Subject subject){
        subjectService.createSubject(subject);
        return Response.ok(subject).build();
    }

    @Path("{subjectName}")
    @GET
    public List<Subject> getSubjectByName(@PathParam("subjectName") String category) {
        List<Subject> foundSubjects = subjectService.findSubjectByName(category);
        if( !foundSubjects.isEmpty()) {
            return subjectService.findSubjectByName(category);
        } else {
            throw new StudentNotFoundException("Cant find subject");
        }
    }

}
