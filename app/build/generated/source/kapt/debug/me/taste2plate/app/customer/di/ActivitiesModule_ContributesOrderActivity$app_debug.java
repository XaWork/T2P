package me.taste2plate.app.customer.di;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import me.taste2plate.app.customer.ui.order.OrderActivity;

@Module(
  subcomponents =
      ActivitiesModule_ContributesOrderActivity$app_debug.OrderActivitySubcomponent.class
)
public abstract class ActivitiesModule_ContributesOrderActivity$app_debug {
  private ActivitiesModule_ContributesOrderActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(OrderActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      OrderActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface OrderActivitySubcomponent extends AndroidInjector<OrderActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<OrderActivity> {}
  }
}
