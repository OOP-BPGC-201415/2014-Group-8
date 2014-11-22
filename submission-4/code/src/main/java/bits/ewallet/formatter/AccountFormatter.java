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
/**
 *
 * @param object account entity to be formatted
 * @param locale
 * @return string value for the corresponding entity
 */
	public String print(Account object, Locale locale) {
		return Objects.toString(object.getId());
	}
/**
 *
 * @param string string for the object
 * @param locale
 * @return account from database table corresponding to string
 * @throws ParseException
 */
	public Account parse(String string, Locale locale) throws ParseException {
		return accountRepository.findOne(Long.valueOf(string));
	}

}
