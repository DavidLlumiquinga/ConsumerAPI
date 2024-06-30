package Controller;

import Interfaces.IData;
import Service.ConsumerAPI;
import models.Curiosity;
import models.MarsFilter;
import models.Opportunity;
import models.Spirit;

import javax.swing.*;
import java.util.List;
import java.util.Map;

public class Controller {
    private final ConsumerAPI apiService;

    private static final String ROVER_CURIOSITY = "curiosity";
    private static final String ROVER_OPPORTUNITY = "opportunity";
    private static final String ROVER_SPIRIT = "spirit";

    public Controller() {
        this.apiService = new ConsumerAPI();
    }

    public IData getCuriosityRover() {
        return new Curiosity(apiService);
    }

    public IData getOpportunityRover() {
        return new Opportunity(apiService);
    }

    public IData getSpiritRover() {
        return new Spirit(apiService);
    }

    public Map<String, List<MarsFilter>> fetchAndDisplayPhotos(String roverName, String camera, int sol, JTextArea infoTextArea) {
        IData rover = getRoverByName(roverName);
        if (rover != null) {
            Map<String, List<MarsFilter>> photos = rover.fetchPhotosByCameraAndSol(camera, sol);
            if (photos.isEmpty()) {
                infoTextArea.setText("\nNo se encontraron fotos para el rover " + roverName + ", cámara " + camera + " y sol " + sol + "\n");
            }
            return photos;
        } else {
            infoTextArea.setText("Rover no reconocido: " + roverName + "\n");
            return null;
        }
    }

    private IData getRoverByName(String roverName) {
        switch (roverName.toLowerCase()) {
            case ROVER_CURIOSITY:
                return getCuriosityRover();
            case ROVER_OPPORTUNITY:
                return getOpportunityRover();
            case ROVER_SPIRIT:
                return getSpiritRover();
            default:
                return null;
        }
    }
}
