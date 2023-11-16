package org.example.endpoints;

import io.spring.guides.gs_producing_web_service.GetCityRequest;
import io.spring.guides.gs_producing_web_service.GetCityResponse;
import io.spring.guides.gs_producing_web_service.GetCountryRequest;
import io.spring.guides.gs_producing_web_service.GetCountryResponse;
import org.example.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * @author lh
 */
@Endpoint
public class CountryEndpoint {
    public static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    @Autowired
    private CountryRepository countryRepository;

    @PayloadRoot(namespace = NAMESPACE_URI,localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request){
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryRepository.findCountry(request.getName()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI,localPart = "getCityRequest")
    @ResponsePayload
    public GetCityResponse getCityCountry(@RequestPayload GetCityRequest request){
        GetCityResponse response = new GetCityResponse();
        response.setCountry(countryRepository.findCountry(request.getName()));
        return response;
    }
}
