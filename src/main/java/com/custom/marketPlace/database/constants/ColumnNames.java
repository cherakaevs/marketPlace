package com.custom.marketPlace.database.constants;

public interface ColumnNames {

    /* Common */
    String ID = "id";
    String PRICE = "price";
    String SUM = "sum_price";

    /* Address */
    String COUNTRY = "country";
    String CITY = "city";
    String STREET = "street";
    String HOUSE_NUMBER = "house_number";
    String FLAT_NUMBER = "flat_number";
    String MAIL_INDEX = "mail_index";

    /* User */
    String USERNAME = "username";
    String PASSWORD = "password";

    /* Order */
    String STATUS = "order_status";

    /* Parameter */
    String PARAMETER_VALUE = "value";

    /* Product */
    String PRODUCT_NAME = "product_name";
    String AVERAGE_RATE = "average_rate";
    String AVAILABLE_COUNT = "count";

    /* Profile */
    String FIRST_NAME = "first_name";
    String LAST_NAME = "last_name";

    /* Category */
    String CATEGORY_NAME = "name";
    String PARENT_CATEGORY_ID = "parent_category_id";

    /* Feedback */
    String MESSAGE = "message";
    String RATE = "rate";

    /* Coupon */
    String DISCOUNT_MULTIPLIER = "discount_multiplier";
    String DISCOUNT = "discount";

    /* Order */
    String SHIPMENT_DATE = "shipment_date";
    String DELIVERY_DATE = "delivery_date";

    /* Attribute */
    String ATTRIBUTE_NAME = "attribute_name";
    String POSSIBLE_VALUES = "possible_values";

    /* Manager Client*/
    String SECRET = "client_secret";
    String CLIENT_ID = "client_id";

    /* Foreign keys */
    String CATEGORY_ID = "category_id";
    String ATTRIBUTE_ID = "attribute_id";
    String PRODUCT_ID = "product_id";
    String ORDER_ID = "order_id";
    String PROFILE_ID = "profile_id";
    String ADDRESS_ID = "address_id";
    String BUCKET_ID = "bucket_id";
    String COUPON_ID = "coupon_id";
    String USER_ID = "user_id";
}