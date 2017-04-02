package br.android.cericatto.infoglobo.presenter.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * PerActivity.java.
 *
 * @author Rodrigo Cericatto
 * @since Mar 29, 2017
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}