package lk.sliit.iblood.business;

import lk.sliit.iblood.model.DoctorDTO;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-10-31
 * Time: 9:19 PM
 */
public interface Modeler<T> {
    String[] toStringArray();

    T validateAndReturn() throws Exception;
    T validateWithPKeyAndReturn() throws Exception;
}
