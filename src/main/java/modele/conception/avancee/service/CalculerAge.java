package modele.conception.avancee.service;

import modele.conception.avancee.bean.CalculerAgeResponse;
import modele.conception.avancee.bean.Personne;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/** web service metier */

@Endpoint
public class CalculerAge {
    private static final String NAMESPACE_URI = "http://ing3.upec.fr/beans";

    public CalculerAge(){

    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "calculerAgeRequest")
    @ResponsePayload
    public CalculerAgeResponse getAge(@RequestPayload Personne personne){

        CalculerAgeResponse response = new CalculerAgeResponse();
        LocalDate dataBefore = LocalDate.now();
        LocalDate dataAfter = personne.getNaissance().toGregorianCalendar()
                                .toZonedDateTime().toLocalDate();
        long yearsBetween = ChronoUnit.YEARS.between(dataBefore, dataAfter);
        response.setAge(yearsBetween);

        return response;
    }
}
