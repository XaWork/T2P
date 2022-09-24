package me.taste2plate.app.customer.di;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import me.taste2plate.app.customer.ui.customer.BillingAddressActivity;

@Module(
  subcomponents =
      ActivitiesModule_ContributesBillingAddressActivity$app_debug
          .BillingAddressActivitySubcomponent.class
)
public abstract class ActivitiesModule_ContributesBillingAddressActivity$app_debug {
  private ActivitiesModule_ContributesBillingAddressActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(BillingAddressActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      BillingAddressActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface BillingAddressActivitySubcomponent
      extends AndroidInjector<BillingAddressActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<BillingAddressActivity> {}
  }
}
