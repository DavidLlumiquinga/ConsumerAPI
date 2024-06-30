package Interfaces;

import models.MarsFilter;

import java.util.List;
import java.util.Map;

public interface IData {
    String getRoverName();
    Map<String, List<MarsFilter>> fetchPhotosByCameraAndSol(String camera, int sol);
}
