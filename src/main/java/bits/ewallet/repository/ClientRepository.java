/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bits.ewallet.repository;

import bits.ewallet.entity.Client;
import bits.ewallet.enums.ClientType;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author amit
 */
public interface ClientRepository extends JpaRepository<Client,Long>{

	public List<Client> findByType(ClientType clientType);
	public List<Client> findByUsername(String username);
	public List<Client> findByUsernameContainingIgnoreCase(String username, Sort sort);

}
