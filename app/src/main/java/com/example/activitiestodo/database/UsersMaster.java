package com.example.activitiestodo.database;

import android.provider.BaseColumns;

public final class UsersMaster {
    private UsersMaster(){}

    public static class Packages implements BaseColumns{
        public static final String TABLE_NAME = "packages";
        public static final String COLUMN_NAME_SET_DATE = "set_date";
        public static final String COLUMN_NAME_NUMBER_OF_PARTICIPANTS = "number_of_participants";
        public static final String COLUMN_NAME_PACKAGE_PRICE = "package_price";


    }
}
