package com.cg.training.service;


import org.springframework.web.bind.annotation.PostMapping;

import com.cg.training.model.AuditLog;


public interface AuditService {

	@PostMapping(path = "/auditLog/create")
	AuditLog create(AuditLog auditLog);
}