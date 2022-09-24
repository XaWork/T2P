package me.taste2plate.app.customer.di;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import me.taste2plate.app.customer.ui.coupon.DealsNComboListActivity;

@Module(
  subcomponents =
      ActivitiesModule_ContributesDealsNComboListActivity$app_debug
          .DealsNComboListActivitySubcomponent.class
)
public abstract class ActivitiesModule_ContributesDealsNComboListActivity$app_debug {
  private ActivitiesModule_ContributesDealsNComboListActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(DealsNComboListActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      DealsNComboListActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface DealsNComboListActivitySubcomponent
      extends AndroidInjector<DealsNComboListActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<DealsNComboListActivity> {}
  }
}
