package np.com.myfitness;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import np.com.myfitness.fragment.ExerciseFragment;
import np.com.myfitness.fragment.HomeFragment;
import np.com.myfitness.fragment.ProfileFragment;
import np.com.myfitness.fragment.ProgramFragment;
import np.com.myfitness.fragment.WorkoutFragment;

public class BottomNav extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bottomnav);

        bottomNavigationView =findViewById(R.id.bottom_navigation);
        frameLayout =findViewById(R.id.frameLayout);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int itemId = menuItem.getItemId();

                if(itemId==R.id.home){
                   loadFragment(new HomeFragment(),false);

                } else if (itemId == R.id.programs) {
                    loadFragment(new ProgramFragment(),false);

                } else if (itemId == R.id.workouts) {
                    loadFragment(new WorkoutFragment(),false);

                } else if (itemId == R.id.exercises) {
                    loadFragment(new ExerciseFragment(),false);

                }else {//profile
                    loadFragment(new ProfileFragment(),false);
                }
                loadFragment(new HomeFragment(),true);

                return true;
            }
        });

    }
    private void loadFragment(Fragment fragment, boolean isAppInitialized){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if(isAppInitialized){
           fragmentTransaction.add(R.id.frameLayout, fragment);
        }else {
            fragmentTransaction.replace(R.id.frameLayout,fragment);
        }
        fragmentTransaction.commit();
    }

}