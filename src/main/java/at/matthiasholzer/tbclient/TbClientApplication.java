package at.matthiasholzer.tbclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;

@SpringBootApplication
@EnableFeignClients
public class TbClientApplication {

	public static void main(String[] args) {SpringApplication.run(TbClientApplication.class, args);
		/*
		EntryService entryService = applicationContext.getBean(EntryService.class);
		ArrayList<Entry> entries = entryService.getEntries();
		System.out.println(entries);

		 */
	}

}
