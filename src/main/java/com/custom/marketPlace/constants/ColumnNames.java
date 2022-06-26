package com.custom.marketPlace.constants;

public interface ColumnNames {

    /* Common */
    String ID = "id";

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

    /* Profile */
    String FIRST_NAME = "first_name";
    String LAST_NAME = "last_name";

    /* Category */
    String CATEGORY_NAME = "name";

    /* Feedback */
    String MESSAGE = "message";

    /* Coupon */
    String DISCOUNT_MULTIPLIER = "discount_multiplier";
    String DISCOUNT = "discount";

    /* Foreign keys */
    String USER_ID = "user_id";
    String CATEGORY_ID = "category_id";
    String ATTRIBUTE_ID = "attribute_id";
}
