package tools.com.hellolibrary.hello_com_adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by lenovo on 2016/10/15.
 * 描述：
 */

public class CommonViewHolder {
    private final SparseArray<View> mViews = new SparseArray();
    private int mPosition;
    private View mConvertView;

    private CommonViewHolder(Context context, ViewGroup parent, int layoutId, int position) {
        this.mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        this.mConvertView.setTag(this);
    }

    @NonNull
    public static CommonViewHolder getCommonViewHolder(Context context, @Nullable View convertView, ViewGroup parent, int layoutId, int position) {
        return convertView == null?new CommonViewHolder(context, parent, layoutId, position):(CommonViewHolder)convertView.getTag();
    }

    @NonNull
    public <T extends View> T getView(int viewId)
    {
        View view = mViews.get(viewId);
        if (view == null)
        {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    @NonNull
    public CommonViewHolder setText(int viewId, String text) {
        TextView view = (TextView)this.getView(viewId);
        view.setText(text);
        return this;
    }

    @NonNull
    public CommonViewHolder setImageResource(int viewId, int drawableId) {
        ImageView view = (ImageView)this.getView(viewId);
        view.setImageResource(drawableId);
        return this;
    }

    @NonNull
    public CommonViewHolder setImageBitmap(int viewId, Bitmap bm) {
        ImageView view = (ImageView)this.getView(viewId);
        view.setImageBitmap(bm);
        return this;
    }

    public int getPosition() {
        return this.mPosition;
    }
}
