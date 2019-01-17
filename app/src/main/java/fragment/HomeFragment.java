package fragment;

import android.widget.TextView;

import com.lj.bottombar.R;

import butterknife.BindView;

/**
 * Created time : 2018/12/7 15:58.
 *
 * @author HPA
 */
public class HomeFragment extends BaseFragment {


    @BindView(R.id.text_home)
    TextView mTextHome;

    @Override
    protected void initView() {

        //界面数据完善
        mTextHome.setText("首页");
    }

    @Override
    protected int getContentLayout() {
        return R.layout.fragment_home;
    }
}
