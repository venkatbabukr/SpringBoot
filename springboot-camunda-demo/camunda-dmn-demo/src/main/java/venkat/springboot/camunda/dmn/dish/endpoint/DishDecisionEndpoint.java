package venkat.springboot.camunda.dmn.dish.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import venkat.springboot.camunda.dmn.dish.service.DishDecisionService;

@RestController
@RequestMapping(path = "/dish")
public class DishDecisionEndpoint {

	@Autowired
	DishDecisionService svc;

	@RequestMapping(path = "/{season}/{numPeople}", method = RequestMethod.GET,
                        produces = MediaType.TEXT_PLAIN_VALUE)
	public String getDish(@PathVariable("season") String season,
                               @PathVariable("numPeople") int numPeople) {
		return svc.getDish(season, numPeople);
	}

}
