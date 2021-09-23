public abstract class Employee {
  public abstract Money calculatePay();
  public abstract boolean isPayday(Date date);
  public abstract void deliverPay(Money pay);
}

public interface EmployeeFactory {
  public Employee makeEmployee(EmployeeRecord r) throws InvalidEmployeeType;
}

public class EmployeeFactoryImpl implements EmployeeFactory {
  public Employee makeEmployee(EmployeeRecord r) throws InvalidEmployeeType {
    switch (r.type) {
      case COMMISSIONED:
        return new CommissionedEmployee(r);
      case HOURLY:
        return new HourlyEmployee(r);
      case SALARIED:
        return new SalariedEmployee(r);
      default:
        throw new InvalidEmployeeType(r.type);
    }
  }
}

class ComissionedEmployee extends Employee {
  public ComissionedEmployee(EmployeeRecord r) {
    // 초기화
  }

  public Money calculatePay() {
    // 급여 계산
  }

  public boolean isPayday(Date date) {
    // 급여 받는 날?
  }

  public void deliverPay(Money pay) {
    // 급여 전달
  }
}

class HourlyEmployee extends Employee {
  public HourlyEmployee(EmployeeRecord r) {
    // 초기화
  }

  public Money calculatePay() {
    // 급여 계산
  }

  public boolean isPayday(Date date) {
    // 급여 받는 날?
  }

  public void deliverPay(Money pay) {
    // 급여 전달
  }
}

class SalariedEmployee extends Employee {
  public SalariedEmployee(EmployeeRecord r) {
    // 초기화
  }

  public Money calculatePay() {
    // 급여 계산
  }

  public boolean isPayday(Date date) {
    // 급여 받는 날?
  }

  public void deliverPay(Money pay) {
    // 급여 전달
  }
}