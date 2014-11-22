/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bits.ewallet.formatter;

import bits.ewallet.entity.TransactionRecord;
import bits.ewallet.repository.TransactionRecordRepository;
import java.text.ParseException;
import java.util.Locale;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

/**
 *
 * @author amit
 */
public class TransactionRecordFormatter implements Formatter<TransactionRecord>{

	@Autowired
	private TransactionRecordRepository transactionRecordRepository;
/**
 *
 * @param object transaction entity to be formatted
 * @param locale
 * @return string value for the corresponding entity
 */
	public String print(TransactionRecord object, Locale locale) {
		return Objects.toString(object.getId());
	}
/**
 *
 * @param string string for the object
 * @param locale
 * @return transaction from database table corresponding to string
 * @throws ParseException
 */
	public TransactionRecord parse(String string, Locale locale) throws ParseException {
		return transactionRecordRepository.findOne(Long.valueOf(string));
	}

}
