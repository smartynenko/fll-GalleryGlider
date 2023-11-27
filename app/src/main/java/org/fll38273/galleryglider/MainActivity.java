package org.fll38273.galleryglider;

import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import org.fll38273.galleryglider.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    private NavController mNavController;

    private ArtWorkModel[] mArtWorks = {
            new ArtWorkModel("Mona Lisa", R.drawable.thumb_mona_lisa, "mona_lisa/article.html"),
            new ArtWorkModel("Starry Night", R.drawable.thumb_starry_night, "starry_night/starry_night.html"),
            new ArtWorkModel("Lady with Pearl Earring", R.drawable.thumb_lady_w_pearl_earring, "girl_with_a_pearl_earring/article.html"),

            new ArtWorkModel("Last Supper", R.drawable.thumb_last_supper, "last_supper/article.html"),
            new ArtWorkModel("Café Terrace at Night", R.drawable.thumb_terrace, "cafe_terrace_at_night/article.html"),
            new ArtWorkModel("Night Watch", R.drawable.thumb_night_watch),

            new ArtWorkModel("Red Hat", R.drawable.thumb_red_hat, "red_hat/red_hat.html"),
            new ArtWorkModel("Lilies", R.drawable.thumb_lilies),
            new ArtWorkModel("Great Hokusai", R.drawable.thumb_wave, "great_hokusai/article.html"),

            new ArtWorkModel("Ginievra de Beci", R.drawable.thumb_ginievra_de_beci,"genievra_de_beci/article.html"),
            new ArtWorkModel("Colosseum", R.drawable.thumb_colosseum, "colosseum/colosseum.html"),
            new ArtWorkModel("Taj Mahal", R.drawable.thumb_taj_mahal, "taj_mahal/article.html"),

            new ArtWorkModel("Kremlin", R.drawable.thumb_kremlin, "kremlin/kremlin.html"),
            new ArtWorkModel("American Gothic", R.drawable.thumb_american_gothic, "american_gothic/american_gothic.html"),
            new ArtWorkModel("Composition VIII", R.drawable.thumb_composition_viii, "composition_viii/composition_viii.html"),

            new ArtWorkModel("Three Puppies", R.drawable.thumb_still_life_with_three_puppies, "still_life_w_3_puppies/article.html"),
    };

    private ArtWorkViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(ArtWorkViewModel.class);
        /*viewModel.getSelectedItem().observe(this, item -> {
            // Perform an action with the latest item data.
        });*/

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        /*binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_about)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        return false;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void navigateToArtWork() {
        Navigation.findNavController(this, R.id.nav_host_fragment_content_main).navigate(R.id.action_nav_gallery_to_nav_scrollingart);
    }

    public ArtWorkModel[] getArtWorks() {
        return mArtWorks;
    }
}