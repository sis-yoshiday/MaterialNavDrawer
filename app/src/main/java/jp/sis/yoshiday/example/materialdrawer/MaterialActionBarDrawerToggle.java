package jp.sis.yoshiday.example.materialdrawer;

import android.app.Activity;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import drawerarrowdrawable.DrawerArrowDrawable;

public class MaterialActionBarDrawerToggle extends ActionBarDrawerToggle {

  private DrawerArrowDrawable arrowDrawable;

  private float offset;

  private boolean flipped;

  public MaterialActionBarDrawerToggle(DrawerArrowDrawable arrowDrawable, Activity activity,
      DrawerLayout drawerLayout, int openDrawerContentDescRes, int closeDrawerContentDescRes) {
    super(activity, drawerLayout, R.drawable.ic_drawer, openDrawerContentDescRes,
        closeDrawerContentDescRes);

    this.arrowDrawable = arrowDrawable;

    ActionBar supportActionBar = ((ActionBarActivity) activity).getSupportActionBar();
    supportActionBar.setLogo(arrowDrawable);
  }

  @Override public void onDrawerSlide(View drawerView, float slideOffset) {
    super.onDrawerSlide(drawerView, slideOffset);

    offset = slideOffset;

    // Sometimes slideOffset ends up so close to but not quite 1 or 0.
    if (slideOffset >= .995) {
      flipped = true;
      arrowDrawable.setFlip(flipped);
    } else if (slideOffset <= .005) {
      flipped = false;
      arrowDrawable.setFlip(flipped);
    }

    arrowDrawable.setParameter(offset);
  }
}
