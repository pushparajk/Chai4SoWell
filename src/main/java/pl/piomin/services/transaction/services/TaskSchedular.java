package pl.piomin.services.transaction.services;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import pl.piomin.services.transaction.utils.TransactionContants;

@Component
public class TaskSchedular
{

	@Autowired
	CentralSchemeService centralSchemeService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TaskSchedular.class);
	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

	@Scheduled(fixedRate = TransactionContants.TIME_INTERVAL_IN_MILLISEC)
	   public void verifyContracts() {
		LOGGER.info("Schedular triggered at "+sdf.format(new Date()));
		centralSchemeService.verifyAllStateContract();
		centralSchemeService.verifyAllIndividualContract();
	}
}
