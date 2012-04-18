/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webref.database;

import org.springframework.data.jpa.repository.JpaRepository;
import webref.domain.DatabRef;

/**
 *
 * @author jarlerik
 */
public interface RefRepository extends JpaRepository<DatabRef, Long> {
    
}
