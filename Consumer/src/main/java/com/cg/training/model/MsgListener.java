package com.cg.training.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.training.repository.AuditLogRepository;
/*
import com.example.commonDemo.TransactionNew;
import com.example.sampleRcv.dto.Transaction;
import com.example.sampleRcv.repository.DemoRepository;

*/
@Component
public class MsgListener {

	@Autowired
	AuditLogRepository demoRepository;
	
	 public void receiveMessage(AuditLog message) {
	       System.out.println("Received <" + message + ">");
	       AuditLog transaction = new AuditLog(message.getEventId(),message.getEventName(),message.getEventType(),message.getOldValue(),message.getNewValue());	       
	       demoRepository.save(transaction);
	    }
}
