package me.taste2plate.app.customer.di;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import me.taste2plate.app.customer.ui.product.CityBrandActivity;

@Module(
  subcomponents =
      ActivitiesModule_ContributesCityBrandActivity$app_debug.CityBrandActivitySubcomponent.class
)
public abstract class ActivitiesModule_ContributesCityBrandActivity$app_debug {
  private ActivitiesModule_ContributesCityBrandActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(CityBrandActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      CityBrandActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface CityBrandActivitySubcomponent extends AndroidInjector<CityBrandActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<CityBrandActivity> {}
  }
}
