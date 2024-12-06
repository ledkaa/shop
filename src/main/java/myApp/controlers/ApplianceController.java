/*
package myApp.controlers;

import myApp.models.Appliance;
import myApp.services.Interfaces.ApplianceService;

import java.util.List;

@RestController
@RequestMapping("/api/appliances")
public class ApplianceController {

    //@Autowired
    private ApplianceService applianceService;

    //@GetMapping
    public List<Appliance> getAllAppliances() {
        return applianceService.getAllAppliances();
    }

    //@GetMapping("/{id}")
    public Appliance getApplianceById(@PathVariable Long id) {
        return applianceService.getApplianceById(id);
    }

    @PostMapping
    public void addAppliance(@RequestBody Appliance appliance) {
        applianceService.addAppliance(appliance);
    }

    @PutMapping("/{id}")
    public void updateAppliance(@PathVariable Long id, @RequestBody Appliance appliance) {
        applianceService.updateAppliance(id, appliance);
    }

    @DeleteMapping("/{id}")
    public void deleteAppliance(@PathVariable Long id) {
        applianceService.deleteAppliance(id);
    }

    @GetMapping("/search")
    public List<Appliance> searchAppliances(@RequestParam String keyword) {
        return applianceService.searchAppliances(keyword);
    }
}
*/
