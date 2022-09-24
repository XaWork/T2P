package me.taste2plate.app.customer.di;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import me.taste2plate.app.customer.ui.customer.DirectFromHomeActivity;

@Module(
  subcomponents =
      ActivitiesModule_ContributesDirectFromHomeActivity$app_debug
          .DirectFromHomeActivitySubcomponent.class
)
public abstract class ActivitiesModule_ContributesDirectFromHomeActivity$app_debug {
  private ActivitiesModule_ContributesDirectFromHomeActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(DirectFromHomeActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      DirectFromHomeActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface DirectFromHomeActivitySubcomponent
      extends AndroidInjector<DirectFromHomeActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<DirectFromHomeActivity> {}
  }
}
