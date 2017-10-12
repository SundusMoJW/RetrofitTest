package com.twins.osama.retrofittest.Utility;

import com.twins.osama.retrofittest.Remote.RetrofitClient;
import com.twins.osama.retrofittest.Remote.SOService;

/**
 * Created by Osama on 10/5/2017.
 */

public class ApiUtils {
    public static final String BASE_URL = "http://www.wsfah.com/app/worcipe/";

    public static SOService getSOService() {
        return RetrofitClient.getClient(BASE_URL).create(SOService.class);
    }
}
