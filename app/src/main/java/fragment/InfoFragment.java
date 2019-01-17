package fragment;

import android.widget.TextView;

import com.lj.bottombar.R;

import butterknife.BindView;

/**
 * Created time : 2018/12/7 16:23.
 *
 * @author HPA
 */
public class InfoFragment extends BaseFragment {


    @BindView(R.id.text_info)
    TextView mTextInfo;

    @Override
    protected void initView() {

        mTextInfo.setText("消息");
    }

    @Override
    protected int getContentLayout() {
        return R.layout.fragment_info;
    }
}
