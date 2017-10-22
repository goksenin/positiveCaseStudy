package com.aytengoksenin.barutcu.positivedigitalassesment.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.design.widget.TabLayout;


import com.aytengoksenin.barutcu.positivedigitalassesment.R;
import com.aytengoksenin.barutcu.positivedigitalassesment.Adapter.ScoreTableFragmentPagerAdapter;

/**
 * This class holds view pager only, for each page, TeamListFragment will be inflated.
 * {@link ScoreTableFragment.OnScoreTableFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ScoreTableFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScoreTableFragment extends Fragment {
    private OnScoreTableFragmentInteractionListener mListener;

    public ScoreTableFragment() {
        // Required empty public constructor
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment.
     *
     * @return A new instance of fragment ScoreTableFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ScoreTableFragment newInstance() {
        ScoreTableFragment fragment = new ScoreTableFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_score_table, container, false);

        ViewPager scoreTableViewpager = (ViewPager) rootView.findViewById(R.id.scoreTableViewpager);
        ScoreTableFragmentPagerAdapter loginPagerAdapter = new ScoreTableFragmentPagerAdapter(getChildFragmentManager());
        scoreTableViewpager.setAdapter(loginPagerAdapter);

        //creates tab layout and sets it to score table view pager
        TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.slidingTabs);
        tabLayout.setupWithViewPager(scoreTableViewpager);
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnScoreTableFragmentInteractionListener) {
            mListener = (OnScoreTableFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnScoreTableFragmentInteractionListener {
        // TODO: Update argument type and name
        void onScoreTableFragmentInteraction();
    }
}
