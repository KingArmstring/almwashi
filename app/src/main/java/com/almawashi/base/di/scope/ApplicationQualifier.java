package com.almawashi.base.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;



@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ApplicationQualifier {
}
