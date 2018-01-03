package info.androidhive.firebase;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<String> values;
    RecyclerViewAdapter(ArrayList<String> values) {
        this.values = values;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(values.get(position));
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name, location, description;
        ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.titleView);
            location = (TextView) itemView.findViewById(R.id.locationView);
            description = (TextView) itemView.findViewById(R.id.descriptionView);
        }
    }
}


/*public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyHoder> {
    private ArrayList<String> values;

    RecyclerViewAdapter(ArrayList<String> values) {
        this.values = values;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(values.get(position));
        holder.location.setText(values.get(position));
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    //OK
    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView location;
        ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.titleView);
            location = (TextView) itemView.findViewById(R.id.locationView);
        }
    }*/

    /*List<Advertisement> list;
    Context context;

    public RecyclerAdapter(ArrayList<String> values) {
    }

    public void RecyclerAdapter(List<Advertisement> list, Context context) {
        this.list = list;
        this.context = context;
    }


    class MyHoder extends RecyclerView.ViewHolder{
        TextView title, description, location;

        public MyHoder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.titleView);
            description = (TextView) itemView.findViewById(R.id.descriptionView);
            location = (TextView) itemView.findViewById(R.id.locationView);

        }
    }

    public void onBindViewHolder(MyHoder holder, int position) {
        Advertisement mylist = list.get(position);
        holder.title.setText(mylist.getTitle());
        holder.description.setText(mylist.getDescription());
        holder.location.setText(mylist.getLocation());
    }

    @Override
    public MyHoder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view_item,parent,false);

        MyHoder myHoder = new MyHoder(view);


        return myHoder;
    }



    @Override
    public int getItemCount() {
        int arr = 0;
        try{
            if(list.size()==0){
                arr = 0;
            }
            else{
                arr=list.size();
            }
        }catch (Exception e){

        }

        return arr;
    }
}*/
