package com.nomadlab.class_android_v6_fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnCreateFragment;
    Button btnRemoveFragment;
    FragmentOne fragmentOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("TAG", "Activity : onCreate ~");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // detach , remove 와 차이점 보여 주기
//        fragmentOne = new FragmentOne();

        // 1. 코드로 프래그먼트 생성해 보기
        btnCreateFragment = findViewById(R.id.btnCreateFragment);
        btnCreateFragment.setOnClickListener(view -> {
//            FragmentOne fragmentOne = new FragmentOne();

            fragmentOne = new FragmentOne();
            // 데이터를 전달하는 방법
            // 생성자를 통해서 전달,
            // public 메서드를 통해서 전달,
            // 콜백메서드를 만들어서 전달,
            // 번들을 통해서 전달 하는 방법
            Bundle bundle = new Bundle();
            bundle.putString("param1", "안녕하세요");
            fragmentOne.setArguments(bundle);

            // 프래그먼트를 동적으로 만들기 위해서 필요함
            // 1. FragmentManager ( 프래그먼트 트랙젝션 객체를 가져올 수 있다)
            // 2. FragmentTransaction Transaction -> 작업의 단위 (시작과 끝이 있다, 한 작업에 단위로 만들어준다)
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction(); // 시작입니다.
            // replace / add
            fragmentTransaction.replace(R.id.fragmentContainer, fragmentOne);
            // 실행 처리 확인 --> 변화 없음
            fragmentTransaction.commit();
            // 끝을 내는 방법 ->
            // commit() : 시간될 때 완료해 (시스템한테 요청) (정석)
            // commitNow() : 지금 당장
            // commitAllowingStateLoss() <-- 위험(커밋이 없어질 수 있다)
        });

        // 2. 코드로 프래그먼트 제거 하기
        btnRemoveFragment = findViewById(R.id.btnRemoveFragment);
        btnRemoveFragment.setOnClickListener(view -> {
            // remove, detach
            // remove 는 조각 인스턴스를 다시 연결할 수 없음을 의미합니다. 프래그먼트 트랜잭션에 다시 추가해야 합니다.
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            // 생성한 녀셕을 제거해주어야 한다.
            //fragmentTransaction.remove(fragmentOne);
            fragmentTransaction.detach(fragmentOne);

            fragmentTransaction.commit();
        });
    }

    @Override
    protected void onStart() {
        Log.d("TAG", "Activity :onStart ~");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d("TAG", "Activity :onResume ~");
        super.onResume();

    }

    @Override
    protected void onPause() {
        Log.d("TAG", "Activity :onPause ~");
        super.onPause();

    }

    @Override
    protected void onStop() {
        Log.d("TAG", "Activity :onStop ~");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("TAG", "Activity :onDestroy ~");
        super.onDestroy();
    }
}