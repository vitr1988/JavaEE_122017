package ru.otus.jasperreports;

import java.math.BigDecimal;

public class Employee {

    private BigDecimal EMPNO;
    private String ENAME;
    private String DNAME;

    public Employee() {
    }

    public Employee(BigDecimal EMPNO, String ENAME, String DNAME) {
        this.EMPNO = EMPNO;
        this.ENAME = ENAME;
        this.DNAME = DNAME;
    }

    public BigDecimal getEMPNO() {
        return EMPNO;
    }

    public void setEMPNO(BigDecimal EMPNO) {
        this.EMPNO = EMPNO;
    }

    public String getENAME() {
        return ENAME;
    }

    public void setENAME(String ENAME) {
        this.ENAME = ENAME;
    }

    public String getDNAME() {
        return DNAME;
    }

    public void setDNAME(String DNAME) {
        this.DNAME = DNAME;
    }
}
