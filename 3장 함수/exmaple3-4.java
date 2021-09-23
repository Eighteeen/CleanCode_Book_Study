public Money calculatePay(Employee e) throws InvalidEmployeeType {
  switch (e.type) {
    case COMMISSIONED:
      return calculateCommissionedPay(e);
    case HOURLY:
      return calculateHourlyPay(e);
    case SALARIED:
      return calculateSalariedPay(e);
    default:
      throw new InvalidEmployeeType(e.type);
  }
}

public Money calculateCommissionedPay(Employee commissionedEmployee) {
  // 수당을 받는 직원이 받을 급여를 계산하는 함수
}

public Money calculateHourlyPay(Employee hourlyPaidEmployee) {
  // 시급을 받는 직원이 받을 급여를 계산하는 함수
}

public Money calculateSalariedPay(Employee salariedEmployee) {
  // 봉급을 받는 직원이 받을 급여를 계산하는 함수
}


public boolean isPayday(Employee e, Date date) {
  switch (e.type) {
    case COMMISSIONED:
      return isCommissionedPayday(e);
    case HOURLY:
      return isHourlyPayday(e);
    case SALARIED:
      return isSalariedPayday(e);
    default:
      throw new InvalidEmployeeType(e.type);
  }
}

public boolean isCommissionedPayday(Employee commissionedEmployee, Date date) {
  // 이 날짜에 수당을 받는 직원의 급여 날인지
}

public boolean isHourlyPayday(Employee hourlyPaidEmployee, Date date) {
  // 이 날짜에 시급을 받는 직원의 급여 날인지
}

public boolean isSalariedPayday(Employee salariedEmployee, Date date) {
  // 이 날짜에 봉급을 받는 직원의 급여 날인지
}


public void deliverPay(Employee e, Money pay) {
  switch (e.type) {
    case COMMISSIONED:
      return calculateCommissionedPay(e);
    case HOURLY:
      return calculateHourlyPay(e);
    case SALARIED:
      return calculateSalariedPay(e);
    default:
      throw new InvalidEmployeeType(e.type);
  }
}

public void deliverCommissionedPay(Employee commissionedEmployee, Money pay) {
  // 수당을 받는 직원이 급여를 보냄
}

public void deliverHourlyPay(Employee hourlyPaidEmployee, Money pay) {
  // 시급을 받는 직원이 급여를 보냄
}

public void deliverSalariedPay(Employee salariedEmployee, Money pay) {
  // 봉급을 받는 직원이 급여를 보냄
}