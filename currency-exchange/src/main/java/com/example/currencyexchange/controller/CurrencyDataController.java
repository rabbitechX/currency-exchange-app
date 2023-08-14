package com.example.currencyexchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.IOException;
import java.util.List;



@RestController
@RequestMapping("/currency")
@CrossOrigin(origins = "http://localhost:3000") // Povolit přístup z http://localhost:3000
public class CurrencyDataController {

    private static final String URL_SOURCE = "https://webapi.developers.erstegroup.com/api/csas/public/sandbox/v2/rates/exchangerates?web-api-key=c52a0682-4806-4903-828f-6cc66508329e"; // URL zdroje dat

    @Autowired
    private CurrencyDataService currencyDataService;

/*
    @GetMapping
    public List<CurrencyData> getCurrencyData() throws IOException {
        return currencyDataService.getCurrencyDataFromUrl(URL_SOURCE);
    }
*/
    
    @GetMapping
    public List<CurrencyData> getCurrencyData(@RequestParam(required = false) boolean usedb) throws IOException {
        if (usedb) {
            // Read all from DB
            return currencyDataService.getDataFromDatabase();
        } else {
            // Delete all DB
            // Read data from URL and save all to DB
            currencyDataService.deleteAllDatabase();
            return currencyDataService.saveAllDatabase(currencyDataService.getCurrencyDataFromUrl(URL_SOURCE));
        }
    }
    
    // Read all from DB
    @GetMapping("/db")
    public List<CurrencyData> getCurrencyData() throws IOException {
        return currencyDataService.getDataFromDatabase();
    }
    
    // Save one rate to DB
    @PostMapping("/db1")
    public CurrencyData saveCurrencyData(@RequestBody CurrencyData currencyData) throws IOException {
        return currencyDataService.saveDataToDatabase(currencyData);
    }
    
    // Save all to DB
    @PostMapping("/db")
    public List<CurrencyData> saveAllDatabase(@RequestBody List<CurrencyData> currencyData) throws IOException {
        return currencyDataService.saveAllDatabase(currencyData);
    }
    
    // Delete all DB
    @DeleteMapping("/db")
    public String deleteAllDatabase() {
        currencyDataService.deleteAllDatabase();
        return "All users have been deleted successfully.";
    }
    
}

