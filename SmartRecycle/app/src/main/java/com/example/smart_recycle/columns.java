package com.example.smart_recycle;

import android.provider.BaseColumns;

public class columns {

    public static final class Entry implements BaseColumns {

        public static final String TABLE_NAME = "company";
        public static final String COLUMN_COMPANY_NAME = "company_name";
        public static final String COLUMN_COMPANY_EMAIL = "email";
        public static final String COLUMN_COMPANY_PASSWORD = "password";
        public static final String COLUMN_COMPANY_STATE = "state";
        public static final String COLUMN_COMPANY_CITY = "city";
        public static final String COLUMN_COMPANY_PHONE = "Phone_no";
    }
}
