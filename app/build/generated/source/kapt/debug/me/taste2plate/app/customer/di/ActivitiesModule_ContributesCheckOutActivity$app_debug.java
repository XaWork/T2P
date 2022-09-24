package me.taste2plate.app.customer.di;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import me.taste2plate.app.customer.ui.checkout.CheckoutActivity;

@Module(
  subcomponents =
      ActivitiesModule_ContributesCheckOutActivity$app_debug.CheckoutActivitySubcomponent.class
)
public abstract class ActivitiesModule_ContributesCheckOutActivity$app_debug {
  private ActivitiesModule_ContributesCheckOutActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(CheckoutActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      CheckoutActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface CheckoutActivitySubcomponent extends AndroidInjector<CheckoutActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<CheckoutActivity> {}
  }
}
