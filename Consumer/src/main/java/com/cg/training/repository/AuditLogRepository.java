package com.cg.training.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.cg.training.model.AuditLog;

/**
 * @author aishwarya
 *
 */
public interface AuditLogRepository extends MongoRepository<AuditLog, String>{

	@Query
	void deleteByEventId(String eventId);

	@Query
	AuditLog findByEventId(String eventId);

	

}
