/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bits.ewallet.repository;

import bits.ewallet.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author amit
 */
public interface ClientRepository extends JpaRepository<Client,Long>{

//	public List<Client> findByClientType(ClientType clientType);

}
