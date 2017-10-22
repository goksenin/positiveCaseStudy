package com.aytengoksenin.barutcu.positivedigitalassesment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.aytengoksenin.barutcu.positivedigitalassesment.Fragment.ScoreTableFragment;
import com.aytengoksenin.barutcu.positivedigitalassesment.Fragment.TeamItemDetailFragment;
import com.aytengoksenin.barutcu.positivedigitalassesment.Fragment.TeamListFragment;
import com.aytengoksenin.barutcu.positivedigitalassesment.Model.LeagueTableDetail;

public class MainActivity extends AppCompatActivity implements
        ScoreTableFragment.OnScoreTableFragmentInteractionListener,
        TeamListFragment.OnTeamListFragmentInteractionListener,
        TeamItemDetailFragment.OnTeamItemDetailFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);      

        //opens score table fragment as first screen
        ScoreTableFragment scoreTableFragment = new ScoreTableFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameMainContent, scoreTableFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onTeamListFragmentInteraction(LeagueTableDetail model) {

        TeamItemDetailFragment teamItemDetailFragment = TeamItemDetailFragment.newInstance(model);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameMainContent, teamItemDetailFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    @Override
    public void onScoreTableFragmentInteraction() {}

    @Override
    public void onTeamItemDetailFragmentInteraction() {}
}
