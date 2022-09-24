package me.taste2plate.app.customer.di;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import me.taste2plate.app.customer.ui.home.HomeActivity;

@Module(
  subcomponents = ActivitiesModule_ContributesHomeActivity$app_debug.HomeActivitySubcomponent.class
)
public abstract class ActivitiesModule_ContributesHomeActivity$app_debug {
  private ActivitiesModule_ContributesHomeActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(HomeActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      HomeActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface HomeActivitySubcomponent extends AndroidInjector<HomeActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<HomeActivity> {}
  }
}
