package com.techsolution.restaurant.satisfaction_analyzer;

import com.sun.corba.se.impl.orbutil.closure.Constant;
import com.techsolution.restaurant.dao.SatisfactionAnalyzer;
import com.techsolution.restaurant.dao.impl.SatisfactionAnalyzerImpl;
import com.techsolution.restaurant.helper.Constants;
import com.techsolution.restaurant.vo.SatisfactionStatsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
public class SatisfactionAnalyzerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SatisfactionAnalyzerApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		SatisfactionAnalyzer satisfactionAnalyzer = new SatisfactionAnalyzerImpl(Constants.SATISFACTION_INDEX_FILE);
		satisfactionAnalyzer.loadAndGetHeader();
		satisfactionAnalyzer.loadAndGetRecords();
		System.out.println(satisfactionAnalyzer.getSumOfSatisfactionWithinGivenMinutes());
	}
}
