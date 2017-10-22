package com.aytengoksenin.barutcu.positivedigitalassesment.Model;

import java.util.List;

/**This model corresponds the whole result data coming from web server request
 * Created by goksenin.barutcu on 22/10/2017.
 */

public class League {

    private List<LeagueStageDetail> LeagueStage;

    public League(List<LeagueStageDetail> leagueStage)
    {
        LeagueStage = leagueStage;
    }

    public List<LeagueStageDetail> getLeagueStage(){return LeagueStage;}
    private void setLeagueStage(List<LeagueStageDetail> leagueStageDetailList){LeagueStage = leagueStageDetailList; }
}
