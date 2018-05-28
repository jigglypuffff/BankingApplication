package com.cg.training.service;

import java.util.List;


import com.cg.training.model.AuditLog;

public interface AuditLogService {

	/**
	 * @param auditLog
	 * @return AuditLog object
	 */
	AuditLog create(AuditLog auditLog);

	/**
	 * @return list of AuditLog
	 */
	List<AuditLog> view();

	/**
	 * @param eventId
	 * @return AuditLog object
	 */
	AuditLog update(String eventId);

	/**
	 * @param eventId
	 * @return string message
	 */
	String delete(String eventId);

}
