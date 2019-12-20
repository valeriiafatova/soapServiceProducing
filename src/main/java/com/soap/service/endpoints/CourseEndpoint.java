package com.soap.service.endpoints;

import com.soap.service.entity.Course;
import com.soap.service.repository.CourseRepository;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import tutorial.soapservice.GetCourseRequest;
import tutorial.soapservice.GetCourseResponse;
import tutorial.soapservice.ObjectFactory;

import javax.annotation.Resource;
import java.util.Optional;

@Endpoint
public class CourseEndpoint {
    private static final String NAMESPACE_URI = "http://soapService.tutorial";
    
    @Resource
    private CourseRepository courseRepository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCourseRequest")
    @ResponsePayload
    public GetCourseResponse getCourse(@RequestPayload GetCourseRequest request){
        ObjectFactory objectFactory = new ObjectFactory();
        GetCourseResponse response = objectFactory.createGetCourseResponse();
        
        Optional<Course> courseByTitle = courseRepository.findCourseByTitle(request.getTitle());
        if(courseByTitle.isPresent()){
            Course courseFromRepo = courseByTitle.get();
            tutorial.soapservice.Course course = objectFactory.createCourse();
            course.setId(courseFromRepo.getId().intValue());
            course.setTitle(courseFromRepo.getTitle());
            response.setCourse(course);
            return response;
        }
        //need to handle
        return null;
    }
    
}
