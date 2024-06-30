package models;
import Interfaces.IData;
import Service.ConsumerAPI;

import java.util.List;
import java.util.Map;

public class Curiosity implements IData {

    private final ConsumerAPI consumerAPI;

    public Curiosity(ConsumerAPI consumerAPI) {
        this.consumerAPI = consumerAPI;
    }

    @Override
    public String getRoverName() {
        return "Curiosity";
    }

    @Override
    public Map<String, List<MarsFilter>> fetchPhotosByCameraAndSol(String camera, int sol) {
        return consumerAPI.getPhotosByRoverCameraAndSol("curiosity", camera, sol);
    }

}