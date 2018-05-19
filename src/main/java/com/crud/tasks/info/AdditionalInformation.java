package com.crud.tasks.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class AdditionalInformation implements InfoContributor {
    private static final Map<String, String> companyData;
    static {
        companyData = new HashMap<>();
        companyData.put("phone", "+48 505344961");
        companyData.put("email", "alanGaleza@gmail.com");
        companyData.put("goal", "Our goal is to make the world a better place!");
        companyData.put("name", "TaskCrudAppCreator");
    }
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("company", companyData);
    }

    public Map<String, String> companyInfo() {
        return new HashMap<>(companyData);
    }

    @Override
    public String toString() {
        return companyData.entrySet().stream()
                .map(entry -> entry.getKey() + " : " + entry.getValue() + "\n")
                .collect(Collectors.joining());
    }
}
