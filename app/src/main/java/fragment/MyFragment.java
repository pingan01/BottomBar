package fragment;

import android.widget.TextView;

import com.lj.bottombar.R;

import butterknife.BindView;

/**
 * Created time : 2018/12/7 16:26.
 *
 * @author HPA
 */
public class MyFragment extends BaseFragment {


    @BindView(R.id.text_my)
    TextView mTextMy;

    @Override
    protected void initView() {

        mTextMy.setText("我的");
    }

    @Override
    protected int getContentLayout() {
        return R.layout.fragment_my;
    }
}
