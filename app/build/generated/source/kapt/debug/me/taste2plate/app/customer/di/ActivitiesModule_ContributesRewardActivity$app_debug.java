package me.taste2plate.app.customer.di;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import me.taste2plate.app.customer.ui.rewards.RewardActivity;

@Module(
  subcomponents =
      ActivitiesModule_ContributesRewardActivity$app_debug.RewardActivitySubcomponent.class
)
public abstract class ActivitiesModule_ContributesRewardActivity$app_debug {
  private ActivitiesModule_ContributesRewardActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(RewardActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      RewardActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface RewardActivitySubcomponent extends AndroidInjector<RewardActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<RewardActivity> {}
  }
}
