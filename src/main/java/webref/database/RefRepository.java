/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webref.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webref.domain.Book;
import webref.domain.DatabRef;
import webref.domain.Viite;

/**
 *
 * @author jarlerik
 */
public interface RefRepository extends JpaRepository<DatabRef, Long> {
    
}
