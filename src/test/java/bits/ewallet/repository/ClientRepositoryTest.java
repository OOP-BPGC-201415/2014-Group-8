/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bits.ewallet.repository;

import bits.ewallet.entity.Client;
import bits.ewallet.spring.SpringLoader;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author amit
 */
public class ClientRepositoryTest extends TestCase{

	public void testSave(){
		SpringLoader sl = new SpringLoader();
		ApplicationContext context = sl.getJpaContext();
		ClientRepository cr = context.getBean(ClientRepository.class);
		Client c = new Client();
		c.setUserName("test user");
		assertEquals(cr.saveAndFlush(c), c);

	}

	public void testFindAll(){
		SpringLoader sl = new SpringLoader();
		ApplicationContext context = sl.getJpaContext();
		ClientRepository cr = context.getBean(ClientRepository.class);
		assertEquals(cr.findAll().get(0).getUserName(), "test user");
	}


}
