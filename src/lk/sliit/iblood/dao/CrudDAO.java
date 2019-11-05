/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.sliit.iblood.dao;

import lk.sliit.iblood.common.Entity;

import java.util.ArrayList;
import java.util.List;

public interface CrudDAO<I, E> extends SuperDAO {

    Boolean save(@Entity E ent) throws Exception;

    Boolean update(@Entity E ent) throws Exception;

    Boolean delete(I e) throws Exception;

    E search(@Entity I id) throws Exception;

    List<E> getAll() throws Exception;
}
