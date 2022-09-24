package me.taste2plate.app.customer.di;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import me.taste2plate.app.customer.ui.product.WishlistActivity;

@Module(
  subcomponents =
      ActivitiesModule_ContributesWishlistActivity$app_debug.WishlistActivitySubcomponent.class
)
public abstract class ActivitiesModule_ContributesWishlistActivity$app_debug {
  private ActivitiesModule_ContributesWishlistActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(WishlistActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      WishlistActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface WishlistActivitySubcomponent extends AndroidInjector<WishlistActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<WishlistActivity> {}
  }
}
