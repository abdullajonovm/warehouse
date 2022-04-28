package com.kindsonthegenius.fleetmsv2.accounts.services;

import com.kindsonthegenius.fleetmsv2.accounts.models.Transaction;
import com.kindsonthegenius.fleetmsv2.accounts.repositories.TransactionRepository;
import com.kindsonthegenius.fleetmsv2.reports.model.Truck;
import com.kindsonthegenius.fleetmsv2.reports.repository.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private TruckRepository truckRepository;

    //Get All Transactions
    public List<Transaction> findAll(){
        return transactionRepository.findAll();
    }

    //Get Transaction By Id
    public Transaction findById(int id) {
        return transactionRepository.findById(id).orElse(null);
    }

    //Delete Transaction
    public void delete(int id) {
        transactionRepository.deleteById(id);
        Truck truck = truckRepository.findFirstByOrderByIdDesc();
        truck.setTransactionCount(truck.getTransactionCount()-1);
        truckRepository.save(truck);
    }

    //Update Transaction
    public void save(Transaction transaction) {
        Truck truck = truckRepository.findFirstByOrderByIdDesc();
        truck.setTransactionCount(truck.getTransactionCount()+1);
        truckRepository.save(truck);
        transactionRepository.save(transaction);
    }

}
