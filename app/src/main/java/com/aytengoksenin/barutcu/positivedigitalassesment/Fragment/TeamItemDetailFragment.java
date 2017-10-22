package com.aytengoksenin.barutcu.positivedigitalassesment.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aytengoksenin.barutcu.positivedigitalassesment.Model.LeagueTableDetail;
import com.aytengoksenin.barutcu.positivedigitalassesment.R;
import com.koushikdutta.ion.Ion;

/**
 * This class holds the details for each team to be clicked.
 * Activities that contain this fragment must implement the
 * {@link TeamItemDetailFragment.OnTeamItemDetailFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TeamItemDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TeamItemDetailFragment extends Fragment {
    private static final String TEAM_DETAIL = "team_detail";

    private LeagueTableDetail mLeagueTableDetailModel;
    private TextView textViewDetailsFragmentTeamName;
    private ImageView imageViewDetailsFragmentTeamLogo;
    private TextView textViewDetailsFragmentRankTitle;
    private TextView textViewDetailsFragmentRank;
    private TextView textViewDetailsFragmentPlayedTitle;
    private TextView textViewDetailsFragmentPlayed;
    private TextView textViewDetailsFragmentPointsTitle;
    private TextView textViewDetailsFragmentPoints;
    private TextView textViewDetailsFragmentWinsTitle;
    private TextView textViewDetailsFragmentWins;
    private TextView textViewDetailsFragmentDrawsTitle;
    private TextView textViewDetailsFragmentDraws;
    private TextView textViewDetailsFragmenDefeitsTitle;
    private TextView textViewDetailsFragmentDefeits;
    private TextView textViewDetailsFragmentGoalsForTitle;
    private TextView textViewDetailsFragmentGoalsFor;
    private TextView textViewDetailsFragmentGoalsAgainstTitle;
    private TextView textViewDetailsFragmentGoalsAgainst;
    private TextView textViewDetailsFragmentAvaregeTitle;
    private TextView textViewDetailsFragmentAverage;

    private OnTeamItemDetailFragmentInteractionListener mListener;

    public TeamItemDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param teamDetail Parameter 1. Passes the info coming from TeamListFragment
     * @return A new instance of fragment TeamItemDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TeamItemDetailFragment newInstance(LeagueTableDetail teamDetail) {
        TeamItemDetailFragment fragment = new TeamItemDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable(TEAM_DETAIL, teamDetail);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mLeagueTableDetailModel = (LeagueTableDetail) getArguments().getSerializable(TEAM_DETAIL);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_team_item_detail, container, false);
        textViewDetailsFragmentTeamName = (TextView) rootView.findViewById(R.id.textViewDetailsFragmentTeamName);
        imageViewDetailsFragmentTeamLogo = (ImageView) rootView.findViewById(R.id.imageViewDetailsFragmentTeamLogo);
        textViewDetailsFragmentRankTitle = (TextView) rootView.findViewById(R.id.textViewDetailsFragmentRankTitle);
        textViewDetailsFragmentRank = (TextView) rootView.findViewById(R.id.textViewDetailsFragmentRank);
        textViewDetailsFragmentPlayedTitle = (TextView) rootView.findViewById(R.id.textViewDetailsFragmentPlayedTitle);
        textViewDetailsFragmentPlayed = (TextView) rootView.findViewById(R.id.textViewDetailsFragmentPlayed);
        textViewDetailsFragmentPointsTitle = (TextView) rootView.findViewById(R.id.textViewDetailsFragmentPointsTitle);
        textViewDetailsFragmentPoints = (TextView) rootView.findViewById(R.id.textViewDetailsFragmentPoints);
        textViewDetailsFragmentWinsTitle = (TextView) rootView.findViewById(R.id.textViewDetailsFragmentWinsTitle);
        textViewDetailsFragmentWins = (TextView) rootView.findViewById(R.id.textViewDetailsFragmentWins);
        textViewDetailsFragmentDrawsTitle = (TextView) rootView.findViewById(R.id.textViewDetailsFragmentDrawsTitle);
        textViewDetailsFragmentDraws = (TextView) rootView.findViewById(R.id.textViewDetailsFragmentDraws);
        textViewDetailsFragmenDefeitsTitle = (TextView) rootView.findViewById(R.id.textViewDetailsFragmenDefeitsTitle);
        textViewDetailsFragmentDefeits = (TextView) rootView.findViewById(R.id.textViewDetailsFragmentDefeits);
        textViewDetailsFragmentGoalsForTitle = (TextView) rootView.findViewById(R.id.textViewDetailsFragmentGoalsForTitle);
        textViewDetailsFragmentGoalsFor = (TextView) rootView.findViewById(R.id.textViewDetailsFragmentGoalsFor);
        textViewDetailsFragmentGoalsAgainstTitle = (TextView) rootView.findViewById(R.id.textViewDetailsFragmentGoalsAgainstTitle);
        textViewDetailsFragmentGoalsAgainst = (TextView) rootView.findViewById(R.id.textViewDetailsFragmentGoalsAgainst);
        textViewDetailsFragmentAvaregeTitle = (TextView) rootView.findViewById(R.id.textViewDetailsFragmentAvaregeTitle);
        textViewDetailsFragmentAverage = (TextView) rootView.findViewById(R.id.textViewDetailsFragmentAverage);


        textViewDetailsFragmentTeamName.setText(mLeagueTableDetailModel.getName());
        Ion.with(imageViewDetailsFragmentTeamLogo).load(mLeagueTableDetailModel.getTeamLogohttp());
        textViewDetailsFragmentRankTitle.setText("Rank");
        textViewDetailsFragmentRank.setText(String.valueOf(mLeagueTableDetailModel.getRank1()));
        textViewDetailsFragmentPlayedTitle.setText("Played Games");
        textViewDetailsFragmentPlayed.setText(String.valueOf(mLeagueTableDetailModel.getPlayed()));
        textViewDetailsFragmentPointsTitle.setText("Points");
        textViewDetailsFragmentPoints.setText(String.valueOf(mLeagueTableDetailModel.getPoints()));
        textViewDetailsFragmentWinsTitle.setText("Wins");
        textViewDetailsFragmentWins.setText(String.valueOf(mLeagueTableDetailModel.getWins()));
        textViewDetailsFragmentDrawsTitle.setText("Draws");
        textViewDetailsFragmentDraws.setText(String.valueOf(mLeagueTableDetailModel.getDraws()));
        textViewDetailsFragmenDefeitsTitle.setText("Defeits");
        textViewDetailsFragmentDefeits.setText(String.valueOf(mLeagueTableDetailModel.getDefeits()));
        textViewDetailsFragmentGoalsForTitle.setText("Goals For");
        textViewDetailsFragmentGoalsFor.setText(String.valueOf(mLeagueTableDetailModel.getGoalsfor()));
        textViewDetailsFragmentGoalsAgainstTitle.setText("Goals Against");
        textViewDetailsFragmentGoalsAgainst.setText(String.valueOf(mLeagueTableDetailModel.getGoalsagainst()));
        textViewDetailsFragmentAvaregeTitle.setText("Average");
        textViewDetailsFragmentAverage.setText(String.valueOf(mLeagueTableDetailModel.getAverage()));

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnTeamItemDetailFragmentInteractionListener) {
            mListener = (OnTeamItemDetailFragmentInteractionListener) context;
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
    public interface OnTeamItemDetailFragmentInteractionListener {
        // TODO: Update argument type and name
        void onTeamItemDetailFragmentInteraction();
    }
}
