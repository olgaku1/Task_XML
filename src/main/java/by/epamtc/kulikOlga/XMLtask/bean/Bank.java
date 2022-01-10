package by.epamtc.kulikOlga.XMLtask.bean;

import java.io.Serializable;

public class Bank implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String country;
    private String type;
    private String depositor;
    private int accountID;
    private double depositAmount;
    private double profitability;
    private int timeConstraints;

    public Bank() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDepositor() {
        return depositor;
    }

    public void setDepositor(String depositor) {
        this.depositor = depositor;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public double getProfitability() {
        return profitability;
    }

    public void setProfitability(double profitability) {
        this.profitability = profitability;
    }

    public int getTimeConstraints() {
        return timeConstraints;
    }

    public void setTimeConstraints(int timeConstraints) {
        this.timeConstraints = timeConstraints;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (null == obj) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Bank bank = (Bank) obj;
        if (null == name) {
            return (name == bank.name);
        } else {
            if (!name.equals(bank.name)) {
                return false;
            }
        }
        if (null == country) {
            return (country == bank.country);
        } else {
            if (!country.equals(bank.country)) {
                return false;
            }
        }
        if (null == type) {
            return (type == bank.type);
        } else {
            if (!type.equals(bank.type)) {
                return false;
            }
        }
        if (null == depositor) {
            return (depositor == bank.depositor);
        } else {
            if (!depositor.equals(bank.depositor)) {
                return false;
            }
        }

        if (accountID != bank.accountID) {
            return false;
        }
        if (depositAmount != bank.depositAmount) {
            return false;
        }
        if (profitability != bank.profitability) {
            return false;
        }
        if (timeConstraints != bank.timeConstraints) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int primeNumber = 17;
        int result = 1;
        result = (int) (primeNumber * accountID + primeNumber * depositAmount
                + primeNumber * profitability + primeNumber * timeConstraints
                + ((null == name) ? 0 : name.hashCode()));
        result = primeNumber * result + ((null == country) ? 0 : country.hashCode());
        result = primeNumber * result + ((null == type) ? 0 : type.hashCode());
        result = primeNumber * result + ((null == depositor) ? 0 : depositor.hashCode());
        return result;
    }


    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append("\nBank(name: ").append(name).append(", country: ").append(country).append(")").
                append("\nType: ").append(type).
                append("\nDepositor: ").append(depositor).
                append("\nAccount ID: ").append(accountID).
                append("\nAmount on deposit: ").append(depositAmount).
                append("\nProfitability: ").append(profitability).
                append("\nTime constraints: ").append(timeConstraints);
        return info.toString();
    }

    public static class Builder{
        private Bank newBank;

        public Builder() {
            newBank = new Bank();
        }

        public Builder withName(String name){
            newBank.name = name;
            return this;
        }

        public Builder withCountry(String country){
            newBank.country = country;
            return this;
        }

        public Builder withType(String type){
            newBank.type = type;
            return this;
        }

        public Builder withDepositor(String depositor){
            newBank.depositor = depositor;
            return this;
        }
        public Builder withAccountID(int accountID){
            newBank.accountID = accountID;
            return this;
        }
        public Builder withDepositAmount(double depositAmount){
            newBank.depositAmount = depositAmount;
            return this;
        }
        public Builder withProfitability(double profitability){
            newBank.profitability = profitability;
            return this;
        }
        public Builder withTimeConstraints(int timeConstraints){
            newBank.timeConstraints = timeConstraints;
            return this;
        }

        public Bank build() {
            return newBank;
        }

    }
}
