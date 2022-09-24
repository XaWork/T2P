package me.taste2plate.app.customer.di;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import me.taste2plate.app.customer.ui.location.TrackLocationActivity;

@Module(
  subcomponents =
      ActivitiesModule_ContributesTrackLocationActivity$app_debug.TrackLocationActivitySubcomponent
          .class
)
public abstract class ActivitiesModule_ContributesTrackLocationActivity$app_debug {
  private ActivitiesModule_ContributesTrackLocationActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(TrackLocationActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      TrackLocationActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface TrackLocationActivitySubcomponent
      extends AndroidInjector<TrackLocationActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<TrackLocationActivity> {}
  }
}
