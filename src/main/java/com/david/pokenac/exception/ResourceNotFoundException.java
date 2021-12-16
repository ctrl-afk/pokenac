package com.david.pokenac.exception;

public class ResourceNotFoundException extends Exception{
    public ResourceNotFoundException(String resource, Long id) {
        super(resource + "not found with id: " + id);
    }
}
