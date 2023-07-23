package venkat.springboot.simple.jpademo.common.validation;

/*
 * See https://reflectoring.io/bean-validation-with-spring-boot/ for lot of details...
 */
public interface ValidationGroups {

	public static interface OnCreate { }

	public static interface OnEdit extends OnCreate { }

}
