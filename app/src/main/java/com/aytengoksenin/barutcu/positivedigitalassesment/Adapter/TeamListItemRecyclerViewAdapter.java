package com.aytengoksenin.barutcu.positivedigitalassesment.Adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aytengoksenin.barutcu.positivedigitalassesment.Fragment.TeamListFragment;
import com.aytengoksenin.barutcu.positivedigitalassesment.Model.LeagueTableDetail;
import com.aytengoksenin.barutcu.positivedigitalassesment.R;
import com.koushikdutta.ion.Ion;

import java.util.List;

/**
 * Created by goksenin.barutcu on 21/10/2017.
 * This class is implemented to populate team item by using the list data coming from the result of web server request.
 */

public class TeamListItemRecyclerViewAdapter extends RecyclerView.Adapter<TeamListItemRecyclerViewAdapter.ViewHolder> {

    //TODO: ATConfig -> Change "Object" to value model
    private final List<LeagueTableDetail> mValues; //corresponds the result data from web service request

    //TODO: ATConfig -> Change "Object" to fragment interface that uses this recycler view adapter
    private final TeamListFragment.OnTeamListFragmentInteractionListener mListener;

    //TODO: ATConfig -> Change first "Object" to value model, second "Object" to fragment interface
    public TeamListItemRecyclerViewAdapter(List<LeagueTableDetail> items, TeamListFragment.OnTeamListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_team, parent, false);
        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        // View declarations in single team item.
        public final TextView mTextviewTeamNumber;
        public final ImageView mImageViewTeamLogo;
        public final TextView mTextViewTeamName;
        public final TextView mTextViewPlayedGameNumber;
        public final TextView mTextViewTotalPoint;


        public LeagueTableDetail mItem; //will hold single item in list as type of LeagueTableDetail

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mTextviewTeamNumber = (TextView) view.findViewById(R.id.textviewTeamNumber);
            mImageViewTeamLogo = (ImageView) view.findViewById(R.id.imageViewTeamLogo);
            mTextViewTeamName = (TextView) view.findViewById(R.id.textViewTeamName);
            mTextViewPlayedGameNumber = (TextView) view.findViewById(R.id.textViewPlayedGameNumber);
            mTextViewTotalPoint = (TextView) view.findViewById(R.id.textViewTotalPoint);
        }

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final LeagueTableDetail mItem = mValues.get(position);
        holder.mTextviewTeamNumber.setText(String.valueOf(position + 1));
        if(mItem.getTeamLogohttp() == "")
        {
            Ion.with(holder.mImageViewTeamLogo).load("https://www.socabelec.co.ke/wp-content/uploads/no-photo-3.jpg");
        }
        else
        {
            Ion.with(holder.mImageViewTeamLogo).load(mItem.getTeamLogohttp());
        }

        //setting the results to views
        holder.mTextViewTeamName.setText(mItem.getName());
        holder.mTextViewPlayedGameNumber.setText(String.valueOf(mItem.getPlayed()));
        holder.mTextViewTotalPoint.setText(String.valueOf(mItem.getPoints()));

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onTeamListFragmentInteraction(mValues.get(position));
                }
            }
        });


    }

}
