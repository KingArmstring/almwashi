package com.almawashi.base.mvp.model.remote;



public final class API {
    public static final String HEADER_X_API_KEY = "X-Api-Key";
    public static final String HEADER_X_API_LANGUAGE_KEY = "X-Api-Language";
    public static final String HEADER_NO_AUTH_KEY = "@NoAuth";
    public static final String HEADER_NO_AUTH = HEADER_NO_AUTH_KEY + ": NoAuth";
    public static final String FORWARD_SLASH = "/";
    public static final String PARAM_ID = "id";
    public static final String PARAM_PATH_ID = "{id}";
    private static final String SUFFIX = "api/";
    private static final String V1 = "v1/";


    API() {
        throw new IllegalStateException("Api class");
    }

    public static final class Inventory {
        static final String INVENTORY_API = "inventoryapi/";
        static final String LKP_Category = "LKP_Category/";
        public static final String GET_ALL_CATEGORIES = INVENTORY_API + V1 + LKP_Category + "GetAllActive";
        static final String LKP_Item = "LKP_Item/";
        /*{{BaseURL}}inventoryapi/v1/LKP_Item/GetActiveByCategoryId/1*/
        public static final String GET_ITEMS_BY_CATEGORY_ID = INVENTORY_API + V1 + LKP_Item + "GetActiveByCategoryId/" + PARAM_PATH_ID;

        public static final String GET_PURCHASES_DATA = INVENTORY_API +V1 + LKP_Item + "GetItemDetailsById/" + PARAM_PATH_ID;

        Inventory() {
            throw new IllegalStateException("Api class");
        }
    }

    public class Authentication {
        //IDENTITY_API/v1/USER/login

        static final String IDENTITY_API = "identityapi/";
        static final String USER = "user/";

        public static final String LOGIN = IDENTITY_API + V1 + USER + "login";
    }


}
