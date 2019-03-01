package com.app.bankappointments.Controller;

import com.app.bankappointments.repository.LocationRepository;
import com.app.bankappointments.model.Location;
import com.app.bankappointments.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
public class LocationsController {

    @Autowired
    LocationRepository locationRepository;

    // Get All Locations
    @GetMapping("/locations")
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    // Create a new Location
    @PostMapping("/locations")
    public Location createLocation(@Valid @RequestBody Location location) {
        return locationRepository.save(location);
    }

    // Get a Single Location
    @GetMapping("/locations/{id}")
    public Location getLocationById(@PathVariable(value="id") Long locationId) {
        return locationRepository.findById(locationId)
                .orElseThrow(() -> new ResourceNotFoundException("Location", "id", locationId));
    }

    // Update a Location
    @PutMapping("/locations/{id}")
    public Location updateLocation(@PathVariable(value="id") Long locationId,
                                   @Valid @RequestBody Location locationDetails) {
        Location location = locationRepository.findById(locationId)
                .orElseThrow(() -> new ResourceNotFoundException("Location", "id", locationId));

//        NOTE: Uncomment these once getters and setters are created in Location class
        location.setAddress(locationDetails.getAddress());
        location.setCity(locationDetails.getCity());
        location.setState(locationDetails.getState());
        location.setZipcode(locationDetails.getZipcode());

        Location updateLocation = locationRepository.save(location);
        return updateLocation;
    }

    // Delete a Location
    @DeleteMapping("/locations/{id}")
    public ResponseEntity<?> deleteLocations(@PathVariable(value="id") Long locationId) {
        Location location = locationRepository.findById(locationId)
                .orElseThrow(() -> new ResourceNotFoundException("Location", "id", locationId));

        locationRepository.delete(location);

        return  ResponseEntity.ok().build();

    }
}
