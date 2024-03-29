package org.blockchain.wallet.constant;

/**
 * @author housirvip
 */
public class Constant {

    public static final String AUTHORIZATION = "Authorization";

    public static final int SUCCESS_CODE = 0;
    public static final int ERROR_CODE = 1;

    public static final int PAGE_NUM_VALUE = 1;
    public static final int PAGE_SIZE_VALUE = 10;
    public static final String PAGE_NUM = "pageNum";
    public static final String PAGE_SIZE = "pageSize";
    public static final String ORDER_TYPE = "orderType";
    public static final String ORDER_BY = "orderBy";
    public static final String PARAM = "param";
    public static final String ENABLE = "enable";
    public static final String DISABLE = "disable";
    public static final String ROLE = "role";
    public static final String UID = "uid";

    public static final Integer ORDER_STATUS_NOT_PAY = 0;
    public static final Integer ORDER_STATUS_PAID = 1;
    public static final Integer ORDER_STATUS_SHIPPING = 2;
    public static final Integer ORDER_STATUS_SHIPPED = 3;
    public static final Integer ORDER_STATUS_SUCCESS = 4;
    public static final Integer ORDER_STATUS_CLOSED = 5;
    public static final Integer ORDER_STATUS_FAIL = 6;
    public static final Integer ORDER_STATUS_REFUNDING = 7;
    public static final Integer ORDER_STATUS_REFUNDED = 8;

    public static final Integer ETHERSCAN_MAX_QPS = 300;

    public static final String POINT_SIGN_UP = "SIGN_UP";
    public static final String POINT_PLACE_ORDER = "PLACE_ORDER";
    public static final String POINT_CANCEL_ORDER = "CANCEL_ORDER";

    public static final String SETTING_VIBRATION_ON = "true";
    public static final String SETTING_VIBRATION_OFF = "false";
    public static final String SETTING_NOTIFICATION_ON = "true";
    public static final String SETTING_NOTIFICATION_OFF = "false";

    public static final String NOTIFICATION_ON = "on";
    public static final String NOTIFICATION_OFF = "off";
    public static final String NOTIFICATION_EMAIL_TRUE = "true";
    public static final String NOTIFICATION_EMAIL_FALSE = "false";


    public static final String PENDING = "pending";
    public static final String SUCCESS = "success";
    public static final String ERROR = "error";

    public static final String LIMITED = "LIMITED";
    public static final String USER = "USER";
    public static final String GUEST = "GUEST";
    public static final String VIP = "VIP";
    public static final String ADMIN = "ADMIN";
    public static final String ROOT = "ROOT";

    public static final String VIP_30_DAY = "30天";
    public static final String VIP_90_DAY = "90天";
    public static final String VIP_1_year = "1年";

    public static final Integer USER_ENABLE = 1;
    public static final Integer USER_DISABLE = 0;

    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String ROLE_PREFIX = "ROLE_";

    public static final String SMS_ID = "X-LC-Id";
    public static final String SMS_KEY = "X-LC-Key";
    public static final String CAPTCHA_KEY = "api_key";
    public static final String DING_KEY = "access_token";

    public static final String SMS_OK = "{}";
    public static final String CAPTCHA_OK = "{\"error\":0,\"res\":\"success\"}";
    public static final String DING_OK = "{\"errmsg\":\"ok\",\"errcode\":0}";

    public static final int REPORT_SOLVE = 0;
    public static final int REPORT_UNSOLVE = 1;
}
