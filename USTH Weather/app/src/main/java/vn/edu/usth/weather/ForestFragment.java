package vn.edu.usth.weather;

import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ForestFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ForestFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ForestFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ForestFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ForestFragment newInstance(String param1, String param2) {
        ForestFragment fragment = new ForestFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_forest, container, false);
//        View v = inflater.inflate(R.layout.fragment_forest, container, false);
//        v.setBackgroundColor(0x2000FF00);
//        return v;

//        LinearLayout linearLayout = new LinearLayout(getActivity());
//
//        // Set the orientation of the LinearLayout to vertical
//        linearLayout.setOrientation(LinearLayout.VERTICAL);
//        linearLayout.setPadding(40, 20, 40, 20);
//        linearLayout.setGravity(Gravity.CENTER);
//
//        TextView textView = new TextView(getActivity());
//        textView.setText("Thursday");
//        textView.setTextSize(35);
//
//
//        ImageView imageView = new ImageView(getActivity());
//        // Set the image resource from the dir imported before
//        imageView.setImageResource(R.drawable.weather_icon_1);
//        imageView.setPadding(20, 20,20,20);
//
//        // Add the View children to the LinearLayout
//        linearLayout.addView(textView);
//        linearLayout.addView(imageView);
//
//        return linearLayout;
    }
}