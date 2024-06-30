package models;

import Interfaces.IData;
import Service.ConsumerAPI;

import java.util.List;
import java.util.Map;

public class Opportunity implements IData {

    private final ConsumerAPI consumerAPI;

    public Opportunity(ConsumerAPI consumerAPI) {
        this.consumerAPI = consumerAPI;
    }

    @Override
    public String getRoverName() {
        return "Opportunity";
    }

    @Override
    public Map<String, List<MarsFilter>> fetchPhotosByCameraAndSol(String camera, int sol) {
        return consumerAPI.getPhotosByRoverCameraAndSol(getRoverName().toLowerCase(), camera, sol);
    }


}