//package com.example.th.whackamolever10;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//
//import java.util.List;
//
//public class ScoreBoardAdapter extends BaseAdapter {
//
//    private Context context;
//    private int layout;
//    private List<ScoreBoard> scoreBoardList;
//
//    public ScoreBoardAdapter(Context context, int layout, List<ScoreBoard> scoreBoardList) {
//        this.context = context;
//        this.layout = layout;
//        this.scoreBoardList = scoreBoardList;
//    }
//
//    @Override
//    public int getCount() {
//        return scoreBoardList.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return null;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }
//
//    private class ViewHolder{
//        ScoreBoard scoreBoard;
//    }
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        ViewHolder holder;
//
//        if (convertView == null){
//            holder = new ViewHolder();
//            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
//            convertView = inflater.inflate(layout,null);
//            holder.scoreBoard=convertView.findViewById(R.id.grid_image);
//            convertView.setTag(holder);
//        }else {
//            holder= (ViewHolder) convertView.getTag();
//        }
//        Image image = imgList.get(position);
//        holder.imgHinh.setImageResource(image.getHinh());
//        return convertView;
//
//    }
//}
