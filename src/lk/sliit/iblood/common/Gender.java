package lk.sliit.iblood.common;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2019-10-31
 * Time: 1:51 AM
 */
public final class Gender {

    public static final Gender MALE = new Gender(1);
    public static final Gender FEMALE = new Gender(0);
    private Integer type;

    private Gender() {
    }

    public static Gender valueOf(Integer val){
        return MALE.getType() == val ? MALE : FEMALE;
    }

    public static Gender valueOf(Boolean val){
        return val ? MALE : FEMALE;
    }

    @Override
    public String toString() {
        return type == 1 ? "Male" : "Female";
    }

    private Gender(Integer type) {
        this.type = type;
    }

    public static boolean isMale(Gender gender) {
        return gender.equals(MALE);
    }

    public static boolean isFemale(Gender gender) {
        return gender.equals(FEMALE);
    }

    public int getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gender)) return false;
        return type.equals(((Gender) o).type);
    }

    public static Gender[] getAllGenders(){
        return new Gender[]{MALE, FEMALE};
    }
}
