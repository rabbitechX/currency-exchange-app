package com.example.currencyexchange;

import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ArrayList;
// import com.example.currencyexchange.entity.CurrencyData;

@Service
public class CurrencyDataService {

    @Autowired
    private CurrencyDataRepository currencyDataRepository;

    // Read data from URL
    public List<CurrencyData> getCurrencyDataFromUrl(String url) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<CurrencyData> currencyDataList = objectMapper.readValue(new URL(url), new TypeReference<List<CurrencyData>>() {});
        return currencyDataList;
    }
    
    // Read all from DB
    public List<CurrencyData> getDataFromDatabase() {
      return currencyDataRepository.findAll();
    }
    
    // Save rate to DB
    public CurrencyData saveDataToDatabase(CurrencyData currencyData) {
        return currencyDataRepository.save(currencyData);
    }
    
    // Save all to DB
    public List<CurrencyData> saveAllDatabase(List<CurrencyData> currencyData) {
        return currencyDataRepository.saveAll(currencyData);
    }
    
    // Delete all DB
    public void deleteAllDatabase() {
        currencyDataRepository.deleteAll();
    }
}

