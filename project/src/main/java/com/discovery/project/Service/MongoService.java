package com.discovery.project.Service;

import com.discovery.project.Model.MongoModel;
import com.discovery.project.Repository.MongoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service

public class MongoService {

    @Autowired
    MongoRepo mongoRepo;

    public List<MongoModel> getAll()
    {
        return mongoRepo.findAll();
    }

    public MongoModel create(MongoModel mongoModel)
    {
        return mongoRepo.insert(mongoModel);
    }
    public void delete(String id)
    {
        mongoRepo.deleteById(id);
    }
    public  MongoModel Alter(String id,MongoModel mongoModel)
    {
        MongoModel asd=mongoRepo.findById(id).get();
        if(asd!=null)
        {
            asd.setId(mongoModel.getId());
           asd.setInstance(mongoModel.getInstance());
           asd.setPassword(mongoModel.getPassword());
           asd.setUsername(mongoModel.getUsername());
           asd.setTag(mongoModel.getTag());
           mongoRepo.save(asd);
           return asd;
        }
        else
        {
            return null;
        }
    }
}
