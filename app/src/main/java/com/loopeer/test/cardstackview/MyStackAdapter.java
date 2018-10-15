package com.loopeer.test.cardstackview;

import android.content.Context;
import android.graphics.PorterDuff;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;

import com.loopeer.cardstack.CardStackView;
import com.loopeer.cardstack.StackAdapter;

/**
 * =======================================================================================
 * 作    者：caoxinyu
 * 创建日期：2018/10/15.
 * 类的作用:
 * 修订历史：
 * =======================================================================================
 */
public class MyStackAdapter extends StackAdapter<ItemData> {
    public MyStackAdapter(Context context) {
        super(context);
    }

    @Override
    public void bindView(ItemData data, int position, CardStackView.ViewHolder holder) {
        if (holder instanceof ItemDataViewHolder) {
            ((ItemDataViewHolder) holder).onBind(data,position);
        }
    }

    @Override
    protected CardStackView.ViewHolder onCreateView(ViewGroup parent, int viewType) {
        View view= getLayoutInflater().inflate(R.layout.list_card_item, parent, false);
        return new ItemDataViewHolder(view);
    }

    static class ItemDataViewHolder extends TestStackAdapter.ColorItemViewHolder{

        public ItemDataViewHolder(View view) {
            super(view);
        }

        public void onBind(ItemData data, int position) {
            mLayout.getBackground().setColorFilter(ContextCompat.getColor(getContext(), data.color), PorterDuff.Mode.SRC_IN);
            mTextTitle.setText(data.title);
            mContent.setText(data.message);
        }
    }

}
