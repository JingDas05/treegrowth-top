package top.treegrowth.common;

/**
 * @author wusi
 * @version 20170204
 */
public class RegexPattern {

    public static final String REGEX_USER_NAME = "^[^-!$%^&*()_+|~=`{}\\[\\]:/;<>?,.@#'\"\\\\]{1,20}$";
    public static final String REGEX_USER_PASSWORD = "^[\\s\\S]{6,20}$";
    public static final String REGEX_PHONE = "^(1[3578][0-9]{9}|(\\d{3,4}-)\\d{7,8}(-\\d{1,4})?)$";
    public static final String REGEX_MAIL = "^[^@\\s]+@(?:[^@\\s.]+)(?:\\.[^@\\s.]+)+$";
    public static final String REGEX_TEMPLATE_NAME = "^[\\w-]+$";
}
