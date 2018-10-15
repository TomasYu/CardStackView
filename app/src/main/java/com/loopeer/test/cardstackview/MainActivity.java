package com.loopeer.test.cardstackview;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.loopeer.cardstack.AllMoveDownAnimatorAdapter;
import com.loopeer.cardstack.CardStackView;
import com.loopeer.cardstack.UpDownAnimatorAdapter;
import com.loopeer.cardstack.UpDownStackAnimatorAdapter;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CardStackView.ItemExpendListener {
    public static Integer[] TEST_DATAS = new Integer[]{
            R.color.color_1,
            R.color.color_2,
            R.color.color_3,
            R.color.color_4,
            R.color.color_5,
            R.color.color_6,
            R.color.color_7,
            R.color.color_8,
            R.color.color_9,
            R.color.color_10,
            R.color.color_11,
            R.color.color_12,
            R.color.color_13,
            R.color.color_14,
            R.color.color_15,
            R.color.color_16,
            R.color.color_17,
            R.color.color_18,
            R.color.color_19,
            R.color.color_20,
            R.color.color_21,
            R.color.color_22,
            R.color.color_23,
            R.color.color_24,
            R.color.color_25,
            R.color.color_26
    };

    public static List<ItemData> TEST_DATA = Arrays.asList(
            new ItemData("皮皮洋","皮皮洋好漂亮",R.color.color_2),
            new ItemData("皮皮洋","你长成了我喜欢的样子。",R.color.color_1),
            new ItemData("皮皮洋","我想多叫一遍你的名字，仿佛多叫一次，就可以多爱一点。",R.color.color_3),
            new ItemData("皮皮洋","你小名一定叫觉觉吧，不然为什么我一直想睡觉觉。",R.color.color_4),
            new ItemData("皮皮洋","我喜欢你已经超过两分钟了，已经不能撤回了。",R.color.color_5),
            new ItemData("皮皮洋","你猜我的心在哪边，左边。不，在你那边。",R.color.color_6),
            new ItemData("皮皮洋","你要照顾我自己，照顾不好我来照顾你。",R.color.color_7),
            new ItemData("皮皮洋","春眠不觉晓  谈个恋爱可好",R.color.color_8),
            new ItemData("皮皮洋","我觉得你今天怪怪的  ???   怪好看的",R.color.color_9),
            new ItemData("皮皮洋","你喜欢我吗？\n" +
                    "答案很长，我准备用一生的时间来回答，你准备要听了吗？",R.color.color_10),
            new ItemData("皮皮洋","说起你的优点，五个字，会找女朋友。",R.color.color_11),
            new ItemData("皮皮洋","你生日多少号？干嘛？我想设一直下银行卡密码。",R.color.color_12),
            new ItemData("皮皮洋","我谁都不怕，但是我怕你，你知道为什么吗？ 因为我怕老婆",R.color.color_13),
            new ItemData("皮皮洋","我可以和你拍合照吗？  干嘛？  我想向我的朋友证明，天使是存在的？",R.color.color_14),
            new ItemData("皮皮洋","A:你在我眼中比什么都重要。  B:你抢了我的台词。",R.color.color_15),
            new ItemData("皮皮洋","你可能不知道，当你生气，然后把你哄开心，你笑的时候，比雨后彩虹还好看。",R.color.color_16),
            new ItemData("皮皮洋","我喜欢的样子，你都有。（《甜甜的》周杰伦）",R.color.color_17),
            new ItemData("皮皮洋","年年月月逝去越是觉得深爱你。（《谁愿放手》陈慧琳）",R.color.color_18),
            new ItemData("皮皮洋","后海有树的院子，夏代有工的玉。此时此刻的云，二十来岁的你。（冯唐）",R.color.color_19),
            new ItemData("皮皮洋","过去有人曾对我说，“一个人爱上小溪，是因为没有见过大海。”而如今我终于可以说，“我已见过银河，但我仍只爱你一颗星。”（七堇年）",R.color.color_20),
            new ItemData("皮皮洋","春风再美也比不上你的笑，没见过你的人不会明了。（李宗盛）",R.color.color_21),
            new ItemData("皮皮洋","如果我爱上了你的笑容，要怎么收藏怎么拥有？（《知足》五月天）",R.color.color_22),
            new ItemData("皮皮洋","我的意中人是一位盖世英雄,有一天他会身披金甲圣衣、驾着七彩祥云来娶我。（《大话西游》）",R.color.color_23),
            new ItemData("皮皮洋","陌上人如玉，公子世无双。（《无双公子》）",R.color.color_24),
            new ItemData("皮皮洋","情不知所起一往而深。（《牡丹亭》汤显祖）",R.color.color_25),
            new ItemData("皮皮洋","如果我没刀，我就不能保护你。如果我有刀，我就不能拥抱你。（《剪刀手爱德华》）",R.color.color_26)

    );
    private CardStackView mStackView;
    private LinearLayout mActionButtonContainer;
    private TestStackAdapter mTestStackAdapter;
    private MyStackAdapter mStackAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStackView = (CardStackView) findViewById(R.id.stackview_main);
        mActionButtonContainer = (LinearLayout) findViewById(R.id.button_container);
        mStackView.setItemExpendListener(this);
        mTestStackAdapter = new TestStackAdapter(this);
        mStackAdapter = new MyStackAdapter(this);
        mStackView.setAdapter(mStackAdapter);


        new Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
//                        mTestStackAdapter.updateData(Arrays.asList(TEST_DATAS));
                        mStackAdapter.updateData(TEST_DATA);
                    }
                }
                , 200
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_all_down:
                mStackView.setAnimatorAdapter(new AllMoveDownAnimatorAdapter(mStackView));
                break;
            case R.id.menu_up_down:
                mStackView.setAnimatorAdapter(new UpDownAnimatorAdapter(mStackView));
                break;
            case R.id.menu_up_down_stack:
                mStackView.setAnimatorAdapter(new UpDownStackAnimatorAdapter(mStackView));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onPreClick(View view) {
        mStackView.pre();
    }

    public void onNextClick(View view) {
        mStackView.next();
    }

    @Override
    public void onItemExpend(boolean expend) {
        mActionButtonContainer.setVisibility(expend ? View.VISIBLE : View.GONE);
    }
}

