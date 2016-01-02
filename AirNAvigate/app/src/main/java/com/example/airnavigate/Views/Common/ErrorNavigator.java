package com.example.airnavigate.Views.Common;

import android.support.annotation.StringRes;

import com.example.airnavigate.R;

import javax.inject.Inject;

/**
 * A navigator to display errors
 */
public class ErrorNavigator {

    //final FragmentManager fm;


    @Inject
    public ErrorNavigator() {

    }

//    @Inject
//    public ErrorNavigator(@NormalFragmentManager FragmentManager fm) {
//        this.fm = fm;
//    }

    /**
     * Use provided title and provided message
     */
    private void displayError(@StringRes int title, @StringRes int message) {
       // SimpleAlertDialog.show(fm, title, message);
    }

    /**
     * Use regular "Error" title and provided message
     */
    public void displayError(@StringRes int message) {
        displayError(R.string.title_activity_main, message);
    }

    /**
     * Retrieve some information from error and display it, apropriately
     * */
    public void displayError(Throwable e) {
        int message = 0;
//        if (e instanceof RetrofitError && ((RetrofitError) e).getKind() == RetrofitError.Kind.NETWORK) {
//            //network error
//            message = R.string.error_message_internet;
//        } else if (NetworkResponseStatus.is400(e)) {
//            //operation is forbidden
//            message = R.string.error_message_error400;
//        } else if (NetworkResponseStatus.is404(e)) {
//            //not found
//            message = R.string.error_message_error404;
//        } else if (NetworkResponseStatus.is500(e)) {
//            //server error
//            message = R.string.error_message_error500;
//        } else if (NetworkResponseStatus.isTimeout(e)) {
//            //network error
//            message = R.string.error_message_error500;
//        } else {
//            //wtf
//            message = R.string.error_message_errorWTF;
//        }
        displayError(message);
    }

}
