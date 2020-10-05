package com.springbootApplication.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springbootApplication.entity.RateExchange;

@RestController
@RequestMapping("/getXRates")
public class GetExchangeRateService {
	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/{date}/{currency}")
	public RateExchange getExchangeRates(@PathVariable("date") String date, @PathVariable("currency") String currency) {

		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject("http://localhost:8080/getdata/" + date + "/" + currency, RateExchange.class);

	}

}
