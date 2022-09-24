package me.taste2plate.app.customer.di;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import me.taste2plate.app.customer.SplashActivity;

@Module(
  subcomponents =
      ActivitiesModule_ContributesMainActivity$app_debug.SplashActivitySubcomponent.class
)
public abstract class ActivitiesModule_ContributesMainActivity$app_debug {
  private ActivitiesModule_ContributesMainActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(SplashActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      SplashActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface SplashActivitySubcomponent extends AndroidInjector<SplashActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<SplashActivity> {}
  }
}
