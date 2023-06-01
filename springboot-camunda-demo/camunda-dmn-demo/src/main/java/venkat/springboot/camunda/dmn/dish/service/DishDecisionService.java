package venkat.springboot.camunda.dmn.dish.service;

import java.util.List;
import java.util.Map;

import org.camunda.bpm.dmn.engine.DmnDecisionTableResult;
import org.camunda.bpm.engine.DecisionService;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DishDecisionService {

	@Autowired
	DecisionService decisionService;

	public String getDish(String season, int numGuests) {
		System.out.println("Decision service: " + decisionService);
		VariableMap vars = Variables.createVariables()
                               .putValue("season", season)
                               .putValue("numGuests", numGuests);
		DmnDecisionTableResult decisionResult = decisionService.evaluateDecisionTableByKey("dish", vars);
		List<Map<String, Object>> resultsList = decisionResult.getResultList();
		log.info("Complete resultList {}", resultsList);
		String dish = decisionResult.getSingleEntry();
		return dish;
	}

}
