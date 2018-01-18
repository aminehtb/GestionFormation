/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import models.formation;
import java.util.ArrayList;

/**
 *
 * @author amir
 */
public interface formationDAO {
    public abstract ArrayList<formation> findAll();
    
}
