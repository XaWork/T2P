package me.taste2plate.app.customer.di;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import me.taste2plate.app.customer.ui.membership.MembershipListActivity;

@Module(
  subcomponents =
      ActivitiesModule_ContributesMembershipListActivity$app_debug
          .MembershipListActivitySubcomponent.class
)
public abstract class ActivitiesModule_ContributesMembershipListActivity$app_debug {
  private ActivitiesModule_ContributesMembershipListActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(MembershipListActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      MembershipListActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface MembershipListActivitySubcomponent
      extends AndroidInjector<MembershipListActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<MembershipListActivity> {}
  }
}
