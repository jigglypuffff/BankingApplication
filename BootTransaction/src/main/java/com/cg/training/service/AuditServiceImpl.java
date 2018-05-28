package com.cg.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cg.training.model.AuditLog;


@Service
public class AuditServiceImpl implements AuditService {

	@Autowired
	DiscoveryClient discoveryClient;

	@Autowired
	RestTemplate restTemplate;
	
	public AuditLog createAudit(AuditLog auditLog) {
		
		String url = "http://MongoAudit/auditLog/create";
		AuditLog audit = restTemplate.postForObject(url, auditLog, AuditLog.class);
		return audit;
	}

//		List<ServiceInstance> instance= discoveryClient.getInstances("MongoAudit");
//		ServiceInstance serviceInstance=instance.get(0);
//		RestTemplate restTemplate = new RestTemplate();
//		 String url =serviceInstance.getUri().toString();
//		 url=url+"/auditLog/create";
//		 
//		
//		AuditLog audit = restTemplate.postForObject(url, auditLog, AuditLog.class);
//		return audit; 
//	}
	
	   
	
	/*
	 * public AuditLog createAudit(AuditLog auditLog) {
	 * 
	 * String url = "http://localhost:8082/auditLog/create";
	 * 
	 * // String url = "http://MongoAudit/auditLog/create";
	 * 
	 * RestTemplate restTemplate = new RestTemplate();
	 * 
	 * AuditLog audit = restTemplate.postForObject(url, auditLog, AuditLog.class);
	 * 
	 * return audit; }
	 */
}
