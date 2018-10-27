package jkiryczuk.pl.mobileskiinformer.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import jkiryczuk.pl.mobileskiinformer.ui.mainactivity.MainActivity;
import jkiryczuk.pl.mobileskiinformer.ui.mainactivity.MainActivityModule;
import jkiryczuk.pl.mobileskiinformer.ui.favouritescreen.FavouritesFragment;
import jkiryczuk.pl.mobileskiinformer.ui.favouritescreen.FavouritesModule;
import jkiryczuk.pl.mobileskiinformer.ui.nearbyscreen.NearbyFragment;
import jkiryczuk.pl.mobileskiinformer.ui.nearbyscreen.NearbyModule;
import jkiryczuk.pl.mobileskiinformer.ui.searchscreen.SearchFragment;
import jkiryczuk.pl.mobileskiinformer.ui.searchscreen.SearchModule;

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector(modules = FavouritesModule.class)
    abstract FavouritesFragment bindFavourites();

    @ContributesAndroidInjector(modules = SearchModule.class)
    abstract SearchFragment bindSearchFragment();

    @ContributesAndroidInjector(modules = NearbyModule.class)
    abstract NearbyFragment bindNearbyFragment();
}
