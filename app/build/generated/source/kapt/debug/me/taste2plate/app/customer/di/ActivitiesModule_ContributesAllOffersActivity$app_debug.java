package me.taste2plate.app.customer.di;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import me.taste2plate.app.customer.ui.coupon.AllOffersActivity;

@Module(
  subcomponents =
      ActivitiesModule_ContributesAllOffersActivity$app_debug.AllOffersActivitySubcomponent.class
)
public abstract class ActivitiesModule_ContributesAllOffersActivity$app_debug {
  private ActivitiesModule_ContributesAllOffersActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(AllOffersActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      AllOffersActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface AllOffersActivitySubcomponent extends AndroidInjector<AllOffersActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<AllOffersActivity> {}
  }
}
