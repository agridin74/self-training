package com.finance.service;

import com.finance.model.Transaction;
import com.finance.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getAllTransactions(){
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getTransactionById(Long id){
        return transactionRepository.findById(id);
    }

    public Transaction createTransaction(Transaction transaction){
        return transactionRepository.save(transaction);
    }

    public Transaction updateTransaction(Long id,Transaction transactionDetails){
        Transaction transaction = transactionRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("Transaction not found with id: "+id));
        transaction.setAmount(transactionDetails.getAmount());
        transaction.setDescription(transactionDetails.getDescription());
        transaction.setCategory(transactionDetails.getCategory());
        transaction.setTransactionDate(transactionDetails.getTransactionDate());
        return transactionRepository.save(transaction);
    }

    public void deleteTransaction(Long id){
        transactionRepository.deleteById(id);
    }

    public List<Transaction> getTransactionsByDateRange(LocalDateTime start, LocalDateTime end){
        return transactionRepository.findByTransactionDateBetweenOrderByTransactionDateDesc(start, end);
    }

}
