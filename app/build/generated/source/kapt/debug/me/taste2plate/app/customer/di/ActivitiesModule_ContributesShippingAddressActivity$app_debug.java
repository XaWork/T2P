package me.taste2plate.app.customer.di;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import me.taste2plate.app.customer.ui.customer.ShippingAddressActivity;

@Module(
  subcomponents =
      ActivitiesModule_ContributesShippingAddressActivity$app_debug
          .ShippingAddressActivitySubcomponent.class
)
public abstract class ActivitiesModule_ContributesShippingAddressActivity$app_debug {
  private ActivitiesModule_ContributesShippingAddressActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(ShippingAddressActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      ShippingAddressActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface ShippingAddressActivitySubcomponent
      extends AndroidInjector<ShippingAddressActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<ShippingAddressActivity> {}
  }
}
