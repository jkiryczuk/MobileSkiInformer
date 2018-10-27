package jkiryczuk.pl.mobileskiinformer.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import jkiryczuk.pl.mobileskiinformer.MainActivity;
import jkiryczuk.pl.mobileskiinformer.MainActivityModule;
import jkiryczuk.pl.mobileskiinformer.favouritescreen.Favourites;
import jkiryczuk.pl.mobileskiinformer.favouritescreen.FavouritesModule;
import jkiryczuk.pl.mobileskiinformer.searchscreen.SearchFragment;
import jkiryczuk.pl.mobileskiinformer.searchscreen.SearchModule;

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector(modules = FavouritesModule.class)
    abstract Favourites bindFavourites();

    @ContributesAndroidInjector(modules = SearchModule.class)
    abstract SearchFragment bindSearchFragment();

}
