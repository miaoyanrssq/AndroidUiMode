package com.a_liya.uimode.mode;

import android.content.res.Resources;
import android.support.annotation.CallSuper;
import android.support.v4.content.ContextCompat;
import android.util.SparseArray;
import android.util.TypedValue;
import android.widget.TextView;

import com.a_liya.uimode.R;
import com.a_liya.uimode.utils.CheckUtils;

/**
 * TextView{@link android.widget.TextView} 的 UiMode {@link UiMode}实现类
 *
 * @author a_liYa
 * @date 2017/6/25 13:37.
 */
public class UiTextView<T extends TextView> extends UiView<T> {

    protected int attrIdTextColor;

    @CallSuper
    @Override
    public void assign(SparseArray<Integer> attrs) {
        super.assign(attrs);
        if (attrs != null) {
            attrs.get(R.styleable.SupportUiMode_android_textColor, NO_ATTR_ID);
        }
    }

    @CallSuper
    @Override
    public <V extends T> void apply(V v, Resources.Theme theme) {
        super.apply(v, theme);
        if (CheckUtils.residValid(attrIdTextColor)) {
            theme.resolveAttribute(attrIdTextColor, sOutValue, true);
            switch (sOutValue.type) {
                case TypedValue.TYPE_INT_COLOR_ARGB4:
                case TypedValue.TYPE_INT_COLOR_ARGB8:
                case TypedValue.TYPE_INT_COLOR_RGB4:
                case TypedValue.TYPE_INT_COLOR_RGB8:
                    v.setTextColor(sOutValue.data);
                    break;
                case TypedValue.TYPE_STRING:
                    v.setTextColor(ContextCompat.
                            getColorStateList(v.getContext(), sOutValue.resourceId));
                    break;


            }
        }
    }
}