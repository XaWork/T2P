package me.taste2plate.app.customer.di;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import me.taste2plate.app.customer.ui.onboarding.AnonymousSignInActivity;

@Module(
  subcomponents =
      ActivitiesModule_ContributesAnonymousSignInActivity$app_debug
          .AnonymousSignInActivitySubcomponent.class
)
public abstract class ActivitiesModule_ContributesAnonymousSignInActivity$app_debug {
  private ActivitiesModule_ContributesAnonymousSignInActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(AnonymousSignInActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      AnonymousSignInActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface AnonymousSignInActivitySubcomponent
      extends AndroidInjector<AnonymousSignInActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<AnonymousSignInActivity> {}
  }
}
