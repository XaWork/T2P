package me.taste2plate.app.customer.di;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import me.taste2plate.app.customer.ui.customer.BulkOrderActivity;

@Module(
  subcomponents =
      ActivitiesModule_ContributesBulkOrderActivity$app_debug.BulkOrderActivitySubcomponent.class
)
public abstract class ActivitiesModule_ContributesBulkOrderActivity$app_debug {
  private ActivitiesModule_ContributesBulkOrderActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(BulkOrderActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      BulkOrderActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface BulkOrderActivitySubcomponent extends AndroidInjector<BulkOrderActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<BulkOrderActivity> {}
  }
}
