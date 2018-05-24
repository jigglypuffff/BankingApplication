package com.cg.training.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.training.model.AuditLog;

public interface AuditLogRepository extends MongoRepository<AuditLog, UUID>{

}
