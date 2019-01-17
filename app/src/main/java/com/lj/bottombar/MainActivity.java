package com.lj.bottombar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.chaychan.library.BottomBarItem;
import com.chaychan.library.BottomBarLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import fragment.HomeFragment;
import fragment.InfoFragment;
import fragment.MyFragment;

public class MainActivity extends AppCompatActivity{


    @BindView(R.id.bbl)
    BottomBarLayout mBottomBarLayout;
    @BindView(R.id.fl_content)
    FrameLayout mFlContent;

    private Fragment mCurrentFragment;
    private HomeFragment mHomeFragment;
    private InfoFragment mInfoFragment;
    private MyFragment mMyFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        retrieveFragment();

        switchFragment(mHomeFragment);

        initListener();
    }


    //看一下系统中是否已存在这些Fragment,没有就创建
    private void retrieveFragment() {
        FragmentManager manager = getSupportFragmentManager();
        mHomeFragment = (HomeFragment) manager.findFragmentByTag(HomeFragment.class.getName());
        mInfoFragment = (InfoFragment) manager.findFragmentByTag(InfoFragment.class.getName());
        mMyFragment = (MyFragment) manager.findFragmentByTag(MyFragment.class.getName());

        if (null == mHomeFragment) mHomeFragment = new HomeFragment();
        if (null == mInfoFragment) mInfoFragment = new InfoFragment();
        if (null == mMyFragment) mMyFragment = new MyFragment();
    }

    private void initListener() {

        mBottomBarLayout.setOnItemSelectedListener(new BottomBarLayout.OnItemSelectedListener() {
            @Override
            public void onItemSelected(BottomBarItem bottomBarItem, int i, int position) {
               if (position==0){
                   switchFragment(mHomeFragment);
               }else if (position==1){
                   switchFragment(mInfoFragment);
               }else if (position==2){
                   switchFragment(mMyFragment);
               }else {
                   throw new UnsupportedOperationException("unsupport");
               }
            }
        });

        mBottomBarLayout.setUnread(0, 20);//设置第一个页签的未读数为20
        mBottomBarLayout.setUnread(1, 1001);//设置第二个页签的未读数
        mBottomBarLayout.showNotify(2);//设置第三个页签显示提示的小红点
    }

    /**
     * 切换Fragment
     *
     * @param target 目标Fragment
     */
    private void switchFragment(Fragment target) {

        if (mCurrentFragment == target) return;

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (mCurrentFragment != null) {
            transaction.hide(mCurrentFragment);
        }
        if (target.isAdded()) {
            //需要添加到FargmentManager里，才能显示
            transaction.show(target);
        } else {
            //为了便于找到Fragment，设置一个tag
            String tag = target.getClass().getName();

            //通知Fragment设置tag
            transaction.add(R.id.fl_content, target, tag);
        }
        transaction.commit();

        mCurrentFragment = target;
    }
}
