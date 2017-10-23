package com.aytengoksenin.barutcu.positivedigitalassesment.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.aytengoksenin.barutcu.positivedigitalassesment.Adapter.GetLeagueDetailRestAdapter;
import com.aytengoksenin.barutcu.positivedigitalassesment.Adapter.TeamListItemRecyclerViewAdapter;
import com.aytengoksenin.barutcu.positivedigitalassesment.Model.League;
import com.aytengoksenin.barutcu.positivedigitalassesment.Model.LeagueStageDetail;
import com.aytengoksenin.barutcu.positivedigitalassesment.Model.LeagueTableDetail;
import com.aytengoksenin.barutcu.positivedigitalassesment.R;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Query;

import static android.content.ContentValues.TAG;

/**
 * This class is opened as each page of view pager.
 * if mleagueId = 1, web service is called to get Super Lig with TournamentID = 1
 * if mleagueId = 2, web service is called to get Ingiltere Premiere Lig with TournamentID = 2
 * Activities that contain this fragment must implement the
 * {@link TeamListFragment.OnTeamListFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TeamListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TeamListFragment extends Fragment {
    private static final String ARG_LEAGUE_ID = "leagueId";
    private int mleagueId;
    private ArrayList<LeagueTableDetail> teamList;
    private RecyclerView teamListRecyclerView;
    private TeamListItemRecyclerViewAdapter teamListItemRecyclerViewAdapter;
    private RunLeagueDetailData runLeagueDetailData;
    private LeagueStageDetail leagueStageDetail;
    private List<LeagueTableDetail> leagueTableDetailList;
    private SwipeRefreshLayout swiperefresh;
    private ProgressBar mProgressBar;
    final Handler refreshHandler = new Handler();
    private OnTeamListFragmentInteractionListener mListener;

    public TeamListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param leagueId Parameter 1. This parameter is passed from ScoreTableFragmentPagerAdapter
     * @return A new instance of fragment TeamListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TeamListFragment newInstance(int leagueId) {
        TeamListFragment fragment = new TeamListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_LEAGUE_ID, leagueId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mleagueId = getArguments().getInt(ARG_LEAGUE_ID);
        }
        teamList = new ArrayList<LeagueTableDetail>();
        runLeagueDetailData = new RunLeagueDetailData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_team_list, container, false);
        swiperefresh = (SwipeRefreshLayout) rootView.findViewById(R.id.swiperefresh);
        teamListRecyclerView = (RecyclerView) rootView.findViewById(R.id.teamListRecyclerView);
        mProgressBar = (ProgressBar) rootView.findViewById(R.id.mProgressBar);
        mProgressBar.setVisibility(View.VISIBLE);
        swiperefresh.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        Log.e("@@@@@@@", "onRefresh called from SwipeRefreshLayout");
                        runLeagueDetailData.runAsyncTask(1,1);
                    }
                }
        );

        refreshHandler.postDelayed( new Runnable() { // this will run for every 2 minutes.

            @Override
            public void run() {
                runLeagueDetailData.runAsyncTask(1,1);
                refreshHandler.postDelayed( this, 120 * 1000 );
            }
        }, 120 * 1000 );

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnTeamListFragmentInteractionListener) {
            mListener = (OnTeamListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if(mleagueId == 1)
        {
            runLeagueDetailData.runAsyncTask(1,1); //Opens teamlistfragment with tournamentId = 1
        }
        else
        {
            runLeagueDetailData.runAsyncTask(2,1); //Opens teamlistfragment with tournamentId = 2
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
    public interface OnTeamListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onTeamListFragmentInteraction(LeagueTableDetail model);
    }

    public interface GetLeagueDetailApi {
        @GET("/api/LiveScore/LeagueStage") //create ther rest of the url which is to be get together with the base.
        void getLeagueDetailFromApi (

                @Query("TournamentID") int tournamentId,
                @Query("includeTable") int includeTable,
                Callback<League> callback
        );

    }

    private class RunLeagueDetailData {

        private GetLeagueDetailRestAdapter mGetLeagueDetailRestAdapter;
        private League mData;

        private Callback<League> mLeagueDataCallback = new Callback<League>() {
            @Override
            public void success(League leagueStage, Response response) {

                mProgressBar.setVisibility(View.GONE);
                swiperefresh.setRefreshing(false);
                mData = leagueStage;
                leagueStageDetail = mData.getLeagueStage().get(0); // leagueStageDetail holds the detail of a specific league information. either super lig or premiere lig.
                leagueTableDetailList = leagueStageDetail.getLeagueTable(); //leagueTableDetailList holds the table of teams for
                teamListRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
                teamListRecyclerView.hasFixedSize();
                sortList(leagueTableDetailList);
                teamListItemRecyclerViewAdapter = new TeamListItemRecyclerViewAdapter(leagueTableDetailList,mListener);
                teamListRecyclerView.setAdapter(teamListItemRecyclerViewAdapter);

            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("!!!!!!!!!", "ON FAIL");
                mProgressBar.setVisibility(View.GONE);
            }
        };

        public void runAsyncTask (int tournamentId, int includeTable){

            if (mGetLeagueDetailRestAdapter == null)
                mGetLeagueDetailRestAdapter = new GetLeagueDetailRestAdapter();

            try {
                //mInProgress.set(true);
                mGetLeagueDetailRestAdapter.testLeagueApi(tournamentId,includeTable, mLeagueDataCallback); // Call Async API
            }
            catch (Exception e) {
                Log.d(TAG, "Thread sleep error" + e);
            }
        }

        public List<LeagueTableDetail> sortList(List<LeagueTableDetail> teamList){

            //apply buble sort to organize the list
            int a, b, t;
            int size = teamList.size();

            for(a=1; a < size; a++)
                for(b=size-1; b >= a; b--){
                    if(teamList.get(b-1).getPoints() > teamList.get(b).getPoints()){ //If out of order
                        t = teamList.get(b-1).getPoints();
                        LeagueTableDetail item = teamList.get(b-1);
                        int totalPoint = teamList.get(b).getPoints();
                        item = teamList.get(b);
                        totalPoint = t;
                    }
                }

                return teamList;
        }
    }
}
