package lk.sliit.iblood.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-10-31
 * Time: 1:06 AM
 */
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE, ElementType.TYPE_USE})
public @interface Entity {
}
