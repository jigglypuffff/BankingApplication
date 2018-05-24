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
public class AuditLogServiceImpl implements AuditLogService{

	Logger log = Logger.getLogger(AuditLogService.class.getName());
	
	@Autowired
	AuditLogRepository auditRepo;
	
	@Autowired
	Environment env;
	
	@Override
	public AuditLog create(AuditLog auditLog) {
		
		log.info("creating audit log");
		
		if (auditLog == null) {
			log.error(env.getProperty("nullObject"));
			throw new NullOrNegativeValuesException("Please check for null values of auditLog");
		}
		
		if(auditRepo.findById(auditLog.getEventId())!=null)
		{
			log.error("Id already exists");
		}
		if(auditLog.getEventId()==null || auditLog.getEventDate()==null||auditLog.getEventName()==null||auditLog.getEventType()==null)
		{
			log.error("Please enter required values");
		}
		
		if (auditLog.getEventId() != null) {
			Optional<AuditLog> auditLogPossible = auditRepo.findById(auditLog.getEventId());
			if (auditLogPossible.isPresent()) {
				log.error(env.getProperty("alreadyExists"));
				try {
					throw new CreationException("bank object already exists");
				} catch (NullOrNegativeValuesException e) {
					log.error("AuditLog Creation Exception " + e.getMessage());
					return null;
				} catch (CreationException e) {
					log.error("AuditLog Creation Exception " + e.getMessage());
					return null;
				}
			}
		}
			return auditRepo.save(auditLog);
	}

	@Override
	public List<AuditLog> view() {
		
		return auditRepo.findAll();
	}

	@Override
	public AuditLog update(AuditLog auditLog,UUID eventId) {
		try {
			// check for null value of auditLog
			if (auditLog == null) {
				log.error(env.getProperty("nullObject"));
				throw new NullOrNegativeValuesException("Please check for null values of auditLog");
			}

			// check for null or negative values of fields
			if (auditLog.getEventDate() == null || auditLog.getEventId() == null || auditLog.getEventName() == null
					|| auditLog.getEventType() == null || auditLog.getUserId() == null) {
				log.error(env.getProperty("nullOrNegativeValues"));
				throw new NullOrNegativeValuesException("Please check for null values of auditLog");
			}

			// check for already existing auditLog
			if (auditLog.getEventId() != null) {
				Optional<AuditLog> auditLogPossible = auditRepo.findById(auditLog.getEventId());
				if (auditLogPossible.isPresent()) {
					log.error(env.getProperty("nullObject"));
					throw new NotFoundException("auditLog does not exist");
				}
			}
			log.info("AuditLog updated successfully");
			return auditRepo.save(auditLog);
			
		} catch (NullOrNegativeValuesException e) {
			log.error("AuditLog Updation Exception " + e.getMessage());
			return null;
		} catch (NotFoundException e) {
			log.error("AuditLog Updation Exception " + e.getMessage());
			return null;
		}
	}

	@Override
	public AuditLog delete(UUID eventId) {
		// TODO Auto-generated method stub
		return null;
	}
	

	/*@Override
	public AuditLog delete(UUID eventId) {
		
		try {
			// check for already existing auditLog
			if (eventId != null) {
				Optional<AuditLog> auditLogPossible = auditRepo.findById(eventId);
				boolean auditLogPresence = auditLogPossible.isPresent();
				if (auditLogPresence == false) {
					log.error(env.getProperty("nullObject"));
					throw new NotFoundException("auditLog does not exist");
				}
			}

			// check for negative or null value of eventId
			if(eventId.equals(null))
			{
				log.error(env.getProperty("nullOrNegativeValues"));
				throw new NullOrNegativeValuesException("Please check for null values of auditLog");
			}
			
			Optional<AuditLog> auditLogPossible = auditRepo.findById(eventId);
			AuditLog auditLog = auditLogPossible.get();
			
			
		} catch (NotFoundException e) {
			log.error("AuditLog Deletion Exception " + e.getMessage());
			return null;
		} catch (NullOrNegativeValuesException e) {
			log.error("AuditLog Deletion Exception " + e.getMessage());
			return null;
		}
		return auditRepo.deleteById(eventId);
	}*/

}
