package com.discovery.project.Service;

import com.discovery.project.Model.Health;
import com.discovery.project.Model.MidResult;
import com.discovery.project.Model.MidServer;
import com.discovery.project.Model.MongoModel;
import com.discovery.project.Repository.MongoRepo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

@Service
public class HttpsService {


    @Autowired
    MongoRepo mongoRepo;

    public String Healthcheck() {
        return "success";
    }


    public Object getInstanceHealth() {

    List consolidatedResponse = new ArrayList();

        Iterable<MongoModel> instances = mongoRepo.findAll();

        for (MongoModel inst : instances) {
            System.out.println(inst);
            RestTemplate restTemplate = new RestTemplate();
            String uri = "https://" + inst.getInstance() + "/api/now/table/ecc_agent";

            HttpHeaders header = new HttpHeaders();
            header.setBasicAuth(inst.getUsername(), inst.getPassword());

            HttpEntity<String> requestEntity = new HttpEntity<>(header);
//method 1
//            ResponseEntity<MidResult> response = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, MidResult.class);
//            MidResult midResult = response.getBody();
//
//            MidServer[] results = midResult.getResult();
//            for (MidServer m : results) {
//                Health health=new Health(inst.getInstance(), m.getSys_id(), m.getName(), m.getStatus());
//                consolidatedResponse.add(health);
//            }
//
//        return consolidatedResponse;

//method 2
            ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);
            try {
                JSONObject jsonObject = new JSONObject(response.getBody());
                JSONArray jsonArray=jsonObject.getJSONArray("result");
                for(int i=0;i<jsonArray.length();i++){
                JSONObject parameters = jsonArray.getJSONObject(i);
                    Health health=new Health(inst.getInstance(),parameters.get("sys_id").toString(), parameters.get("name").toString(), parameters.get("status").toString());
                    consolidatedResponse.add(health);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return consolidatedResponse;

//end
        }

        return  null;
        }


//        public Object getInstancePlugin()
//        {
//            return null;
//        }

    }