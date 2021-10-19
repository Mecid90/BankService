package com.SuperBankApplication.SuperBankApplication;

import com.SuperBankApplication.SuperBankApplication.model.TransferBalance;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BankService {



    BalanceRepository repository = new BalanceRepository();

    public BankService(BalanceRepository balanceRepository) {

    }

    public BankService() {

    }


    public BigDecimal getBalance(Long accountId) {

        BigDecimal balance = repository.getBalanceForId(accountId);
        if(balance == null){
            throw new IllegalArgumentException();
        }
        return balance;
    }


    public BigDecimal addMoney(Long to, BigDecimal amount) {

        BigDecimal currentBalance = repository.getBalanceForId(to);

        if (currentBalance == null){

            repository.save(to,amount);
            return amount;
        }else{
            BigDecimal updatedBalance = currentBalance.add(amount);
            repository.save(to,updatedBalance);
            return updatedBalance;
        }
    }


    public void makeTransfer(TransferBalance transferBalance) {

        BigDecimal fromBalance = repository.getBalanceForId(transferBalance.getFrom());

        BigDecimal toBalance = repository.getBalanceForId(transferBalance.getTo());

        if (fromBalance == null || toBalance == null) throw new IllegalArgumentException("no id");

        if (transferBalance.getAmount().compareTo(fromBalance) > 0) throw new IllegalArgumentException("no money");

        final BigDecimal updatedFromBalance = fromBalance.subtract(transferBalance.getAmount());
        final BigDecimal updatedToBalance = toBalance.add(transferBalance.getAmount());

        repository.save(transferBalance.getFrom(),updatedFromBalance);
        repository.save(transferBalance.getTo(),updatedToBalance);

    }

}
