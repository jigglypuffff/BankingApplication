package com.cg.training.service;

import java.util.List;
import java.util.UUID;

import com.cg.training.model.AuditLog;

public interface AuditLogService {

	
	AuditLog create(AuditLog auditLog);
	
	List<AuditLog> view();
	
	AuditLog update(AuditLog auditLog,UUID eventId);
	
	AuditLog delete(UUID eventId);
}
