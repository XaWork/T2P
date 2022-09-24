package me.taste2plate.app.customer.di;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import me.taste2plate.app.customer.ui.product.CartActivity;

@Module(
  subcomponents = ActivitiesModule_ContributesCartActivity$app_debug.CartActivitySubcomponent.class
)
public abstract class ActivitiesModule_ContributesCartActivity$app_debug {
  private ActivitiesModule_ContributesCartActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(CartActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      CartActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface CartActivitySubcomponent extends AndroidInjector<CartActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<CartActivity> {}
  }
}
