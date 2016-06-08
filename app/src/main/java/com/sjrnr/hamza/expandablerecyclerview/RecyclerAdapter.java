package com.sjrnr.hamza.expandablerecyclerview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamza Fetuga on 5/29/2016.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int CHILD = 0;
    public static final int PARENT = 1;
    static List<Person> datas = new ArrayList<>();
    static List<Integer> children = new ArrayList<>();
    static RecyclerAdapter recyclerAdapter;
    public RecyclerView recyclerView;
    static List<Entity> general;

    public RecyclerAdapter(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
        recyclerAdapter = this;
        String peopleAsString = DataStore.getPeople();
        this.datas = ToList(peopleAsString);
        general = new ArrayList<>();
        setParent();
        Log.d("number", datas.size() + "");
    }


    public void setParent(){

        for (int x = 0; x < datas.size(); x++){
            Person person = datas.get(x);
            general.add(person);
            children.add(0);
            person.setChildrenVisible(false);
            Friend[] friends = person.getFriends();
            for (int y = 0; y < friends.length; y++){
                Friend f = friends[y];
                f.setParentID(String.valueOf(x));
            }
        }
    }

    public List<Person> ToList(String dataAsJSON){
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Person>>(){}.getType();
        return gson.fromJson(dataAsJSON, listType);
    }

    public static class ParentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView viewID;
        public TextView personNameID;

        public ParentViewHolder(View itemView) {
            super(itemView);

            viewID = (TextView) itemView.findViewById(R.id.skill);
            personNameID = (TextView) itemView.findViewById(R.id.company);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            int id = getLayoutPosition();
            int aid = getAdapterPosition();

            Log.d("positions", id + " " + aid);

            Person person = (Person)general.get(id);

            if (person.getFriends().length != 0){

                //collapse list
                if (person.isChildrenVisible()){
                    person.setChildrenVisible(false);
                    Friend[] friends = person.getFriends();
                    for (int i = id + 1; i < (id + 1 + friends.length); i++){
                        general.remove(id+1);
                    }
                    Log.d("general size is ", general.size()+"");

                    recyclerAdapter.notifyItemRangeRemoved(id + 1, friends.length);
                }
                //expand list
                else {
                    person.setChildrenVisible(true);
                    Friend[] friends = person.getFriends();
                    int index = 0;

                    for (int i = id + 1; i < (id + 1 + friends.length); i++){
                        general.add(i, friends[index]);
                        index++;
                    }


                    recyclerAdapter.notifyItemRangeInserted(id + 1, friends.length);
                }

                //fix this
                int lastVisibleItemPosition = ((LinearLayoutManager)recyclerAdapter.recyclerView.
                        getLayoutManager()).findLastCompletelyVisibleItemPosition();

                if ((id + 1) < general.size()) {
                    if ((id + 1) > lastVisibleItemPosition) {
                        recyclerAdapter.recyclerView.scrollToPosition(id + 1);
                    }
                }


            }
        }
    }

    public static class ChildViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView viewID;
        public TextView parentID;
        public TextView text;

        public ChildViewHolder(View itemView) {
            super(itemView);

            viewID = (TextView) itemView.findViewById(R.id.fid);
            parentID = (TextView) itemView.findViewById(R.id.pid);
            text = (TextView) itemView.findViewById(R.id.friend);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int id = 0;
            int pid = 0;
            if (this.viewID == null) {
                TextView id_text = (TextView) view.findViewById(R.id.fid);
                TextView pid_text = (TextView) view.findViewById(R.id.pid);
                id = Integer.parseInt(id_text.getText().toString().trim());
                pid = Integer.parseInt(pid_text.getText().toString().trim());
            }
            else{
                id = Integer.parseInt(this.viewID.getText().toString());
                pid = Integer.parseInt(this.parentID.getText().toString());
            }

            Log.d("child id clicked", id+"");
            Log.d("child pid clicked", pid+"");

            Toast.makeText(view.getContext(), ""+getLayoutPosition(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int getItemViewType(int position) {

        //int parentSize = datas.size();
//        int size = datas.size();
//        int upperBound = 0;
//        int lowerBound = 0;
//        for (int x = 0; x < size; x++) {
//            Person p = datas.get(x);
//            upperBound += p.getFriends().length + 1;
//
//            if (position == lowerBound) {
//                return PARENT;
//            }
//
//            if (position < upperBound) {
//                return CHILD;
//            }
//
//            lowerBound = upperBound;
//        }
//        return 0;

        if (general.get(position).isParent()){
            Log.d("viewtype = ", "parent at " + position);
            return PARENT;
        }
        else{
            Log.d("viewtype = ", "child at " + position);
            return CHILD;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        if (viewType == CHILD){
            // Inflate the custom layout
            View itemView = inflater.inflate(R.layout.child_item, parent, false);

            // Return a new holder instance
            return new ChildViewHolder(itemView);
        }
        else{
            // Inflate the custom layout
            View itemView = inflater.inflate(R.layout.list_item, parent, false);

            // Return a new holder instance
            return new ParentViewHolder(itemView);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder.getItemViewType() == CHILD){
            TextView viewID = ((ChildViewHolder)holder).viewID;
            TextView parentID = ((ChildViewHolder)holder).parentID;
            TextView text = ((ChildViewHolder)holder).text;

            Friend friend = (Friend) general.get(position);
            viewID.setText(friend.getId());
            parentID.setText(friend.getParentID());
            text.setText(friend.getName());
        }
        else {
            TextView viewID = ((ParentViewHolder)holder).viewID;
            TextView personNameID = ((ParentViewHolder)holder).personNameID;

            Person person = (Person) general.get(position);
            viewID.setText(person.getId());
            personNameID.setText(person.getName());

        }

        //Person person = datas.get(position);

    }

    @Override
    public int getItemCount() {
        Log.d("general size = ", general.size()+"");
        return general.size();
    }


}
