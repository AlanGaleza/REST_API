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
    @Override
    public void contribute(Info.Builder builder) {
        //COMPANY INFO
        Map<String, String> companyData = new HashMap<>();
        companyData.put("phone", "+48 505344961");
        companyData.put("email", "alanGaleza@gmail.com");
        companyData.put("goal", "Our goal is to make the world a better place!");
        companyData.put("name", "TaskCrudAppCreator");
        builder.withDetail("company", companyData);
    }

    public Map<String, String> companyInfo() {
        Map<String, String> companyData = new HashMap<>();
        companyData.put("phone", "+48 505344961");
        companyData.put("email", "alanGaleza@gmail.com");
        companyData.put("goal", "Our goal is to make the world a better place!");
        companyData.put("name", "TaskCrudAppCreator");
        return new HashMap<>(companyData);
    }
}
