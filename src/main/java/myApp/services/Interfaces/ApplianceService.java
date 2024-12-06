package myApp.services.Interfaces;


import myApp.models.Appliance;

import java.util.List;

public interface ApplianceService {


    List<Appliance> getAllAppliances();


    Appliance getApplianceById(Long id);


    void addAppliance(Appliance appliance);


    void updateAppliance(Long id, Appliance updatedAppliance);


    void deleteAppliance(Long id);


    List<Appliance> searchAppliances(String keyword);
}
