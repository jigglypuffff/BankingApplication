package com.cg.training.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.training.model.AuditLog;
import com.cg.training.service.AuditLogService;

@RestController
@RequestMapping(value="/auditLog")
public class AuditLogController {
	
	@Autowired
	AuditLogService auditLogService;
	
	@PostMapping(value = "/create")
	public AuditLog create(@RequestBody AuditLog auditLog) {
		return auditLogService.create(auditLog);
	}
	
	@GetMapping
	public List<AuditLog> view() {
		return auditLogService.view();
	}
	
	
	@PutMapping
	public AuditLog update(@RequestBody AuditLog auditLog,@RequestParam UUID eventId) {
		return auditLogService.update(auditLog, eventId);
		
	}
}
