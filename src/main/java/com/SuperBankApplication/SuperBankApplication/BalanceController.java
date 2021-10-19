package com.SuperBankApplication.SuperBankApplication;


import com.SuperBankApplication.SuperBankApplication.model.TransferBalance;


import org.springframework.web.bind.annotation.*;


import java.math.BigDecimal;




@RestController("/balance")
public class BalanceController {

    BankService bankService = new BankService();

    // получить баланс
    @GetMapping("/{accountId}")
    public BigDecimal getBalance(@PathVariable Long accountId){
       return bankService.getBalance(accountId);

    }

    // внести отправляемую сумму
    @PostMapping("/add")
    public BigDecimal addMoney(@RequestBody TransferBalance transferBalance){
        return bankService.addMoney(transferBalance.getTo(),transferBalance.getAmount());

    }

    // отправить добавленную сумму
    @PostMapping("/transfer")
    public void transfer(@RequestBody TransferBalance transferBalance ){

        bankService.makeTransfer(transferBalance);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String handle(IllegalArgumentException e){

        e.getMessage();
        return "ПОЛЬЗОВАТЕЛЬ НЕ НАЙДЕН";

    }
}
