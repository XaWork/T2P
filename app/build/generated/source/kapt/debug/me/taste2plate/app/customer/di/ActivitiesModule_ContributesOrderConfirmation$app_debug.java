package me.taste2plate.app.customer.di;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import me.taste2plate.app.customer.ui.order.OrderConfirmationActivity;

@Module(
  subcomponents =
      ActivitiesModule_ContributesOrderConfirmation$app_debug.OrderConfirmationActivitySubcomponent
          .class
)
public abstract class ActivitiesModule_ContributesOrderConfirmation$app_debug {
  private ActivitiesModule_ContributesOrderConfirmation$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(OrderConfirmationActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      OrderConfirmationActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface OrderConfirmationActivitySubcomponent
      extends AndroidInjector<OrderConfirmationActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<OrderConfirmationActivity> {}
  }
}
