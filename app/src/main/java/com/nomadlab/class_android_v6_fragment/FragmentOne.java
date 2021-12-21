package com.nomadlab.class_android_v6_fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentOne extends Fragment {

    @Override
    public void onAttach(@NonNull Context context) {
        Log.d("TAG", "Fragment : onAttach ~");
        super.onAttach(context);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d("TAG", "Fragment : onCreate ~");
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /* view 를 그리는 역활은 한다. */
        // inflater --> 뷰를 그려주는 녀셕이다.
        // container -> 내가 위치할(프래그먼트)곳이 어딘지 넘겨 받는다.
        // !! xml 파일 만들어 주기
        Log.d("TAG", "Fragment : onCreateView ~");

        // 인자값 설명 : 그릴 xml 파일, 그려 놓을 장소, 호출시에 붙여줄지 바로 붙여 줄지 결정 - false
        // 리턴 타입 : View
        View view = inflater.inflate(R.layout.fragment_one, container, false);
//        return super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d("TAG", "Fragment : onViewCreated ~");
        super.onViewCreated(view, savedInstanceState);

        // 데이터 전달시
        // viewComponent 로 만들어 줬던 부분을 주석 처리
        // 오류
        if(getArguments() != null) {
            String data = getArguments().getString("param1", "");
            Log.d("TAG", "전달받은 값 : " + data);
        }


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d("TAG", "Fragment : onActivityCreated ~");
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onStart() {
        Log.d("TAG", "Fragment : onStart ~");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.d("TAG", "Fragment : onResume ~");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d("TAG", "Fragment : onPause ~");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d("TAG", "Fragment : onStop ~");
        super.onStop();

    }

    @Override
    public void onDestroyView() {
        Log.d("TAG", "Fragment : onDestroyView ~");
        super.onDestroyView();

    }

    @Override
    public void onDestroy() {
        Log.d("TAG", "Fragment : onDestroy ~");
        super.onDestroy();

    }

    @Override
    public void onDetach() {
        Log.d("TAG", "Fragment : onDetach ~");
        super.onDetach();
    }

}
