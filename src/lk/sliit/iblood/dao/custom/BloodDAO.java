package lk.sliit.iblood.dao.custom;

import lk.sliit.iblood.dao.CrudDAO;
import lk.sliit.iblood.entity.Blood;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-10-31
 * Time: 11:24 AM
 */
public interface BloodDAO extends CrudDAO<Integer, Blood> {
    Integer getLastIncrementedValue() throws Exception;
}
