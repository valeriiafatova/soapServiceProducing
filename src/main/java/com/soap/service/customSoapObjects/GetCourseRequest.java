package com.soap.service.customSoapObjects;

public class GetCourseRequest {
    private String title;

    public GetCourseRequest() {
    }

    public GetCourseRequest(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
