package com.soap.service.customSoapObjects;

public class GetCourseResponse {
    private Course course;

    public GetCourseResponse() {
    }

    public GetCourseResponse(Course course) {
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
