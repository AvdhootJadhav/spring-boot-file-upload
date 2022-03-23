package com.avdhoot.filemanagement.springbootfileupload.services;

import com.avdhoot.filemanagement.springbootfileupload.entity.Attachment;
import com.avdhoot.filemanagement.springbootfileupload.repository.AttachmentRepository;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AttachmentServiceImplement implements AttachmentService{

    private AttachmentRepository attachmentRepository;

    public AttachmentServiceImplement(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }

    @Override
    public Attachment saveAttachment(MultipartFile file) throws Exception {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            if(fileName.contains("..")){
                throw new Exception("Filename contains invalid sequence");
            }
            Attachment attachment = new Attachment(fileName, file.getContentType(), file.getBytes());
            return attachmentRepository.save(attachment);
        } catch (Exception e) {
            throw new Exception("Could not save file");
        }
    }

    @Override
    public Attachment getAttachment(String fileId) throws Exception {
        
        return attachmentRepository.findById(fileId).orElseThrow(()-> new Exception("File not found with Id "+fileId));
    }
    
}
