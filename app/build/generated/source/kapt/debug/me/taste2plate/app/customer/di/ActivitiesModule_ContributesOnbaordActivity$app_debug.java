package me.taste2plate.app.customer.di;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import me.taste2plate.app.customer.ui.onboarding.OnBoardActivity;

@Module(
  subcomponents =
      ActivitiesModule_ContributesOnbaordActivity$app_debug.OnBoardActivitySubcomponent.class
)
public abstract class ActivitiesModule_ContributesOnbaordActivity$app_debug {
  private ActivitiesModule_ContributesOnbaordActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(OnBoardActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      OnBoardActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface OnBoardActivitySubcomponent extends AndroidInjector<OnBoardActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<OnBoardActivity> {}
  }
}
