package com.app.bankappointments.Controller;

import com.app.bankappointments.model.Locations;
import com.app.bankappointments.repository.LocationRepository;
import com.app.bankappointments.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api")
public class LocationsController {


    @Autowired
    LocationRepository locationsRepository;

//    // Get All Locations
//    @RequestMapping(value="city", method = RequestMethod.GET)
//    public List<Locations> getAllLocations() {
//
//        return locationsRepository.findAll()
//                .parallelStream()
//                .filter(l -> l.getId() < 100).collect(Collectors.toList());
//    }

    // Get All Locations
    @GetMapping("/locations")
    public List<Locations> getAllLocations() {

        return locationsRepository.findAll()
                .parallelStream()
                .filter(l -> l.getId() < 100).collect(Collectors.toList());
    }

    @GetMapping("/locations/cities")
    public List<Object> getCities(HttpServletRequest httpServletRequest) {
        return locationsRepository.findByCity("Grandview");
    }

    // Create a new Locations
    @PostMapping("/locations")
    public Locations createLocation(@Valid @RequestBody Locations location) {
        return locationsRepository.save(location);
    }

    // Get a Single Locations
    @GetMapping("/locations/{id}")
    public Locations getLocationById(@PathVariable(value="id") Long locationId) {
        return locationsRepository.findById(locationId)
                .orElseThrow(() -> new ResourceNotFoundException("Locations", "id", locationId));
    }

    // Update a Locations
    @PutMapping("/locations/{id}")
    public Locations updateLocation(@PathVariable(value="id") Long locationId,
                                    @Valid @RequestBody Locations locationDetails) {
        Locations location = locationsRepository.findById(locationId)
                .orElseThrow(() -> new ResourceNotFoundException("Locations", "id", locationId));

//        NOTE: Uncomment these once getters and setters are created in Locations class
        location.setAddress(locationDetails.getAddress());
        location.setCity(locationDetails.getCity());
        location.setState(locationDetails.getState());
        location.setZipcode(locationDetails.getZipcode());

        Locations updateLocation = locationsRepository.save(location);
        return updateLocation;
    }

    // Delete a Locations
    @DeleteMapping("/locations/{id}")
    public ResponseEntity<?> deleteLocations(@PathVariable(value="id") Long locationId) {
        Locations location = locationsRepository.findById(locationId)
                .orElseThrow(() -> new ResourceNotFoundException("Locations", "id", locationId));

        locationsRepository.delete(location);

        return  ResponseEntity.ok().build();

    }
}
