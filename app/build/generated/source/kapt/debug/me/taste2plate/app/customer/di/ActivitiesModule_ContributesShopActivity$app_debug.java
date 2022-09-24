package me.taste2plate.app.customer.di;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import me.taste2plate.app.customer.ui.product.ShopActivity;

@Module(
  subcomponents = ActivitiesModule_ContributesShopActivity$app_debug.ShopActivitySubcomponent.class
)
public abstract class ActivitiesModule_ContributesShopActivity$app_debug {
  private ActivitiesModule_ContributesShopActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(ShopActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      ShopActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface ShopActivitySubcomponent extends AndroidInjector<ShopActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<ShopActivity> {}
  }
}
