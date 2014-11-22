/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bits.ewallet.repository;

import bits.ewallet.entity.TransactionRecord;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author amit
 */
public interface TransactionRecordRepository extends JpaRepository<TransactionRecord,Long>{

}
