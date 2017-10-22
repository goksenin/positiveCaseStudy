package com.aytengoksenin.barutcu.positivedigitalassesment.Adapter;

import com.aytengoksenin.barutcu.positivedigitalassesment.Fragment.TeamListFragment;
import com.aytengoksenin.barutcu.positivedigitalassesment.Model.League;

import retrofit.Callback;
import retrofit.RestAdapter;

/**
 * Created by goksenin.barutcu on 22/10/2017.
 * This class aims to create a specific adapter for RESTful servers.
 */

public class GetLeagueDetailRestAdapter {

    protected final String TAG = getClass().getSimpleName();
    protected RestAdapter mRestAdapter;
    protected TeamListFragment.GetLeagueDetailApi mApi;
    static final String LEAGUE_DETAIL_URL = "http://www.posta.com.tr"; //base part of url, it will be the same for all requests as a beginning.

    public GetLeagueDetailRestAdapter(){

        mRestAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(LEAGUE_DETAIL_URL)
                .build();
        mApi = mRestAdapter.create(TeamListFragment.GetLeagueDetailApi.class);
    }

    public void testLeagueApi(int tournamentId, int includeTable, Callback<League> cb){

        mApi.getLeagueDetailFromApi(tournamentId, includeTable, cb);
    }
}
