package com.avdhoot.filemanagement.springbootfileupload.repository;
import com.avdhoot.filemanagement.springbootfileupload.entity.Attachment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment,String> {
    
}
