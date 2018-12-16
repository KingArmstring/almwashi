package com.almawashi.base.mvp.model.remote.interceptor;

import com.almawashi.base.mvp.model.local.SharedPreferencesUtils;
import com.almawashi.base.mvp.model.remote.API;
import com.almawashi.base.utils.Preconditions;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@Singleton
public class TokenAuthenticationInterceptor implements Interceptor {
    private SharedPreferencesUtils sharedPreferencesUtils;

    @Inject
    public TokenAuthenticationInterceptor(SharedPreferencesUtils sharedPreferencesUtils) {
        this.sharedPreferencesUtils = sharedPreferencesUtils;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder builder = request.newBuilder();

        if (Preconditions.checkisNotNullOrEmpty(request.header(API.HEADER_NO_AUTH_KEY))) {
            builder.removeHeader(API.HEADER_NO_AUTH_KEY);
            return chain.proceed(builder.build());
        }

        // TODO: 9/12/2017 handel USER authentication
        /*if (sharedPreferencesUtils.isLoggedUser()) {
            String token = "";
            // check if request require authorize for ibtikar
            if (Preconditions.checkisNotNullOrEmpty(request.header(API.HEADER_IBTIKAR_AUTH_KEY))) {

                // get ibtikar USER token and add it to header
                token = sharedPreferencesUtils.getIbtikarAccessToken();
                Timber.d("authenticate: %s", token);
                builder.header(HEADER_AUTHORIZATION, token);

                // remove old header
                builder.removeHeader(API.HEADER_IBTIKAR_AUTH_KEY);
            } else if (Preconditions.checkisNotNullOrEmpty(request.header(API.HEADER_MOIA_AUTH_KEY))) {
                // get moia USER token and add it to header
                token = sharedPreferencesUtils.getMoiaAccessToken();
                Timber.d("authenticate: %s", token);
                builder.header(HEADER_AUTHORIZATION, token);

                // remove old header
                builder.removeHeader(API.HEADER_MOIA_AUTH_KEY);
            }

            return chain.proceed(builder.build());
        }*/
        return chain.proceed(request);
    }
}
