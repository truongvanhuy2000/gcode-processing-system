package com.huy.gcodeWebsite.Exception;

public class StorageFileNotFoundException extends StorageException{
    public StorageFileNotFoundException(String message) {
        super(message);
    }
    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
