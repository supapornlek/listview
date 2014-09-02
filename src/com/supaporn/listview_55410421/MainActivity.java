package com.supaporn.listview_55410421;

import java.util.ArrayList;
import java.util.jar.Attributes.Name;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	private ListView listView;
	private ArrayList<items_list> lists;
	private int drawable[] = { R.drawable.facebook, R.drawable.google_plush,
			R.drawable.twitter, R.drawable.youtube };
	private String string[] = {  "facebook","Google_plsh", "Twitter", "Youtube" };
	private ListAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		supaporn();
		LoopData();

	}

	private void LoopData() {
		// TODO Auto-generated method stub
		for (int i = 0; i < drawable.length; i++) {
			items_list items_list = new items_list();
			items_list.setDrawable(getResources().getDrawable(drawable[i]));
			items_list.setLek(string[i]);
			lists.add(items_list);
		}

	}

	private void supaporn() {
		// TODO Auto-generated method stub
		listView = (ListView) findViewById(R.id.listView1);
		lists = new ArrayList<items_list>();
		adapter=new MyAdater();
		listView.setAdapter(adapter);
	}

	private class MyAdater extends BaseAdapter {
		private oneview name;

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return lists.size();
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View view, ViewGroup parent) {
			view = LayoutInflater.from(getApplicationContext()).inflate(
					R.layout.listview_item, null);
			name = new oneview();
			name.textView = (TextView) view.findViewById(R.id.item_txttitle);
			name.imageView = (ImageView) view.findViewById(R.id.item_images);

			if (lists.get(position).getLek() != null) {
				name.textView.setText(lists.get(position).getLek());
			}
			if (lists.get(position).getDrawable() != null) {
				name.imageView.setImageDrawable(lists.get(position)
						.getDrawable());
			}

			return view;
		}

		public class oneview {
			public TextView textView;
			public ImageView imageView;

		};

	}
}
