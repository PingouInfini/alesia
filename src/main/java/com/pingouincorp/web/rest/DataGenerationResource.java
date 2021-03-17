package com.pingouincorp.web.rest;

import com.pingouincorp.domain.Location;
import com.pingouincorp.domain.Organization;
import com.pingouincorp.domain.Person;
import com.pingouincorp.service.LocationService;
import com.pingouincorp.service.OrganizationService;
import com.pingouincorp.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DataGenerationResource {

    private final Logger log = LoggerFactory.getLogger(DataGenerationResource.class);

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final PersonService personService;
    private final OrganizationService organizationService;
    private final LocationService locationService;

    public DataGenerationResource(PersonService personService,
                                  OrganizationService organizationService,
                                  LocationService locationService) {
        this.personService = personService;
        this.organizationService = organizationService;
        this.locationService = locationService;
    }

    @GetMapping("/eraseAllDatas")
    public ResponseEntity<String> eraseAllDatas(Boolean yesImSure) {
        log.debug("REST request to clear DATAs");
        if(yesImSure) {
            for (Person i : personService.findAll(PageRequest.of(0, 1000))) {
                personService.delete(i.getId());
            }
            for (Organization g : organizationService.findAll(PageRequest.of(0, 1000))) {
                organizationService.delete(g.getId());
            }
            for (Location l : locationService.findAll(PageRequest.of(0, 1000))) {
                locationService.delete(l.getId());
            }
        }
        return new ResponseEntity<>("Terminé avec succès ", HttpStatus.OK);
    }

}
