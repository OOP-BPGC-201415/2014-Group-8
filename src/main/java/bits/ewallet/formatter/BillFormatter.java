/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bits.ewallet.formatter;

import bits.ewallet.entity.Bill;
import bits.ewallet.repository.BillRepository;
import java.text.ParseException;
import java.util.Locale;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

/**
 *
 * @author amit
 */
public class BillFormatter implements Formatter<Bill>{

	@Autowired
	private BillRepository billRepository;

	public String print(Bill object, Locale locale) {
		return Objects.toString(object.getId());
	}

	public Bill parse(String string, Locale locale) throws ParseException {
		return billRepository.findOne(Long.valueOf(string));
	}

}
