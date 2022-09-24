package me.taste2plate.app.customer.di;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import me.taste2plate.app.customer.ui.customer.ProfileActivity;

@Module(
  subcomponents =
      ActivitiesModule_ContributesProfileActivity$app_debug.ProfileActivitySubcomponent.class
)
public abstract class ActivitiesModule_ContributesProfileActivity$app_debug {
  private ActivitiesModule_ContributesProfileActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(ProfileActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      ProfileActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface ProfileActivitySubcomponent extends AndroidInjector<ProfileActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<ProfileActivity> {}
  }
}
