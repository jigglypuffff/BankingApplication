package com.cg.training.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.cg.training.exception.CreationException;
import com.cg.training.exception.NotFoundException;
import com.cg.training.exception.NullOrNegativeValuesException;
import com.cg.training.model.AuditLog;
import com.cg.training.repository.AuditLogRepository;

@Service
public class AuditLogServiceImpl implements AuditLogService {

	Logger log = Logger.getLogger(AuditLogService.class.getName());

	@Autowired
	AuditLogRepository auditRepo;

	@Autowired
	Environment env;

	@Override
	public AuditLog create(AuditLog auditLog) {

		log.info("creating audit log");


		if (auditLog.getEventDate() == null || auditLog.getEventName() == null
				|| auditLog.getEventType() == null) {
			log.error("Please enter required values");
		}

		

		return auditRepo.save(auditLog);
	}

	@Override 
	public List<AuditLog> view() {

		return auditRepo.findAll();
	} 

	@Override
	public AuditLog update(String eventId) {
		try {
			// check for null value of auditLog
			if (eventId == null) {
				log.error(env.getProperty("nullObject"));
				throw new NullOrNegativeValuesException("Please check for null values of auditLog");
			}

			AuditLog auditLog = auditRepo.findByEventId(eventId);
			//System.out.println(auditLog);
			auditLog.setEventName("update");
			auditLog.setEventType("updating AuditLog");
			//System.out.println(auditLog);
			auditRepo.save(auditLog);
			log.info("AuditLog updated successfully");
			return auditLog;

		} catch (NullOrNegativeValuesException e) {
			log.error("AuditLog Updation Exception " + e.getMessage());
			return null;
		}
	}

	@Override
	public String delete(String eventId) {
		System.out.println("event ID to be deleted >>" + eventId);
		auditRepo.deleteByEventId(eventId);
		return "success";
	}



	
	
}
