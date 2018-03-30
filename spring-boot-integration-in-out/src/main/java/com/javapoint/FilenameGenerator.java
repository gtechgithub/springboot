package com.javapoint;

import java.io.File;

import org.springframework.integration.file.DefaultFileNameGenerator;
import org.springframework.messaging.Message;

public class FilenameGenerator extends DefaultFileNameGenerator {
    public FilenameGenerator() {
        super();
    }

    @Override
    public String generateFileName(Message<?> message) {
        String originalFileName = super.generateFileName(message);
        return  originalFileName;
    }
}