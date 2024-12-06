package myApp.services;

import myApp.models.Appliance;
import myApp.services.Interfaces.ApplianceService;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


class ApplianceServiceImpl implements ApplianceService {
    private final List<Appliance> appliances = new ArrayList<>();

    @Override
    public List<Appliance> getAllAppliances() {
        return new ArrayList<>(appliances);
    }

    @Override
    public Appliance getApplianceById(Long id) {
        return appliances.stream()
                .filter(appliance -> appliance.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void addAppliance(Appliance appliance) {
        appliances.add(appliance);
    }

    @Override
    public void updateAppliance(Long id, Appliance updatedAppliance) {
        for (int i = 0; i < appliances.size(); i++) {
            if (appliances.get(i).getId().equals(id)) {
                appliances.set(i, updatedAppliance);
                return;
            }
        }
    }

    @Override
    public void deleteAppliance(Long id) {
        appliances.removeIf(appliance -> appliance.getId().equals(id));
    }

    @Override
    public List<Appliance> searchAppliances(String keyword) {
        String lowerKeyword = keyword.toLowerCase();
        return appliances.stream()
                .filter(appliance -> appliance.getName().toLowerCase().contains(lowerKeyword) ||
                        appliance.getBrand().toLowerCase().contains(lowerKeyword) ||
                        appliance.getDescription().toLowerCase().contains(lowerKeyword))
                .collect(Collectors.toList());
    }
}