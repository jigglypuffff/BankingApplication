package com.cg.training.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cg.training.model.AuditLog;


@Service
public class AuditServiceImpl implements AuditService {

	
	
	@Autowired
	RestTemplate restTemplate;
	
	 public AuditLog create(AuditLog auditLog) {
	 
	  String url = "http://localhost:8061/auditLog/create";
	 
	  // String url = "http://MongoAudit/auditLog/create";
	  
	  RestTemplate restTemplate = new RestTemplate();
	  
	  AuditLog audit = restTemplate.postForObject(url, auditLog, AuditLog.class);
	  
	  return audit; }





}
