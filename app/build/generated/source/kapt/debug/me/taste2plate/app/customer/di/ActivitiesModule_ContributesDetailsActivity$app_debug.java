package me.taste2plate.app.customer.di;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import me.taste2plate.app.customer.ui.landing.DetailsActivity;

@Module(
  subcomponents =
      ActivitiesModule_ContributesDetailsActivity$app_debug.DetailsActivitySubcomponent.class
)
public abstract class ActivitiesModule_ContributesDetailsActivity$app_debug {
  private ActivitiesModule_ContributesDetailsActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(DetailsActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      DetailsActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface DetailsActivitySubcomponent extends AndroidInjector<DetailsActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<DetailsActivity> {}
  }
}
