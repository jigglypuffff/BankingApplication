package com.cg.training.MongoDemo;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.training.model.AuditLog;
import com.cg.training.repository.AuditLogRepository;
import com.cg.training.service.AuditLogServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoDemoApplicationTests {

	
	@Mock
	AuditLogRepository auditRepo;
	
	@InjectMocks
	AuditLogServiceImpl auditServ;
	@Test
	public void createLog()
	{
		
		final AuditLog log =  new AuditLog("Add","Adding Log","002");
		when(auditRepo.save(log)).thenReturn(log);
		assertThat(auditServ.create(log),is(notNullValue()));
	}
	
	
	@Test
	public void viewLog()
	{final AuditLog log =  new AuditLog("Add","Adding Log","002");
	when(auditRepo.save(log)).thenReturn(log);
	
		assertThat(auditServ.view(),is(notNullValue()));
	}
	
	
	@Test	
	public void delete()
	{
		
		final AuditLog log =  new AuditLog("Add","Adding Log","002");
		when(auditRepo.save(log)).thenReturn(log);
		
		assertThat(auditServ.delete("001"),is(notNullValue()));
		
	}
	
	@Test
	public void update()
	{
		final AuditLog log =  new AuditLog("Add","Adding Log","002");
		when(auditRepo.save(log)).thenReturn(log);
		assertEquals(auditServ.update("001"),log);
		
	}

}

