package com.cg.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.training.model.AuditLog;
import com.cg.training.service.AuditLogService;

@RestController
@RequestMapping(value="/auditLog")
public class AuditLogController {
	
	@Autowired
	AuditLogService auditLogService;
	
	@PostMapping(path = "/create")
	public AuditLog create(final @RequestBody AuditLog auditLog) {
		return auditLogService.create(auditLog);
	}
	
	@GetMapping
	public List<AuditLog> view() {
		return auditLogService.view();
	}
	
	@PutMapping(path="/update/{eventId}")
	public AuditLog update(final @PathVariable String eventId) {
		return auditLogService.update(eventId);
		
	}
	
	@DeleteMapping(value="/delete/{eventId}")
	public String delete(final @PathVariable String eventId)
	{
		auditLogService.delete(eventId);
		return "success";
	}
}
