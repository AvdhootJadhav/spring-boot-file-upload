package com.avdhoot.filemanagement.springbootfileupload.services;

import com.avdhoot.filemanagement.springbootfileupload.entity.Attachment;

import org.springframework.web.multipart.MultipartFile;

public interface AttachmentService {

    Attachment saveAttachment(MultipartFile file) throws Exception;

    Attachment getAttachment(String fileId) throws Exception;
    
}
