package pro.pro.probuilt.pro.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pro.pro.probuilt.pro.R;

/**
 * Created by rhfoq on 2016-12-25.
 */
public class ProductFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("PRODUCT");
        View rootView = inflater.inflate(R.layout.fragment_product, container, false);
        return rootView;
    }
}
