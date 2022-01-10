package by.epamtc.kulikOlga.XMLtask.dao;

import by.epamtc.kulikOlga.XMLtask.bean.Bank;

import java.util.ArrayList;
import java.util.List;

public interface DAOParser {
    public void parseBank(String path) throws DAOException;
    public List<Bank> getBanks();
}
