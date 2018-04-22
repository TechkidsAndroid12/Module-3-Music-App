package techkids.vn.module3musicapp.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by qklahpita on 4/22/18.
 */

public class Utils {
    public static void openFragment(FragmentManager fragmentManager,
                                    int layoutID, Fragment fragment) {

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(layoutID, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
