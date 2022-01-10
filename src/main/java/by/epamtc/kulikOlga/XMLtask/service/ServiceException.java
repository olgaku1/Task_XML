package by.epamtc.kulikOlga.XMLtask.service;

import by.epamtc.kulikOlga.XMLtask.bean.Bank;
import by.epamtc.kulikOlga.XMLtask.dao.DAOParser;
import by.epamtc.kulikOlga.XMLtask.dao.DAOFactory;
import by.epamtc.kulikOlga.XMLtask.dao.DAOException;

import java.util.List;

public class ServiceException extends Exception{
    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

}
