package com.example.teacher.test;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.teacher.test.dto.CustomerDto;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListViewActivity extends BaseActivity {

    @BindView(R.id.lv_sample)
    public ListView mL_Sample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ButterKnife.bind(this);

        List<CustomerDto> list = createTestCustomer();

        CustomerAdapter adapter = new CustomerAdapter(this);

        mL_Sample.setAdapter(adapter);

    }

    private List<CustomerDto> createTestCustomer(){

        List<CustomerDto>list = new ArrayList<>();
        for(int i = 0; i<=20 ; i++){
            CustomerDto dto = new CustomerDto();
            dto.setId(i);
            dto.setName("hoge"+i);
            list.add(dto);
        }
        return  list;
    }

    public class CustomerAdapter extends BaseAdapter{

        private Context _context;
        private List<CustomerDto> _list;
        private LayoutInflater _layoutInflater;

        public CustomerAdapter(Context context){
            _context = context;
            _list = new ArrayList<CustomerDto>();
            _layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        public void add(List<CustomerDto> list){
            for(CustomerDto dto : list){
                _list.add(dto);
            }
        }

        @Override
        public int getCount() {
            return _list.size();
        }

        @Override
        public Object getItem(int position) {
            return _list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return _list.get(position).getId();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder holder = null;

            if(convertView == null){
                convertView=_layoutInflater.inflate(R.layout.customer_list_item,null);
                holder = new Holder();
                holder.txtName = (TextView) convertView.findViewById(R.id.txt_name);
                convertView.setTag(holder);
            }else{
                holder = (Holder) convertView.getTag();
            }

            holder.txtName.setText(_list.get(position).getName());
            return convertView;
        }
        private class Holder{
            TextView txtName;
        }
    }
}
