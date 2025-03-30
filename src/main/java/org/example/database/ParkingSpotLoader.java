package org.example.database;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.ParkingSpot;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ParkingSpotLoader {
    public List<ParkingSpot> loadParkingSpotsFromJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("parking_spots.json");

        if(inputStream == null){
            return null;
        }
        return objectMapper.readValue(inputStream, objectMapper.getTypeFactory().constructCollectionType(List.class, ParkingSpot.class));
    }
}
