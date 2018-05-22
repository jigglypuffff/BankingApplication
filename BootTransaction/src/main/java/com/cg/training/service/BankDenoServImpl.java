/*package com.cg.training.service;

public class BankDenoServImpl {

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public BankDenomination addDemomination(BigDecimal amount) {
		List<BigDecimal> currencyList = new ArrayList<BigDecimal>();
		currencyList.add(new BigDecimal(2000));
		currencyList.add(new BigDecimal(500));
		currencyList.add(new BigDecimal(200));
		currencyList.add(new BigDecimal(100));
		Random rand = new Random();
		BigDecimal remaining = amount;
		Integer length = currencyList.size();
		BankDenomination bankdenom = new BankDenomination();

		for (int i = 0; i <= length; i++) {
			Integer index = rand.nextInt(length);

			BigDecimal currencyValue = currencyList.get(index);

			if (currencyValue.compareTo(remaining) == 0 || currencyValue.compareTo(remaining) == -1) {

				bankdenom.setNoOfDenomination(remaining.divide(currencyValue));
				bankdenom.setDenomination(currencyValue);
				remaining = remaining.remainder(currencyValue);

				if (remaining.equals(0)) {
					break;
				}
			}
			currencyList.remove(index);
			
		}
		return bankdenom;
	}
}
*/