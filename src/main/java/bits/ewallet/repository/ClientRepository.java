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

/**
 *
 * @param clientType enum type of the client
 * @return list of all clients of the type
 */
	public List<Client> findByType(ClientType clientType);
/**
 *
 * @param username username of the client
 * @return list of users that contain this string in them
 */
	public List<Client> findByUsername(String username);
/**
 *
 * @param username username username of the client
 * @param sort sort parameter
 * @return list of all  users containing the user name
 */
	public List<Client> findByUsernameContainingIgnoreCase(String username, Sort sort);

}
