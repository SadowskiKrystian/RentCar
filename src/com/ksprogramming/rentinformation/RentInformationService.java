package com.ksprogramming.rentinformation;

import java.sql.Connection;
import java.util.List;

public class RentInformationService {
    private Connection connection;
    private RentInformationRepository rentInformationRepository;

    public RentInformationService(Connection connection) {
        this.connection = connection;
        rentInformationRepository = new RentInformationRepository(connection);
    }

    public RentInformation getId(Integer id){
        return rentInformationRepository.getId(id);
    }

    public List<RentInformation> find(RentInformation rentInformation){
        return rentInformationRepository.find(rentInformation);
    }

    public Integer create(RentInformation rentInformation){
        return rentInformationRepository.create(rentInformation);
    }

    public void update(Integer id, RentInformation rentInformation){
        rentInformationRepository.update(id, rentInformation);
    }

    public void remove(Integer id){
        rentInformationRepository.remove(id);
    }
}
