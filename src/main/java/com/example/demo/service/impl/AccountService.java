package com.example.demo.service.impl;

import com.example.demo.dao.AccountDao;
import com.example.demo.model.Account;
import com.example.demo.model.AccountExample;
import com.example.demo.service.MysqlService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService extends MysqlService {
    private AccountDao accountDao;

    @Autowired
    public AccountService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }


    public Optional<Account> getObjectById(Integer id) {
        return Optional.ofNullable(accountDao.selectByPrimaryKey(id));
    }

    public Optional<Account> getObjectByUsername(String username) {
        AccountExample example = new AccountExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<Account> accounts = accountDao.selectByExample(example);
        return Optional.ofNullable(accounts.size() > 0 ? accounts.get(0) : null);
    }

    public List<Account> getAllObject(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return accountDao.getAllAccount();
    }
}
