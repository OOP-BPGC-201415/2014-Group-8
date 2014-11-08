/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bits.ewallet.formatter;

import bits.ewallet.entity.Client;
import bits.ewallet.repository.ClientRepository;
import java.text.ParseException;
import java.util.Locale;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

/**
 *
 * @author amit
 */
public class ClientFormatter implements Formatter<Client>{

	@Autowired
	private ClientRepository clientRepository;

	public String print(Client object, Locale locale) {
		return Objects.toString(object.getId());
	}

	public Client parse(String string, Locale locale) throws ParseException {
		return clientRepository.findOne(Long.valueOf(string));
	}

}
