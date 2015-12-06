package com.example.airnavigate.Views.Base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.airnavigate.R;
import com.example.airnavigate.Views.Widgets.CircularProgress;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Defines a frame for many other dialogs. It has a fixed items (title, message, buttons) and dynamic content area.
 * <br> Subclasses may override it to provide dialog title and message, button titles, and inflate a custom content area
 */
public abstract class BaseDialog extends BaseDialogFragment {

    DialogContents innerHolder;


    class DialogContents {
        @Bind(R.id.content)
        FrameLayout dialogContents;

        @Bind(R.id.progressLoading)
        CircularProgress progress;

        @Bind(R.id.title)
        TextView title;

        @Bind(R.id.error)
        TextView error;

        @Bind(R.id.message)
        TextView message;

        @Bind(R.id.buttonRight)
        TextView rightBtn;

        @Bind(R.id.buttonLeft)
        TextView leftBtn;


        @OnClick(R.id.buttonRight)
        void onRightBtn() {
            onRightBtnClickImpl();
        }

        @OnClick(R.id.buttonLeft)
        void onLeftBtn() {
            onLeftBtnClickImpl();
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        LayoutInflater themedInflater = LayoutInflater.from(new ContextThemeWrapper(getContext(), R.style.Dialog));
        View root = themedInflater
                .inflate(R.layout.dialog_frame, container, false);

        //inject common stuff first
        innerHolder = new DialogContents();
        ButterKnife.bind(innerHolder, root);

        if (getLayoutId() != 0) {
            View content = themedInflater.inflate(getLayoutId(), null);
            innerHolder.dialogContents.addView(content);
            //inject dialog specific stuff then
            ButterKnife.bind(this, content);
        }

        initDialogInternals();
        return root;
    }

    protected void initDialogInternals() {
        if (getLeftBtnTitle() != null) {
            innerHolder.leftBtn.setText(getLeftBtnTitle());
        } else {
            innerHolder.leftBtn.setVisibility(View.GONE);
        }
        if (getRightBtnTitle() != null) {
            innerHolder.rightBtn.setText(getRightBtnTitle());
        } else {
            innerHolder.rightBtn.setVisibility(View.GONE);
        }
        if (getTitle() != null) {
            innerHolder.title.setText(getTitle());
        } else {
            innerHolder.title.setVisibility(View.GONE);
        }
        if (getMessage() != null) {
            innerHolder.message.setText(getMessage());
        } else {
            innerHolder.message.setVisibility(View.GONE);
        }
    }

    protected abstract void onRightBtnClickImpl();

    protected abstract void onLeftBtnClickImpl();

    @Nullable
    protected abstract String getLeftBtnTitle();


    @Nullable
    protected abstract String getRightBtnTitle();

    @Nullable
    protected abstract String getTitle();

    @Nullable
    protected String getMessage() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    public void setValidationError(@Nullable String errorText) {
        innerHolder.error.setVisibility(TextUtils.isEmpty(errorText) ? View.GONE : View.VISIBLE);
        innerHolder.error.setText(errorText);
    }

    public void setValidationError(@StringRes int resId) {
        setValidationError(getString(resId));
    }

    public void disposeValidationError() {
        setValidationError(null);
    }

    protected View getRightButton() {
        return innerHolder.rightBtn;
    }

    protected CircularProgress getProgressWidget() {
        return innerHolder.progress;
    }

}
