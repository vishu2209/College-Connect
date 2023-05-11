package com.example.hi_techcollege.ui.about;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.hi_techcollege.R;

import java.util.ArrayList;
import java.util.List;


public class AboutFragment extends Fragment {

    private ViewPager viewPager;
    private BranchAdapter adapter;
    private List<BranchModel>list;
    private ImageView map;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_about, container, false);
        list = new ArrayList<>();
        list.add(new BranchModel(R.drawable.ic_comp,"Computer Science-IT","The department of Computer Science provides world-class research and education in modern computer science. The department has a cohesive team of well experienced faculty members having wide experience in recent technologies like Cloud computing, Grid Computing, High Performance Computing, Multimedia etc. It has different computer labs like Data Structure lab, Operating System lab, Multimedia lab, Web Technology lab, Research & Development lab"));
        list.add(new BranchModel(R.drawable.ic_comp,"Electronics and Communication","The department of ECE provides world-class education in modern electronics and commnunication. The department has a cohesive team of well experienced faculty members having wide experience in recent technologies like Robotics, Grid Computing, Artificial Intelligence, Multimedia etc. It has different electronics labs and has Research & Development lab"));
        list.add(new BranchModel(R.drawable.ic_elec,"Electrical Engineering","The Electrical Engineering (EE) is one of the core branches of Hi-tech Institute of Engineering & Technology, which has an excellent infrastructure to promote congenial academic environment to impart quality education. The department of Electrical Engineering has well equipped laboratories and a team of well qualified and dedicated faculty members and technical staff."));
        list.add(new BranchModel(R.drawable.ic_mech,"Mechanical Engineering","The Department of Mechanical Engineering, established in the year 2004, with a vision to carve a distinct niche for itself in the field of mechanical engineering education in India, offers a 4- year B.Tech. program in Mechanical Engineering. The department has, over the years, built and maintained a high level of intellectual capital. It has to its credit a strong team of 33 highly qualified and richly experienced faculty members, 10 out of whom are PhDs and others are pursuing it from institutions of high repute"));

        adapter = new BranchAdapter(getContext(), list);

        viewPager = view.findViewById(R.id.viewPager);

        viewPager.setAdapter(adapter);

        map = view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMap();
            }
        });

        ImageView imageView = view.findViewById(R.id.college_image);

        Glide.with(getContext())
                .load("https://firebasestorage.googleapis.com/v0/b/college-admin-61125.appspot.com/o/image%20drawer%2F28dd4fa7ca265b22c3de78f53e264c0f.jpg?alt=media&token=66b475a7-9d92-4934-b18f-97421dcf9595")
                .into(imageView);

        return view;

    }
    private void openMap() {
        Uri uri = Uri.parse("geo:0, 0?q=Hi-tech College Ghaziabad");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }
}