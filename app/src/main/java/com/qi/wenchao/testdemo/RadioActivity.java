package com.qi.wenchao.testdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.qi.wenchao.testdemo.model.CancelReasonEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chao
 * @Description {todo}
 * @date 2017/8/21 上午10:39
 * @todo:
 */
public class RadioActivity extends Activity {

    /**
     * 取消服务原因提交界面
     * <p>
     * 101.需要重新修改订单信息
     * <p>
     * 102.出行计划有变，不需要用车了
     * <p>
     * 103.长时间等待无司机响应
     * <p>
     * 104.无符合条件的车辆
     * <p>
     * 105.没有信用卡或网银无法支付
     * <p>
     * 106.司机无法来接我，我很不满
     * <p>
     * 107.其他原因
     * <p>
     * 108.与司机友好协商取消订单
     * <p>
     * 109.选择了其他交通方式
     * <p>
     * 110.司机告诉我要等很久（大于15分钟）
     *
     * @author qiwenchao
     */

    ListView lv;
    Button btn_submit;
    View footView;
    List<CancelReasonEntity> cancelReasonEntityList=new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cancel_reason_activity);
        createList();
        lv= (ListView) findViewById(R.id.lv);
        footView=LayoutInflater.from(this).inflate(R.layout.cancel_reason_foot,null);
        final CancelReasonAdapter cancelReasonAdapter=new CancelReasonAdapter(this,cancelReasonEntityList);
        lv.setAdapter(cancelReasonAdapter);
//        lv.addFooterView(footView);
        setListViewHeightBasedOnChildren(lv);
        btn_submit= (Button) findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("QWC",cancelReasonEntityList.get(cancelReasonAdapter.getIsSelectedIndex()).getId()+","+cancelReasonEntityList.get(cancelReasonAdapter.getIsSelectedIndex()).getReasonStr());
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cancelReasonAdapter.setIsSelectedIndex(position);
                for (CancelReasonEntity cancelReasonEntity:cancelReasonAdapter.cancelReasonEntityList){
                    cancelReasonEntity.setChecked(false);
                }
                cancelReasonAdapter.cancelReasonEntityList.get(position).setChecked(true);
                cancelReasonAdapter.notifyDataSetChanged();
                setListViewHeightBasedOnChildren(lv);

            }
        });
    }

    public void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        params.height += 5;//if without this statement,the listview will be a little short
        listView.setLayoutParams(params);
    }

    private void createList() {
        cancelReasonEntityList.add(new CancelReasonEntity(101,"需要重新修改订单信息"));
        cancelReasonEntityList.add(new CancelReasonEntity(102,"出行计划有变，不需要用车了"));
        cancelReasonEntityList.add(new CancelReasonEntity(103,"长时间等待无司机响应"));
        cancelReasonEntityList.add(new CancelReasonEntity(104,true,"无符合条件的车辆"));
        cancelReasonEntityList.add(new CancelReasonEntity(105,"没有信用卡或网银无法支付"));

        cancelReasonEntityList.add(new CancelReasonEntity(106,"司机无法来接我，我很不满","请谨慎选择，您的选择可对司机信誉造成一定影响"));
        cancelReasonEntityList.add(new CancelReasonEntity(107,"其他原因"));
        cancelReasonEntityList.add(new CancelReasonEntity(108,"与司机友好协商取消订单"));
        cancelReasonEntityList.add(new CancelReasonEntity(109,"选择了其他交通方式"));
        cancelReasonEntityList.add(new CancelReasonEntity(110,"司机告诉我要等很久"));
    }

    public class CancelReasonAdapter extends BaseAdapter{

        private Activity mActivity;
        private List<CancelReasonEntity> cancelReasonEntityList;
        private boolean isSelected;
        private int isSelectedIndex;

        public CancelReasonAdapter(Activity mActivity, List<CancelReasonEntity> cancelReasonEntity) {
            this.mActivity = mActivity;
            this.cancelReasonEntityList = cancelReasonEntity;
        }

        public boolean isSelected() {
            return isSelected;
        }

        public void setSelected(boolean selected) {
            isSelected = selected;
        }

        public int getIsSelectedIndex() {
            return isSelectedIndex;
        }

        public void setIsSelectedIndex(int isSelectedIndex) {
            this.isSelectedIndex = isSelectedIndex;
        }

        @Override
        public int getCount() {
            return cancelReasonEntityList.size();
        }

        @Override
        public Object getItem(int position) {
            return cancelReasonEntityList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            CancelReasonEntity cancelReasonEntity = cancelReasonEntityList.get(position);
            if (convertView == null) {

                holder=new ViewHolder();

                convertView = LayoutInflater.from(RadioActivity.this).inflate(R.layout.cancel_reason_adapter_item, null);
                holder.cb = (CheckBox) convertView.findViewById(R.id.cb);
                holder.tv_title = (TextView)convertView.findViewById(R.id.tv_title);
                holder.tv_sub_title = (TextView)convertView.findViewById(R.id.tv_sub_title);
//                holder.cb.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        isSelectedIndex=position;
//                        for (CancelReasonEntity cancelReasonEntity:cancelReasonEntityList){
//                            cancelReasonEntity.setChecked(false);
//                        }
//                        cancelReasonEntityList.get(position).setChecked(true);
//                        notifyDataSetChanged();
//                    }
//
//
//                });
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder)convertView.getTag();
            }

            if(cancelReasonEntity!=null){
                holder.cb.setChecked(cancelReasonEntity.isChecked());
                holder.tv_title.setText(cancelReasonEntity.getReasonStr());
                if(cancelReasonEntity.isChecked()){
                    isSelectedIndex=position;
                    if(!TextUtils.isEmpty(cancelReasonEntity.getSubReasonStr())) {
                        holder.tv_sub_title.setText(cancelReasonEntity.getSubReasonStr());
                        holder.tv_sub_title.setVisibility(View.VISIBLE);
                    }else{
                        holder.tv_sub_title.setVisibility(View.GONE);
                    }

                }else{
                    holder.tv_sub_title.setVisibility(View.GONE);
                }

            }
            return convertView;
        }
    }

    private static class ViewHolder{
        CheckBox cb;
        TextView tv_title;
        TextView tv_sub_title;
    }
}
