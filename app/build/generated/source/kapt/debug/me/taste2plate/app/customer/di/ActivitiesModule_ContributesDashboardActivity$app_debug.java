package me.taste2plate.app.customer.di;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import me.taste2plate.app.customer.ui.landing.DashboardActivity;

@Module(
  subcomponents =
      ActivitiesModule_ContributesDashboardActivity$app_debug.DashboardActivitySubcomponent.class
)
public abstract class ActivitiesModule_ContributesDashboardActivity$app_debug {
  private ActivitiesModule_ContributesDashboardActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(DashboardActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      DashboardActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface DashboardActivitySubcomponent extends AndroidInjector<DashboardActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<DashboardActivity> {}
  }
}
