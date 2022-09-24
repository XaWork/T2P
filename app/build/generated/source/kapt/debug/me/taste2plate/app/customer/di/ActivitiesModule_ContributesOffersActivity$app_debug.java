package me.taste2plate.app.customer.di;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import me.taste2plate.app.customer.ui.offers.OffersActivity;

@Module(
  subcomponents =
      ActivitiesModule_ContributesOffersActivity$app_debug.OffersActivitySubcomponent.class
)
public abstract class ActivitiesModule_ContributesOffersActivity$app_debug {
  private ActivitiesModule_ContributesOffersActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(OffersActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      OffersActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface OffersActivitySubcomponent extends AndroidInjector<OffersActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<OffersActivity> {}
  }
}
