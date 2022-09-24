package me.taste2plate.app.customer.di;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import me.taste2plate.app.customer.ui.membership.MyPlanActivity;

@Module(
  subcomponents =
      ActivitiesModule_ContributesMyPlanActivity$app_debug.MyPlanActivitySubcomponent.class
)
public abstract class ActivitiesModule_ContributesMyPlanActivity$app_debug {
  private ActivitiesModule_ContributesMyPlanActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(MyPlanActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      MyPlanActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface MyPlanActivitySubcomponent extends AndroidInjector<MyPlanActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<MyPlanActivity> {}
  }
}
