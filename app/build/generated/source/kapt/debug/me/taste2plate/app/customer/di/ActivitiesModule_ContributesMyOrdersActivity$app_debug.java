package me.taste2plate.app.customer.di;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import me.taste2plate.app.customer.ui.order.MyOrdersActivity;

@Module(
  subcomponents =
      ActivitiesModule_ContributesMyOrdersActivity$app_debug.MyOrdersActivitySubcomponent.class
)
public abstract class ActivitiesModule_ContributesMyOrdersActivity$app_debug {
  private ActivitiesModule_ContributesMyOrdersActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(MyOrdersActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      MyOrdersActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface MyOrdersActivitySubcomponent extends AndroidInjector<MyOrdersActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<MyOrdersActivity> {}
  }
}
