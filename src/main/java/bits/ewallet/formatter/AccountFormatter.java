/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bits.ewallet.formatter;

import bits.ewallet.entity.Account;
import bits.ewallet.repository.AccountRepository;
import java.text.ParseException;
import java.util.Locale;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

/**
 *
 * @author amit
 */
public class AccountFormatter implements Formatter<Account>{

	@Autowired
	private AccountRepository accountRepository;

	public String print(Account object, Locale locale) {
		return Objects.toString(object.getId());
	}

	public Account parse(String string, Locale locale) throws ParseException {
		return accountRepository.findOne(Long.valueOf(string));
	}

}
